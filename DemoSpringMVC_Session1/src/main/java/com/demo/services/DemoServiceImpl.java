package com.demo.services;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	public String hello() {
		return "hi";
	}

	@Override
	public String hi(String name) {

		
		return "hi " + name;
	}

}
