package com.demo.controllers;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileHelper;

@RestController
@RequestMapping("api/demo")
public class DemoController {
	
	@Autowired
	private Environment environment;

	@GetMapping(value = "demo1", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo1 (){
		try {
			return new ResponseEntity<String> ("Hello world",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "demo2", produces = MimeTypeUtils.TEXT_HTML_VALUE)
	public ResponseEntity<String> demo2 (){
		try {
			return new ResponseEntity<String> ("<b><u>Hello world</u></b>",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "demo3", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> demo3 (){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public int id = 123;
				public String username = "acc1";
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "demo4/{id}", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo4 (@PathVariable("id") int id){
		try {
			System.out.println("id: " + id);
			return new ResponseEntity<String> ("Hello world",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "demo5/{from}/{to}", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo5 (@PathVariable("from") String from, @PathVariable("to") String to){
		try {
			SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
			Date start = date1.parse(from);
			Date end = date1.parse(to);
			
			SimpleDateFormat date2 = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("start: " + date2.format(start));
			System.out.print("end: " + date2.format(end));

			return new ResponseEntity<String> ("Hello world",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "upload", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> upload (@RequestParam("file") MultipartFile file){
		try {
			String fileName = FileHelper.generateFileName(file.getOriginalFilename());
			File uploadFolder = new File(new ClassPathResource(".").getFile().getPath() + "/static/assets/upload");
			if (!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}
			Path path = Paths.get(uploadFolder.getAbsolutePath() + File.separator + fileName);
            System.out.println(path);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			return new ResponseEntity<Object> (new Object() {
				public String url = environment.getProperty("UPLOAD_URL") + fileName;
			}, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "uploads", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> uploads (@RequestParam("files") MultipartFile[] files){
		try {
			File uploadFolder = new File(new ClassPathResource(".").getFile().getPath() + "/static/assets/upload");
			if (!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}
			System.out.println("File List");
			List<String> fileNames = new ArrayList<String>();
			
			for (MultipartFile file : files) {
				System.out.println("File Info");
				System.out.println("name: " + file.getOriginalFilename());
				System.out.println("type: " + file.getContentType());
				System.out.println("size: " + file.getSize());
				System.out.println("=============================");
				
				//
				String fileName = FileHelper.generateFileName(file.getOriginalFilename());

				Path path = Paths.get(uploadFolder.getAbsolutePath() + File.separator + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				fileNames.add(environment.getProperty("UPLOAD_URL") + fileName);
			}
			
			return new ResponseEntity<Object> ( new Object() {
				public List<String> urls = fileNames;
			}, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
}
