package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"demo", "abc", "def"}) //multi-link
public class demoController {
	
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("id", 123);
		modelMap.put("username", "acc1");
		modelMap.put("price", 4.5);
		modelMap.put("status", true);
		modelMap.put("photo" , "pic2.jpg");
		modelMap.put("width", 70);
		modelMap.put("height", 100);
		List<String> names = new ArrayList<String>();
		names.add("name1");
		names.add("name2");
		names.add("name3");
		names.add("name4");
		names.add("name5");
		modelMap.put("names", names);
		return "demo/index";
	}
	
	
	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public String index2() {
		return "demo/index2";
	}
	
	
	@RequestMapping(value = "index3/{id}", method = RequestMethod.GET)
	public String index3(@PathVariable("id") int id) {
		System.out.println("ID: " + id);
		return "demo/index3";
	}
	
	@RequestMapping(value = "index4/{id}/{username}", method = RequestMethod.GET)
	public String index4(@PathVariable("id") int id, @PathVariable("username") String username) {
		System.out.println("ID: " + id);
		System.out.println("Username: " + username);
		return "demo/index4";
	}
	
	
	@RequestMapping(value = "index5", method = RequestMethod.GET)
	public String index5(@RequestParam("id") int id, @RequestParam("username") String username) {
		System.out.println("ID: " + id);
		System.out.println("Username: " + username);
		return "demo/index5";
	}
}
