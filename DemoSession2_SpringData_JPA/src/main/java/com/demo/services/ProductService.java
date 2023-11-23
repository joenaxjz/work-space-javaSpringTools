package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.dtos.ProductDTO;
import com.demo.entities.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	public Product find(int id);
	
	public boolean save(Product product);
	
	public boolean delete(int id);
	
	public List<Product> findByStatus(boolean status);
	
	public List<Product> findByPrice(double min, double max);
	
	public List<Product> findByKeyword(String keyword);

	public List<Product> findByYear(int year);
	
	public List<Product> findByYearandMonth(int year, int month);

	public List<Product> findByDates(Date startDate, Date endDate);

	public List<Product> sort1();
	
	public List<Product> sort2(boolean status);
	
	public List<Product> limit1(int n);

	public List<Product> limit2(int start, int n);
	
	public List<Product> limit3(int start, int n, boolean status);
	
	public long count1();

	public long sum1();

	public long sum2(boolean stautus);
	
	public long sum3(boolean stautus);

	public double maxPrice();
	
	public double minPrice();
	
	public double avgPrice();

	public long count2(boolean status);
	
	public List<Product> searchByKeyword(String keyword);

	public ProductDTO find2(int id);

	public List<ProductDTO> findAll2();
	
	public List<String> findByKeywordAutoComplete(String keyword);
	
	public List<ProductDTO> findByKeywordDTO(String keyword);
	
	public Page<Product> findPagingnation(int pageNo, int pageSize);
}
