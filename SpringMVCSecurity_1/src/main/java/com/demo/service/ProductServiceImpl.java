package com.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.reponsitory.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	@Override
	public Product find(int id) {
		// give id -> object product
		return productRepository.findById(id).get();
	}
	@Override
	public boolean save(Product product) {
		try {
			productRepository.save(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(int id) {
		try {
			productRepository.delete(find(id));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Product> findByStatus(boolean status) {
		return productRepository.findByStatus(status);
	}
	@Override
	public List<Product> findBykeyword(String keyword) {		// TODO Auto-generated method stub
		return productRepository.findBykeyword(keyword);
	}
	// findbyyear
	@Override
	public List<Product> findByYear(int year) {
		// TODO Auto-generated method stub
		return productRepository.findByYear(year);
	}
	@Override
	public List<Product> findByYearAndMonth(int year, int month) {
		return productRepository.findByYearAndMonth(year,month);
	}
	@Override
	public List<Product> findByDates(Date startDate, Date endDate) {
		return productRepository.findByDates(startDate, endDate);
	}
	@Override
	public List<Product> sort1() {
		// TODO Auto-generated method stub
		return productRepository.Sort1();
	}
	@Override
	public List<Product> sort2(boolean status) {
		
		return productRepository.Sort2(status);
	}
	@Override
	public List<Product> limit1(int n) {
		return productRepository.Limit1(n);
	} 
	
	
	@Override
	public List<Product> limit2(int start, int end) {
		return productRepository.Limit2(start, end);
	}
	@Override
	public long count1() {
		// hàm count là hàm có sẵn trong data spring jpa
		return productRepository.count();
	} 
	
	@Override
	public long count2(boolean status) {
		// hàm count là hàm có sẵn trong data spring jpa
		return productRepository.count2(status);
	} 
	@Override
	public long sum1() {
		return productRepository.sum1();
	} 
	@Override
	public double sum2() {
		return productRepository.sum2();
	} 
	
	@Override
	public double max() {
		return productRepository.max();
	} 
	@Override
	public double min() {
		return productRepository.min();
	} 
	@Override
	public double avg() {
		return productRepository.avg();
	} 
	
	
	
	
	
	
	
	
	
	

}
