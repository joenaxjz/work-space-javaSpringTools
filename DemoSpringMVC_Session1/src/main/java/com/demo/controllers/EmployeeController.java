package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entities.Employee;
import com.demo.validators.employeeValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping({ "employee" }) // multi-link
public class EmployeeController {
	
	@Autowired
	private employeeValidator empValidator;
	
	@RequestMapping(value = { "register", "" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Employee emp = new Employee();
		modelMap.put("employee", emp);
		return "employee/register";
	}
	
	@RequestMapping(value = { "register", "" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("employee") @Valid Employee emp, BindingResult bR) {
		empValidator.validate(emp, bR);
		if(bR.hasErrors()) {
			return "employee/register";

		} else {
		System.out.print("username: "+ emp.getUsername());
		return "employee/success";
		}
	}
}
