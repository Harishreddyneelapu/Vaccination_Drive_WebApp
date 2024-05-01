package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO{
	private SessionFactory sessionFactory = null;
	private JavaMailSender mailSender;
	
	
	@Autowired
	public RegisterDAOImpl(SessionFactory sessionFactory, JavaMailSender mailSender) {
		super();
		this.sessionFactory = sessionFactory;
		this.mailSender = mailSender;
	}

	public RegisterDAOImpl() {
		super();

	}

	public boolean saveRegisterEntity(RegisterEntity entity) {
		System.out.println("invoked saveRegisterEntity()");
		boolean isDataSaved=false;
		Session session=null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			System.out.println("RegisterEntity is saved");
			isDataSaved = true;
			
		}finally {
			if(session !=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}


	public boolean sendEmail(String email) throws Exception{
		boolean flag=true;
		SimpleMailMessage  simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("aarithe2002@gmail.com");
		simpleMailMessage.setSubject("Alert");
		simpleMailMessage.setText("successfully saved");
		try {
			mailSender.send(simpleMailMessage);
			System.out.println("mail Sended Successfully");
			return flag;
		}catch(MailException e) {
			System.out.println(e.getMessage());
			throw new Exception("wrong");
		}
		
	}

}
