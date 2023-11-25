package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Product;
import com.demo.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> find (){
		try {
			return new ResponseEntity<Product> (productService.find(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Product> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = {"findAll", "findall"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findAll (){
		try {
			return new ResponseEntity<List<Product>> (productService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Product>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "create", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create (@RequestBody Product product){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = productService.Create(product);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "update", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update (@RequestBody Product product){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = productService.update(product);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "delete/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete (@PathVariable("id") int id){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = productService.delete(id);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
