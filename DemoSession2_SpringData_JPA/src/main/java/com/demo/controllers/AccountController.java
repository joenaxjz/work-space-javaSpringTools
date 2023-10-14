package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Account;
import com.demo.services.AccountService;
import com.demo.services.CategoryService;
import com.demo.services.RoleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "account" }) // multi-link
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RoleService roleService;

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
		
		if(accountService.login(username, password) != null) {
			session.setAttribute("username", username);
			return "redirect:/account/success";
		}else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/account/login";
		}
	}
	
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		modelMap.put("account", account);
		modelMap.put("roles", roleService.findAll());
		return "account/register";
	}
	
	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account, RedirectAttributes redirectAttribute) {
		account.setStatus(true);
		account.setSecurityCode("unverify");
		if(accountService.save(account)) {
			return "redirect:/account/login";
		}else {
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
			RedirectAttributes redirectAttribute ) {
		Account currentAccount = accountService.findByUsername(account.getUsername());
		account.setSecurityCode(currentAccount.getSecurityCode());
		account.setStatus(currentAccount.isStatus());
		if(account.getPassword().isEmpty()) {
			account.setPassword(currentAccount.getPassword());
		}
		if(accountService.save(account)) {
			redirectAttribute.addFlashAttribute("msg", "Updated");
			return "redirect:/account/success";
		}else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/account/profile";
		}
		
	}
}
