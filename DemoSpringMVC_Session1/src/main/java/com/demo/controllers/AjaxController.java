package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.City;
import com.demo.entities.Product;
import com.demo.services.AccountService;
import com.demo.services.CountryService;
import com.demo.services.ProductService;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = "ajax1", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax1() {
		return "hello ajax";
	}
	
	@RequestMapping(value = "ajax2", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax2(@RequestParam("fullName") String fullName) {
		
		return "hello " + fullName;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if(accountService.login(username, password))
		{
			return "Valid";
		}
		else {
			return "Invalid";
		}
		
	}
	
	@RequestMapping(value = "find", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public Product find() {
		return productService.find();
	}
	
	
	@RequestMapping(value = "findCountryById", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<City> findCountryById(@RequestParam("id") int id) {
		return countryService.find(id).getCities();
	}
	
	@RequestMapping(value = "searchByKeyword", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<Product> searchByKeyword(@RequestParam("keyword") String keyword) {
		return productService.findByKeyword(keyword);
	}
	
	@RequestMapping(value = {"findAll", "findall"}, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<Product> findAll() {
		return productService.findAll();
	}
}
