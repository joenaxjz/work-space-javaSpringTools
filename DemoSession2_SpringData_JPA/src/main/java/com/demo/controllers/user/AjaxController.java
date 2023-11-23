package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.InvoiceDTO;
import com.demo.dtos.ProductDTO;
import com.demo.entities.Product;
import com.demo.services.InvoiceService;
import com.demo.services.ProductService;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	

	@GetMapping(value = "find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ProductDTO find() {
		return productService.find2(1);
	}
	
	@GetMapping(value = "find1", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public InvoiceDTO find1(@RequestParam("id") int id) {
		return invoiceService.find2(id);
	}
	
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<ProductDTO> findAll() {
		return productService.findAll2();
	}
	
	@GetMapping(value = "autoComplete", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<String> autoComplete(@RequestParam("term") String term) {
		return productService.findByKeywordAutoComplete(term);
	}
	
	@GetMapping(value = "customAutoComplete", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<ProductDTO> customAutoComplete(@RequestParam("term") String term) {
		return productService.findByKeywordDTO(term);
	}
}
