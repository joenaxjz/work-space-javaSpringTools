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

import com.demo.entities.Employee;
import com.demo.entities.Product;
import com.demo.services.EmployeeService;
import com.demo.services.ProductService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> find (){
		try {
			return new ResponseEntity<Employee> (employeeService.find(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = {"findAll", "findall"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> findAll (){
		try {
			return new ResponseEntity<List<Employee>> (employeeService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<Employee>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "create", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create (@RequestBody Employee employee){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = employeeService.Create(employee);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "update", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update (@RequestBody Employee employee){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = employeeService.update(employee);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "delete/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete (@PathVariable("id") int id){
		try {
			return new ResponseEntity<Object> ( new Object () {
				public boolean status = employeeService.delete(id);
			}, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
