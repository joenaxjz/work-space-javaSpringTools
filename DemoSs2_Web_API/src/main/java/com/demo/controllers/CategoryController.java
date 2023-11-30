package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dtos.CategoryDTO;
import com.demo.entities.Category;
import com.demo.services.CategoryService;

@Controller
@RequestMapping({ "api/category" }) // multi-link
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = {"find/{id}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> find (@PathVariable("id") int id){
		try {
			return new ResponseEntity<CategoryDTO> (categoryService.find(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CategoryDTO> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = {"findAll"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> findAll (){
		try {
			return new ResponseEntity<List<CategoryDTO>> (categoryService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<CategoryDTO>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = {"findByKeyword/{keyword}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> findByKeyword(@PathVariable("keyword") String keyword){
		try {
			return new ResponseEntity<List<CategoryDTO>> (categoryService.findByKeyword(keyword), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<CategoryDTO>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = {"create"}, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody CategoryDTO categoryDTO){
		try {
			return new ResponseEntity<Object> (new Object() {
				public boolean status = categoryService.save(categoryDTO);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = {"update"}, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody CategoryDTO categoryDTO){
		try {
			return new ResponseEntity<Object> (new Object() {
				public boolean status = categoryService.save(categoryDTO);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = {"delete/{id}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete (@PathVariable("id") int id){
		try {
			return new ResponseEntity<Object> (new Object() {
				public boolean status = categoryService.delete(id);
			}, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
}
