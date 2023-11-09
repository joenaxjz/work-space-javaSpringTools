package com.demo.services;

import com.demo.entities.Account;
import com.demo.entities.Category;
import com.demo.entities.Language;
import com.demo.entities.Product;
import com.demo.entities.ProductLanguage;

public interface ProductLanguageService {
	
public ProductLanguage find(Product product, String locale);
	
}
