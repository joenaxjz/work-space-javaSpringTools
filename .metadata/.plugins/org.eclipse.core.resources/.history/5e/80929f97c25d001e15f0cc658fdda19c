package com.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Account;
import com.demo.services.LanguageService;

@Controller
@RequestMapping({"account"}) //multi-link
public class AccountController {
	
	@Autowired
	private LanguageService languageService;
	
	
	@RequestMapping(value = { "register", "" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		account.setUsername("acc1");
		account.setDoB(new Date());
		account.setStatus(true);
		account.setLanguages(new int[] {1, 2, 3});
		modelMap.put("account", account);
		modelMap.put("languages", languageService.findAll());
		return "account/register";
	}
	
	
	@RequestMapping(value = { "register", "" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account) {
		System.out.println("Account Info");
		System.out.println("Account usenrame:" + account.getUsername());
		System.out.println("Account password:" + account.getPassword());
		System.out.println("Account des:" + account.getDescription());
		System.out.println("Account details:" + account.getDetails());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("dob: " + simpleDateFormat.format(account.getDoB()));
		System.out.println("Account status:" + account.isStatus());
		for(int langId : account.getLanguages()) {
			System.out.println(langId);

		}
		System.out.println("Gender:" + account.getGender());

		return "redirect:/account/register";
	}
}
