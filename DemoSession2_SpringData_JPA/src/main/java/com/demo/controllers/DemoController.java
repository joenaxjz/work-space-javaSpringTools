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
import com.demo.services.ProductService;

@Controller
@RequestMapping({ "demo" }) // multi-link
public class DemoController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("categories", categoryService.findAll());
		return "demo/index";
	}

	@RequestMapping(value = { "index2" }, method = RequestMethod.GET)
	public String index2(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "demo/index2";
	}

	@RequestMapping(value = { "index3" }, method = RequestMethod.GET)
	public String index3(ModelMap modelMap) {
		modelMap.put("product", productService.find(2));
		return "demo/index3";
	}

	// insert new product
	@RequestMapping(value = { "index4" }, method = RequestMethod.GET)
	public String index4(ModelMap modelMap) {
		Product product = new Product();
		Category cate = new Category();
		cate.setId(1);
		product.setCategory(cate);
		product.setCreated(new Date());
		product.setDescription("AAAA");
		product.setName("san pham loi");
		product.setPhoto("pic3.jpg");
		product.setPrice(4.8);
		product.setQuantity(4);
		product.setStatus(true);
		System.out.println("status: " + productService.save(product));
		return "redirect:/demo/index2";
	}

	// update product
	@RequestMapping(value = { "index5" }, method = RequestMethod.GET)
	public String index5(ModelMap modelMap) {
		Product product = productService.find(10);
		Category cate = new Category();
		cate.setId(3);
		product.setCategory(cate);
		product.setCreated(new Date());
		product.setDescription("Avvvv");
		product.setName("san pham da duoc cap nhat");
		product.setPhoto("pic3.jpg");
		product.setPrice(4.8);
		product.setQuantity(4);
		product.setStatus(true);
		System.out.println("status: " + productService.save(product));
		return "redirect:/demo/index2";
	}

	// delete product
	@RequestMapping(value = { "index6" }, method = RequestMethod.GET)
	public String index6(ModelMap modelMap) {
		System.out.println("status: " + productService.delete(9));
		return "redirect:/demo/index2";

	}

	// find product by status
	@RequestMapping(value = { "index7" }, method = RequestMethod.GET)
	public String index7(ModelMap modelMap) {
		modelMap.put("products", productService.findByStatus(true));
		return "demo/index4";

	}

	// find product by status
	@RequestMapping(value = { "index8" }, method = RequestMethod.GET)
	public String index8(ModelMap modelMap) {
		modelMap.put("products", productService.findByPrice(80, 160));
		return "demo/index5";

	}
	
	// find product by status
		@RequestMapping(value = { "index9" }, method = RequestMethod.GET)
		public String index9(ModelMap modelMap) {
			modelMap.put("products", productService.findByKeyword("s"));
			return "demo/index6";

		}

}
