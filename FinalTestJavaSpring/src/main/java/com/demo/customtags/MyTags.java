package com.demo.customtags;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import com.demo.services.CategoryService;
import com.demo.services.ProductService;

@Component
public class MyTags extends AbstractProcessorDialect {

	// Service o day
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	protected MyTags() {
		super("my tag", "mytag", 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new HelloTag(getPrefix()));
		processors.add(new HiTag(getPrefix()));
		processors.add(new AddTag(getPrefix()));
		processors.add(new CategoriesTag(getPrefix(), categoryService));
		processors.add(new ProductsTag(getPrefix(), productService));
		return processors;
	}

	
}
