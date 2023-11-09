package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.CategoryService;
import com.demo.services.LanguageService;
import com.demo.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "demo5" }) // multi-link
public class Demo5Controller {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private LanguageService langService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		modelMap.put("langs", langService.findAll());
		return "demo5/index";
	}

	
}
