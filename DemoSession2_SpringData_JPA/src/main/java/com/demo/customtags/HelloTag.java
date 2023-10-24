package com.demo.customtags;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class HelloTag extends AbstractElementTagProcessor{

	public HelloTag(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, "hello", true, null, false, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		// TODO Auto-generated method stub
		structureHandler.replaceWith("<b><i><u>Hello world</u></i></b>", false);
	}

}
