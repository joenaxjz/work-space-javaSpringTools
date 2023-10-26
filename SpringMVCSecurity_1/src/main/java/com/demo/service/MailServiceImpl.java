package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String from, String to, String subject, String content) {
		try {
			// khai bao
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content, true);
			sender.send(mimeMessage);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
