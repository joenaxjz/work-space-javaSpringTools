package com.demo.controllers.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Account;
import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.helpers.RandomHelper;
import com.demo.service.AccountService;
import com.demo.service.CategoryService;
import com.demo.service.MailService;
import com.demo.service.ProductService;
import com.demo.service.RoleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "account" })
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping(value = { "welcome"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "account/welcome";
	}
	
	@RequestMapping(value = { "profile" }, method = RequestMethod.POST)
	public String profile(@ModelAttribute("account") Account account, HttpSession sesssion,
			RedirectAttributes redirectAttributes) {
		Account currentAccount = accountService.findByUsername(account.getUsername());
		account.setSecurityCode(currentAccount.getSecurityCode());
		account.setStatus(currentAccount.isStatus());
		if(account.getPassword().isEmpty()) {
			account.setPassword(currentAccount.getPassword());
		}
		if(accountService.save(account)) {
			return "redirect:/account/accountDetail";
		}else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
			return "redirect:/account/profile";
		}
		
	}
	
	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile(HttpSession session, ModelMap modelMap) {
		String username = session.getAttribute("username").toString();
		modelMap.put("account", accountService.findByUsername(username));
		modelMap.put("roles", roleService.findAll());
		return "account/profile";
	}
	
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
		if(error != null) {
			modelMap.put("msgErr", "Account Failed");
		}
		return "account/login";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		modelMap.put("roles", roleService.findAll());
		return "account/register";
	}
	
	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account,
			RedirectAttributes redirectAttributes) {
		account.setStatus(true);
		// ma hoa password truoc khi luu
		account.setPassword(encoder.encode(account.getPassword()));
		String securityCode = RandomHelper.random();
		account.setSecurityCode(securityCode);
		if(accountService.save(account)) {
			// Gui email
			String email = environment.getProperty("spring.mail.username");
			String content = "Nhan vao <a href='http://localhost:8080/account/verify?username="+account.getUsername()+"&securityCode="+securityCode+"'>here</a> de kich hoat tai khoan";
			mailService.send(email, account.getEmail(), "Verify Email", content);
			return "redirect:/account/login";
		}else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
			return "redirect:/account/register";
		}
		
	}
	
	
//	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
//	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
//	        RedirectAttributes redirectAttributes, HttpSession session) {
//	    Account account = accountService.login(username, password);
//	    if (account != null) {
//	        // Đăng nhập thành công, thực hiện các xử lý cần thiết và trả về view.
//	    	session.setAttribute("username", username);
//	        return "account/accountDetail";
//	    } else {
//	        // Đăng nhập thất bại, thêm thông báo và chuyển hướng trở lại trang đăng nhập.
//	        redirectAttributes.addFlashAttribute("msg", "Failed");
//	        return "redirect:/account/login";
//	    }
//	}
	
	@RequestMapping(value = { "verify" }, method = RequestMethod.GET)
	public String verify(@RequestParam("username") String username,
			@RequestParam("securityCode") String securityCode,RedirectAttributes redirectAttributes) {
		Account account = accountService.findByUsername(username);
		if(account == null) {
			redirectAttributes.addFlashAttribute("msg", "Tai khoan khong ton tai");
		}else {
			if(account.getSecurityCode().equals(securityCode)) {
				account.setStatus(true);
				accountService.save(account);
			}else {
				redirectAttributes.addFlashAttribute("msg", "Tai khoan khong kich hoat");
			}
		}
		return "redirect:/account/login";
		
	}
	
	
	@RequestMapping(value = { "forgetPassword" }, method = RequestMethod.POST)
	public String verify(@RequestParam("email") String email
			) {
		Account account = accountService.findByEmail(email);
		if(account == null) {
			return "account/forgetPassword";
		}else {
			String securityCode = RandomHelper.random();
			account.setSecurityCode(securityCode);
			accountService.save(account);
			String content = "Nhan vao <a href='http://localhost:8080/account/resetpassword?email="+account.getEmail()+"&securityCode="+securityCode+"'>here</a> de reset tai khoan";
			mailService.send(environment.getProperty("spring.mail.username"), account.getEmail(), "Verify Email", content);
			return "account/login";
		}
		
		
	}
	
	
	
	
	
	
}