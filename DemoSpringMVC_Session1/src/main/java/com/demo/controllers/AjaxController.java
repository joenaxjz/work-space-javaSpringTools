package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.AccountService;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "ajax1", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax1() {
		return "hello ajax";
	}
	
	@RequestMapping(value = "ajax2", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax2(@RequestParam("fullName") String fullName) {
		
		return "hello " + fullName;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if(accountService.login(username, password))
		{
			return "Valid";
		}
		else {
			return "Invalid";
		}
		
	}
}
