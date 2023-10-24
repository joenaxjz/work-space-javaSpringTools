package com.demo.customtags;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.services.CategoryService;
import com.demo.services.ProductService;

public class ProductsTag extends AbstractElementTagProcessor {

	@Autowired
	private ProductService productService;

	public ProductsTag(String dialectPrefix, ProductService productService) {
		super(TemplateMode.HTML, dialectPrefix, "lastestproduct", true, null, false, 4);
		this.productService = productService;
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		int n = Integer.parseInt(tag.getAttributeValue("n"));
		String s = "<ul>";
		for (Product product : productService.limit1(n)) {
			s += "<li>";
			s += "<img src='/images/" + product.getPhoto() + "' width='70' heigth='80'>";
			s += "<br>Name:" + product.getName();
			s += "<br>Price: " + product.getPrice();
			s += "</li>";
		}
		s += "</ul>";
		structureHandler.replaceWith(s, false);
	}

}
