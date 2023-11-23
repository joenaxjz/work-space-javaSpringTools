package com.demo.configurations;

import java.util.Locale;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.demo.dtos.InvoiceDTO;
import com.demo.dtos.ProductDTO;
import com.demo.entities.Invoice;
import com.demo.entities.Product;

@Configuration
public class ModelMapperConfiguration implements WebMvcConfigurer {

	@Autowired
	private Environment environment;

	@Bean
	public ModelMapper modelMapper () {
		ModelMapper mapper = new ModelMapper();
		
		Converter<Boolean, String> convertBooleanToString = new AbstractConverter<Boolean, String>() {
			@Override
			protected String convert (Boolean source) {
				return source ? "Show" : "Hide";
			}
		};
		
		Converter<String, String> convertPhototoPhotoUrl = new AbstractConverter<String, String> () {
			@Override
			protected String convert (String source) {
				return environment.getProperty("BASE_URL") + "/images/" + source;
			}
		};
		
		mapper.typeMap(Product.class, ProductDTO.class).addMappings( m -> {
			m.using(convertBooleanToString).map(Product::isStatus, ProductDTO::setStatus);
			m.using(convertPhototoPhotoUrl).map(Product::getPhoto, ProductDTO::setPhoto);
		});
		
		mapper.addMappings(new PropertyMap<Product, ProductDTO> () {
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setName(source.getName());
				map().setPrice(source.getPrice());
				map().setQuantity(source.getQuantity());
				map().setDescription(source.getDescription());
				map().setCreated(source.getCreated());
				map().setCategoryId(source.getCategory().getId());
				map().setCategoryName(source.getCategory().getName());
			}
		});
		
		mapper.addMappings(new PropertyMap<Invoice, InvoiceDTO> (){
			@Override
			protected void configure () {
				map().setId(source.getId());
				map().setName(source.getName());
				map().setCreated(source.getCreated());
				map().setPayment(source.getPayment());
				map().setStatus(source.getStatus());
				map().setFullName(source.getAccount().getFullName());
				map().setEmail(source.getAccount().getEmail());
			}
		});
		
		return mapper;
	}

}
