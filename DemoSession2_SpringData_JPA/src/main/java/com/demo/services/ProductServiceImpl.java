package com.demo.services;


import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dtos.ProductDTO;
import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product find(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public boolean save(Product product) {
		try {
			productRepo.save(product);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			productRepo.delete(find(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.findByStatus(status);
	}

	@Override
	public List<Product> findByPrice(double min, double max) {
		return productRepo.findByPrice(min, max);
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		return productRepo.findByKeyword(keyword);
	}

	@Override
	public List<Product> findByYear(int year) {
		return productRepo.findByYear(year);
	}

	@Override
	public List<Product> findByYearandMonth(int year, int month) {
		// TODO Auto-generated method stub
		return productRepo.findByYearandMonth(year, month);
	}

	@Override
	public List<Product> findByDates(Date startDate, Date endDate) {
		
		return productRepo.findByDates(startDate, endDate);
	}

	@Override
	public List<Product> sort1() {
		// TODO Auto-generated method stub
		return productRepo.sort1();
	}

	@Override
	public List<Product> sort2(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.sort2(status);
	}

	@Override
	public List<Product> limit1(int n) {
		// TODO Auto-generated method stub
		return productRepo.limit1(n);
	}
	
	@Override
	public List<Product> limit2(int start, int n) {
		// TODO Auto-generated method stub
		return productRepo.limit2(start, n);
	}

	@Override
	public List<Product> limit3(int start, int n, boolean status) {
		
		return productRepo.limit3(start, n, status);
	}

	@Override
	public long count1() {
		// TODO Auto-generated method stub
		return productRepo.count();
	}

	@Override
	public long count2(boolean stautus) {
		
		return productRepo.count2(stautus);
	}

	@Override
	public long sum1() {
		
		return productRepo.sum1();
	}

	@Override
	public long sum2(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.sum2(status);
	}
	
	@Override
	public long sum3(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.sum3(status);
	}

	@Override
	public double maxPrice() {
		// TODO Auto-generated method stub
		return productRepo.maxPrice();
	}

	@Override
	public double minPrice() {
		// TODO Auto-generated method stub
		return productRepo.minPrice();
	}

	@Override
	public double avgPrice() {
		// TODO Auto-generated method stub
		return productRepo.avgPrice();
	}

	@Override
	public List<Product> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO find2(int id) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepo.findById(id).get(), ProductDTO.class);
	}

	@Override
	public List<ProductDTO> findAll2() {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepo.findAll(), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public List<String> findByKeywordAutoComplete(String keyword) {
		return productRepo.findByKeywordAutoComplete(keyword);
	}

	@Override
	public List<ProductDTO> findByKeywordDTO(String keyword) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepo.findByKeyword(keyword), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public Page<Product> findPagingnation(int pageNo, int pageSize) {
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			return productRepo.findAll(pageable);
	}



}
