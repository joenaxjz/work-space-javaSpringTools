package com.demo.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Nhanvien;
import com.demo.services.AccountService;
import com.demo.services.QuyenService;
import com.demo.services.RequestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "admin/employee" }) // multi-link
public class AdminEmployeeController {

	@Autowired
	private AccountService nhanvienService;

	@Autowired
	private QuyenService roleService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private RequestService requestService;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "failed", required = false) String failed, ModelMap modelMap) {
		if (failed != null) {
			modelMap.put("msg", "Re-check your information");
		}
		return "account/login";
	}
	
	@RequestMapping(value = { "list" }, method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.put("nhanviens", nhanvienService.findAll());
		return "admin/employee/list";
	}

	@RequestMapping(value = { "success" }, method = RequestMethod.GET)
	public String success(Authentication authentication) {
		System.out.println("username: " + authentication.getName());
		return "account/success";
	}
	
	@RequestMapping(value = { "accessdenied" }, method = RequestMethod.GET)
	public String accessdenied(Authentication authentication) {
		return "account/accessdenied";
	}

//	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
//	public String login(RedirectAttributes redirectAttribute, @RequestParam("username") String username,
//			@RequestParam("password") String password, HttpSession session) {
//
//		if (accountService.login(username, password) != null) {
//			session.setAttribute("username", username);
//			return "redirect:/account/success";
//		} else {
//			redirectAttribute.addFlashAttribute("msg", "Failed");
//			return "redirect:/account/login";
//		}
//	}
	


	@RequestMapping(value = { "createAccount"}, method = RequestMethod.GET)
	public String createAccount(ModelMap modelMap) {
		Nhanvien account = new Nhanvien();
		modelMap.put("nhanvien", account);
		modelMap.put("roles", roleService.findAll());
		return "admin/employee/createAccount";
	}


	@RequestMapping(value = { "createAccount"}, method = RequestMethod.POST)
	public String register(@ModelAttribute("nhanvien") Nhanvien nhanvien, RedirectAttributes redirectAttribute) {
		nhanvien.setKichhoat("da kich hoat");
		nhanvien.setHinhanh("image1.jpg");
		nhanvien.setPassword(encoder.encode(nhanvien.getPassword()));
		System.out.println(nhanvien);
		if (nhanvienService.save(nhanvien)) {
			return "redirect:list";
		} else {
			return "redirect:createAccount";
		}

	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile(Authentication authentication, HttpSession session, ModelMap modelMap) {
		String username = authentication.getName();
		modelMap.put("account", nhanvienService.findByUsername(username));
		modelMap.put("roles", roleService.findAll());
		return "account/profile";
	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.POST)
	public String profile(@ModelAttribute("nhanvien") Nhanvien nhanvien, Authentication authentication,
			RedirectAttributes redirectAttribute) {
		Nhanvien currentAccount = nhanvienService.findByUsername(authentication.getName());
		if (nhanvien.getPassword().isEmpty()) {
			nhanvien.setPassword(currentAccount.getPassword());
		}
		else {
			nhanvien.setPassword(encoder.encode(nhanvien.getPassword()));
		}
		if (nhanvienService.save(nhanvien)) {
			redirectAttribute.addFlashAttribute("msg", "Updated");
			return "redirect:account/success";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:account/profile";
		}
	}

	
}
