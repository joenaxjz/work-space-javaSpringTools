package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Override
	public List<Language> findAll() {
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language(1, "Lang 1"));
		languages.add(new Language(2, "Lang 2"));
		languages.add(new Language(3, "Lang 3"));
		languages.add(new Language(4, "Lang 4"));
		return languages;
	}

}
