package com.demo.services;

import java.util.List;

import com.demo.entities.Employee;
import com.demo.entities.Product;

public interface EmployeeService {
	
	public Employee find();
	
	public List<Employee> findAll();
	
	public boolean Create (Employee product);
	
	public boolean update (Employee product);
	
	public boolean delete (int id);


}
