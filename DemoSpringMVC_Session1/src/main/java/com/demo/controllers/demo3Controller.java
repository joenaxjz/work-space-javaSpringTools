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
@RequestMapping({"demo3"}) //multi-link
public class demo3Controller {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RectangleService rectangleService;
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
	
		return "demo3/index";
	}
	
	@RequestMapping(value = { "searchByKeyword", "" }, method = RequestMethod.GET)
	public String searchByKeyword(@RequestParam("keyword") String keyword) {
		System.out.println("keyword: " + keyword);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "searchByPrice", "" }, method = RequestMethod.GET)
	public String searchByPrice(@RequestParam("min") int min, @RequestParam("max") int max) {
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "login", "" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "update1", "" }, method = RequestMethod.POST)
	public String update1(@RequestParam("emails") String[] emails) {
		for (String email : emails) {
			System.out.println("email: " + email);
		}

		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "update2", "" }, method = RequestMethod.POST)
	public String update2(@RequestParam("quans") String[] quans) {
		for (String quan : quans) {
			System.out.println("quan: " + quan);
		}

		return "redirect:/demo3/index";
	}
	
	@RequestMapping(value = { "upload", "" }, method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
		
		System.out.println("Info");
		System.out.println(file.getOriginalFilename()); //file name
		System.out.println(file.getSize()); //file size
		System.out.println(file.getContentType()); //file type
		
		// upload file
		try {
			File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
			
			String fileName = FileHelper.generateFileName(file.getOriginalFilename());
			
			Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println(folderImage.getAbsolutePath() + File.separator + fileName);
			modelMap.put("fileName", fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "demo3/result1";
	}
	
	@RequestMapping(value = { "uploads", "" }, method = RequestMethod.POST)
	public String uploads(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {
		
		System.out.println("Info");
		
		List<String> fileNames = new ArrayList<String>();
		
		for(MultipartFile file: files) {
		System.out.println(file.getOriginalFilename()); //file name
		System.out.println(file.getSize()); //file size
		System.out.println(file.getContentType()); //file type
		System.out.println("-----------------");
		
		try {
			File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
			
			String fileName = FileHelper.generateFileName(file.getOriginalFilename());
			
			Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			fileNames.add(fileName);
//			System.out.println(folderImage.getAbsolutePath() + File.separator + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		modelMap.put("fileNames", fileNames);
		return "demo3/result2";
	}
	
	@RequestMapping(value = { "login1", "" }, method = RequestMethod.GET)
	public String login1() {
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
		return "/demo3/login";
	}
}
