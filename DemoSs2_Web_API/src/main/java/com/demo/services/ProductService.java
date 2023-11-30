package com.demo.services;

import java.util.Date;
import java.util.List;

import com.demo.dtos.CategoryDTO;
import com.demo.dtos.ProductDTO;
import com.demo.entities.Category;

public interface ProductService {
	
	public List<ProductDTO> findAll();

	public ProductDTO find(int id);
	
	//Liệt kê n sản phẩm
	public List<ProductDTO> lastestNewProduct(int n);
	
	// liệt kê sản phẩm theo khoảng giá min, max
	public List<ProductDTO> priceRanges(double min, double max);
	
	// liệt kê sản phẩm theo khoảng thời gian
	public List<ProductDTO> findByDates(Date startDate, Date endDate);
	
	// liệt kê sản phẩm trong 1 ngày
		public List<ProductDTO> findByDate(Date created);
		
	// liệt kê sản phẩm trong 1 ngày
		public double sumCategory(int categoryId);
}
