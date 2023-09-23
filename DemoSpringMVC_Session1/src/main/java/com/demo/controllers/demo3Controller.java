package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.services.CalculateService;
import com.demo.services.CalculateServiceImpl;
import com.demo.services.DemoService;
import com.demo.services.DemoServiceImpl;
import com.demo.services.ProductService;
import com.demo.services.RectangleService;

@Controller
@RequestMapping({"demo3"}) //multi-link
public class demo3Controller {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RectangleService rectangleService;
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
	
		return "demo3/index";
	}
	
	@RequestMapping(value = { "searchByKeyword", "" }, method = RequestMethod.GET)
	public String searchByKeyword(@RequestParam("keyword") String keyword) {
		System.out.println("keyword: " + keyword);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "searchByPrice", "" }, method = RequestMethod.GET)
	public String searchByPrice(@RequestParam("min") int min, @RequestParam("max") int max) {
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "login", "" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "update1", "" }, method = RequestMethod.POST)
	public String update1(@RequestParam("emails") String[] emails) {
		for (String email : emails) {
			System.out.println("email: " + email);
		}

		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "update2", "" }, method = RequestMethod.POST)
	public String update2(@RequestParam("quans") String[] quans) {
		for (String quan : quans) {
			System.out.println("quan: " + quan);
		}

		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "login1", "" }, method = RequestMethod.GET)
	public String login1() {
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
		return "/demo3/login";
	}
}