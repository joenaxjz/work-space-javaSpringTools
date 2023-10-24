package com.demo.customtags;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class AddTag extends AbstractElementTagProcessor {

	public AddTag(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, "add", true, null, false, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		// TODO Auto-generated method stub
		String num1 = tag.getAttributeValue("num1");
		String num2 = tag.getAttributeValue("num2");
		double total = Double.parseDouble(num1) + Double.parseDouble(num2);
		structureHandler.replaceWith(num1 + " + " + num2 + "= " + total, false);
	}

}
