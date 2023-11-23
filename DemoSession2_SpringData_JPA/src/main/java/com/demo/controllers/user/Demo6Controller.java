package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.services.CategoryService;
import com.demo.services.LanguageService;
import com.demo.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "demo6" }) // multi-link
public class Demo6Controller {
	
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private LanguageService langService;
//	
//	@Autowired
//	private CategoryService categoryService;
	
	@GetMapping({ "index" })
	public String index(ModelMap modelMap) {
		return "demo6/index";
	}
	
	@GetMapping({ "index2" })
	public String index2(ModelMap modelMap) {
		return "demo6/index2";
	}

	@GetMapping({ "index3" })
	public String index3(ModelMap modelMap) {
		return "demo6/index3";
	}
	
}
