package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "demo3" }) // multi-link
public class Demo3Controller {
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "demo3/index";
	}
	@RequestMapping(value = { "index1" }, method = RequestMethod.GET)
	public String index1(ModelMap modelMap, HttpServletRequest request) {
		
		if(request.getAttribute("id") != null) {
			System.out.println("id - controller:" + request.getAttribute("id").toString());
		}
		
		if(request.getAttribute("username") != null) {
			System.out.println("username - controller:" + request.getAttribute("username").toString());
		}
		
		return "demo3/index1";
	}
	
}
