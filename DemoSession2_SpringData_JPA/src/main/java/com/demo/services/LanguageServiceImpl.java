package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Account;
import com.demo.entities.Language;
import com.demo.repositories.AccountRepository;
import com.demo.repositories.LanguageRepository;
import com.demo.repositories.ProductRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository langRepository;
	
	@Override
	public Iterable<Language> findAll() {
		// TODO Auto-generated method stub
		return langRepository.findAll();
	}



}
