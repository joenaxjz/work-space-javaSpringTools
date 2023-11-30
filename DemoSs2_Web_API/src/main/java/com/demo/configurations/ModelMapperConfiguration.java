package com.demo.configurations;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.demo.dtos.CategoryDTO;
import com.demo.dtos.ProductDTO;
import com.demo.entities.Category;
import com.demo.entities.Product;

@Configuration
public class ModelMapperConfiguration implements WebMvcConfigurer {

	@Autowired
	private Environment environment;
	
	@Bean
	public ModelMapper modelMapper () {
		ModelMapper mapper = new ModelMapper();
		
		// CATEGORY
		mapper.addMappings(new PropertyMap<Category, CategoryDTO>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
			}
			
		
		});
		
		mapper.addMappings(new PropertyMap<CategoryDTO, Category>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
			}
		});
		
		//PRODUCT
		
		Converter<String, String> convertPhototoPhotoUrl = new AbstractConverter<String, String>() {

			@Override
			protected String convert(String source) {
				return environment.getProperty("UPLOAD_URL") + source;
			}
		};
		
		mapper.typeMap(Product.class, ProductDTO.class).addMappings(m -> {
			m.using(convertPhototoPhotoUrl).map(Product::getPhoto, ProductDTO::setPhoto);
		});
		
		mapper.addMappings(new PropertyMap<Product, ProductDTO>() {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
				map().setCategoryId(source.getCategory().getId());
				map().setCategoryName(source.getCategory().getName());
				map().setCreated(source.getCreated());
				map().setDescription(source.getDescription());
				map().setPrice(source.getPrice());
				map().setQuantity(source.getQuantity());
				map().setStatus(source.isStatus());
			}
		});
		
		
		
		return mapper;
	}
	

}
