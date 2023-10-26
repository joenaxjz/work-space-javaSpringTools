package com.demo.service;

import java.util.Date;
import java.util.List;

import com.demo.entities.Product;

public interface ProductService {
	public Iterable<Product> findAll();

	// find product
	public Product find(int id);

	// save => insert, update
	public boolean save(Product product);

	public boolean delete(int id);

	public List<Product> findByStatus(boolean status);

	public List<Product> findBykeyword(String keyword);

	// findbyyear
	public List<Product> findByYear(int year);

	// findbyYearAndMonth
	public List<Product> findByYearAndMonth(int year, int month);

	// find product by start and end
	
	public List<Product> findByDates(Date startDate, Date endDate);
	
	//find product by product sort desc
	
	public List<Product> sort1();
	public List<Product> sort2(boolean status);
	
	
	public List<Product> limit1(int n);
	public List<Product> limit2(int start, int end);
	
	public long count1();
	public long count2(boolean status);
	public long sum1();
	
	public double sum2();
	public double max();
	public double min();
	public double avg();
	
	

}
