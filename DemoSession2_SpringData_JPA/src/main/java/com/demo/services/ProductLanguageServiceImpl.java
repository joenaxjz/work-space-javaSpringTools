package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Account;
import com.demo.entities.Language;
import com.demo.entities.Product;
import com.demo.entities.ProductLanguage;
import com.demo.repositories.AccountRepository;
import com.demo.repositories.LanguageRepository;
import com.demo.repositories.ProductLanguageRepository;
import com.demo.repositories.ProductRepository;

@Service("productLanguageService")
public class ProductLanguageServiceImpl implements ProductLanguageService {

	@Autowired
	private LanguageRepository langRepository;
	
	@Autowired
	private ProductLanguageRepository productLangRepo;

	@Override
	public ProductLanguage find(Product product, String locale) {
		try {
			String [] rs = locale.split("_");
			Language lang = langRepository.find(rs[0], rs[1]);
			System.out.println(lang.getId());
			return productLangRepo.find(product.getId(), lang.getId());
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	



}
