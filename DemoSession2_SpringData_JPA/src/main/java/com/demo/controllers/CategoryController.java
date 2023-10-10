package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Category;
import com.demo.services.CategoryService;

@Controller
@RequestMapping({ "category" }) // multi-link
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("categories", categoryService.findAll());
		return "category/index";
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String addCate(ModelMap modelMap) {
		modelMap.put("category", new Category());
		return "category/add";
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
		if(categoryService.save(category)) {
			redirectAttributes.addFlashAttribute("msg", "Successed");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/category/index";
	}
	
	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		if(categoryService.delete(id)) {
			redirectAttributes.addFlashAttribute("msg", "Successed");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/category/index";
	}
}
