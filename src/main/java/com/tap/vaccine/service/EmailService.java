package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	private JavaMailSender mailSender;
	
	@Autowired
	public EmailService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	public EmailService() {
		super();

	}
	public void blockedEmail(String to, String username) throws Exception {
	
		SimpleMailMessage  simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject("Alert");
		simpleMailMessage.setText("Dear"+ username+" you are blocked.");
		try {
			mailSender.send(simpleMailMessage);
			System.out.println("mail Sended Successfully");
			
		}catch(MailException e) {
			System.out.println(e.getMessage());
			throw new Exception("wrong");
		}
	}
}
