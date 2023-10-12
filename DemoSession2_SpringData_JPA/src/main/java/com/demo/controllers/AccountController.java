package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.AccountService;
import com.demo.services.CategoryService;

@Controller
@RequestMapping({ "account" }) // multi-link
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		return "account/login";
	}
	
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		return "account/register";
	}
}
