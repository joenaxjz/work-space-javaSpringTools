package com.demo.customtags;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.demo.entities.Category;
import com.demo.services.CategoryService;

public class CategoriesTag extends AbstractElementTagProcessor {
	
	@Autowired
	private CategoryService categoryService;

	public CategoriesTag(String dialectPrefix, CategoryService categoryService) {
		super(TemplateMode.HTML, dialectPrefix, "categories", true, null, false, 4);
		this.categoryService = categoryService;
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		String s = "<ul>";
		for ( Category category : categoryService.findAll()) {
			s += "<li>" + category.getName() + "</li>";
 		}
		s += "</ul>";
		structureHandler.replaceWith(s, false);
	}

}
