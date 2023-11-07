package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Account;
import com.demo.helpers.RandomHelper;
import com.demo.services.AccountService;
import com.demo.services.CategoryService;
import com.demo.services.MailService;
import com.demo.services.RoleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "account" }) // multi-link
public class AccountController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private Environment environment;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		return "account/login";
	}

	@RequestMapping(value = { "success" }, method = RequestMethod.GET)
	public String success(ModelMap modelMap) {
		return "account/success";
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
	public String login(RedirectAttributes redirectAttribute, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {

		if (accountService.login(username, password) != null) {
			session.setAttribute("username", username);
			return "redirect:/account/success";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/account/login";
		}
	}
	
	@RequestMapping(value = { "forgetPassword" }, method = RequestMethod.GET)
	public String forgetPassword() {
		return "account/forgetPassword";
	}
	
	@RequestMapping(value = { "forgetPassword" }, method = RequestMethod.POST)
	public String forgetPassword(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
		Account account = accountService.findByEmail(email);
		if(account == null) {
			redirectAttributes.addFlashAttribute("msg", "Email không tồn tại");
			return "account/forgetPassword";
		} else {
			String securityCode = RandomHelper.random();
			String email1 = environment.getProperty("spring.mail.username");
			String content = "Nhan vao <a href='http://localhost:8088/account/resetpassword?username=" + account.getUsername() + "&securityCode=" + securityCode + "'>day</a> de reset password";
			mailService.send(email1, account.getEmail(), "Verify Email", content);
			return "account/login";
		}
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		modelMap.put("roles", roleService.findAll());
		return "account/register";
	}

	@RequestMapping(value = { "verify" }, method = RequestMethod.GET)
	public String verify(@RequestParam("username") String username, @RequestParam("securityCode") String securityCode,
			RedirectAttributes redirectAttribute) {
		Account account = accountService.findByUsername(username);
		if (account == null) {
			redirectAttribute.addFlashAttribute("msg", "tai khoan ko ton tai");
		} else {
			if (account.getSecurityCode().equals(securityCode)) {
				account.setStatus(true);
				if (accountService.save(account)) {
					redirectAttribute.addFlashAttribute("msg", "tai khoan kich hoat thanh cong");
				} else {
					redirectAttribute.addFlashAttribute("msg", "tai khoan khong kich hoat duoc");
				}
			} else {
				redirectAttribute.addFlashAttribute("msg", "tai khoan khong kich hoat duoc");
			}
		}

		return "redirect:/account/login";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account, RedirectAttributes redirectAttribute) {
		account.setStatus(false);
		String securityCode = RandomHelper.random();
		account.setSecurityCode(securityCode);
		if (accountService.save(account)) {
			String email = environment.getProperty("spring.mail.username");
			String content = "Nhan vao <a href='http://localhost:8088/account/verify?username=" + account.getUsername()
					+ "&securityCode=" + securityCode + "'>day</a> de kich hoat tai khoan";
			redirectAttribute.addFlashAttribute("msg", "Successed");
			mailService.send(email, account.getEmail(), "Verify Email", content);
			return "redirect:/account/login";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/account/register";
		}

	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile(HttpSession session, ModelMap modelMap) {
		String username = session.getAttribute("username").toString();
		modelMap.put("account", accountService.findByUsername(username));
		modelMap.put("roles", roleService.findAll());
		return "account/profile";
	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.POST)
	public String profile(@ModelAttribute("account") Account account, HttpSession session,
			RedirectAttributes redirectAttribute) {
		Account currentAccount = accountService.findByUsername(account.getUsername());
		account.setSecurityCode(currentAccount.getSecurityCode());
		account.setStatus(currentAccount.isStatus());
		if (account.getPassword().isEmpty()) {
			account.setPassword(currentAccount.getPassword());
		}
		if (accountService.save(account)) {
			redirectAttribute.addFlashAttribute("msg", "Updated");
			return "redirect:/account/success";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/account/profile";
		}

	}
}
