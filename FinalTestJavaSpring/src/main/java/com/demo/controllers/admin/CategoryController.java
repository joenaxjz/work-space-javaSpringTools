package com.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/admin/category"})
public class CategoryController {

	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "/admin/category/index";
	}
}