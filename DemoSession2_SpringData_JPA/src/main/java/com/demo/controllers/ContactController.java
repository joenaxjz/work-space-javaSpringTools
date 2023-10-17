package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Contact;
import com.demo.services.MailService;

@Controller
@RequestMapping({ "contact" }) // multi-link
public class ContactController {
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private Environment environment;
	
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact/index";
	}
	
	@RequestMapping(value = { "sendContact" }, method = RequestMethod.POST)
	public String sendContact(ModelMap modelMap, @ModelAttribute("contact") Contact contact, RedirectAttributes redirectAttributes) {
		String content = "Full Name: " + contact.getFullName();
		content += "<br>Phone: " + contact.getPhone();
		content += "<br>Email: " + contact.getEmail();
		content += "<br>Content: " + contact.getContent();
		String email = environment.getProperty("spring.mail.username");
		if(mailService.send(contact.getEmail(), email, contact.getSubject(), content)) {
			redirectAttributes.addFlashAttribute("msg", "Sent");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/contact/index";
	}
	
}
