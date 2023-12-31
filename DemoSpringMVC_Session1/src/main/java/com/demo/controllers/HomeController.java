package com.demo.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileHelper;
import com.demo.services.CalculateService;
import com.demo.services.CalculateServiceImpl;
import com.demo.services.DemoService;
import com.demo.services.DemoServiceImpl;
import com.demo.services.ProductService;
import com.demo.services.RectangleService;

@Controller
@RequestMapping({"home"}) //multi-link
public class HomeController {
	
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
	
		return "home/index";
	}
	
	
}
