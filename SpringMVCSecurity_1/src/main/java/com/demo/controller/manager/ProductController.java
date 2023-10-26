package com.demo.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"manager/product"})
public class ProductController {
	@RequestMapping(value = { "index","/","" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "manager/product/index";
	}
}
