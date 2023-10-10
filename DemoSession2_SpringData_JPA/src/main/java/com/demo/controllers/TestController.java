package com.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.services.CategoryService;
import com.demo.services.InvoiceService;
import com.demo.services.ProductService;

@Controller
@RequestMapping({ "test" }) // multi-link
public class TestController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value = { "invoice" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("invoices", invoiceService.findAll());
		return "invoice/index";
	}

}
