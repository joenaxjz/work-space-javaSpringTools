package com.demo.customtags;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class HiTag extends AbstractElementTagProcessor{

	public HiTag(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, "hi", true, null, false, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		// TODO Auto-generated method stub
		String fullName = tag.getAttributeValue("fullName");
		structureHandler.replaceWith("<h4>hi "+ fullName +"</h4>", false);
	}

}
