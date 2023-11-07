package com.demo.controllers.user;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "demo4", "" }) // multi-link
public class Demo4Controller {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(Locale locale, ModelMap modelMap) {
		
		System.out.println("language: " + locale.getLanguage());
		System.out.println("country: " + locale.getDisplayCountry());
		
		NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance(locale);
		modelMap.put("price1", numberFormat1.format(123231231));
		
		modelMap.put("price2", 45464546);
		modelMap.put("price3", 45464.123546);
		
		NumberFormat nbFormat2 = NumberFormat.getNumberInstance(locale);
		modelMap.put("quan1", nbFormat2.format(99999999));
		
		modelMap.put("quan2", 123456999);
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		modelMap.put("date1", dateFormat.format(new Date()));
		
		modelMap.put("msg1", messageSource.getMessage("msg", null, locale));
		
		modelMap.put("msg2", messageSource.getMessage("msg2", new Object[] {"ABC", "DEF", "Noice"}, locale));
		
		modelMap.put("today", new Date());
		
		
		
		return "demo4/index";
	}
	
}
