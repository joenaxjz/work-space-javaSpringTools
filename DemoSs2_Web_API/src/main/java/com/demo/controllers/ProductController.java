package com.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.demo.dtos.ProductDTO;
import com.demo.entities.Category;
import com.demo.services.CategoryService;
import com.demo.services.ProductService;

@Controller
@RequestMapping({ "api/product" }) // multi-link
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = {"find/{id}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> find (@PathVariable("id") int id){
		try {
			return new ResponseEntity<ProductDTO> (productService.find(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<ProductDTO> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = {"findAll"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> findAll (){
		try {
			return new ResponseEntity<List<ProductDTO>> (productService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductDTO>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	
	// Liệt kê n sản phẩm
	@GetMapping(value = {"lastestNewProduct/{n}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> lastestNewProduct (@PathVariable("n") int n){
		try {
			return new ResponseEntity<List<ProductDTO>> (productService.lastestNewProduct(n), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<ProductDTO>> (HttpStatus.BAD_REQUEST);
		}
	}
	
	// Liệt kê sản phẩm theo khoảng giá
		@GetMapping(value = {"priceRanges/{min}/{max}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ProductDTO>> priceRanges (@PathVariable("min") double min, @PathVariable("max") double max){
			try {
				return new ResponseEntity<List<ProductDTO>> (productService.priceRanges(min, max), HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<List<ProductDTO>> (HttpStatus.BAD_REQUEST);
			}
		}
	// Liệt kê danh sách sản phẩm theo khoảng thời gian
		@GetMapping(value = {"findByDates/{startDate}/{endDate}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ProductDTO>> findByDates (@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
			try {
				SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
				Date start = date1.parse(startDate);
				Date end = date1.parse(endDate);
				return new ResponseEntity<List<ProductDTO>> (productService.findByDates(start, end), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<List<ProductDTO>> (HttpStatus.BAD_REQUEST);
			}
		}
		
		// Liệt kê danh sách sản phẩm trong 1 ngày
				@GetMapping(value = {"findByDate/{created}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
				public ResponseEntity<List<ProductDTO>> findByDates (@PathVariable("created") String created){
					try {
						SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
						Date created1 = date1.parse(created);
						return new ResponseEntity<List<ProductDTO>> (productService.findByDate(created1), HttpStatus.OK);
					} catch (Exception e) {
						return new ResponseEntity<List<ProductDTO>> (HttpStatus.BAD_REQUEST);
					}
				}
		// tính tổng tiền của 1 category
				@GetMapping(value = {"sumCategory/{categoryId}"} , produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
				public ResponseEntity<Double> sumCategory (@PathVariable("categoryId") int categoryId){
					try {
						return new ResponseEntity<Double> (productService.sumCategory(categoryId), HttpStatus.OK);

					} catch (Exception e) {
						return new ResponseEntity<Double> (HttpStatus.BAD_REQUEST);
					}
				}
}
