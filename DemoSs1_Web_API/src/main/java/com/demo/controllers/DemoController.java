package com.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo")
public class DemoController {

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
	
}
