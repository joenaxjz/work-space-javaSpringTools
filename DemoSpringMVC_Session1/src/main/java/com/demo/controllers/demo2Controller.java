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
@RequestMapping({"demo2"}) //multi-link
public class demo2Controller {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RectangleService rectangleService;
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("rs1", demoService.hello());
		modelMap.put("rs2", demoService.hi("tuan anh"));
		modelMap.put("rs3", rectangleService.area(4.3, 9.3));
		modelMap.put("rs4", rectangleService.perimeter(9.3, 2.3));

		return "demo2/index";
	}
	
	@RequestMapping(value = { "index2" }, method = RequestMethod.GET)
	public String index2(ModelMap modelMap) {
		modelMap.put("product", productService.find());
		return "demo2/index2";
	}
	
	@RequestMapping(value = { "index3" }, method = RequestMethod.GET)
	public String index3(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "demo2/index3";
	}
	
	@RequestMapping(value = { "details/{id}" }, method = RequestMethod.GET)
	public String details(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("product", productService.findById(id));
		return "demo2/details";
	}
	
}
