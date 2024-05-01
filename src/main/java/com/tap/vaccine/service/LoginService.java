package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginService {
	private LoginDAO loginDAO;
	private static final int maxLoginAttempts=2;
	private EmailService emailService;
	
	@Autowired
	public LoginService(LoginDAO loginDAO,  EmailService emailService) {
		super();
		this.loginDAO = loginDAO;
		
		this.emailService = emailService;
	}

	public LoginService() {
		super();
		
	}
	
	public RegisterEntity getEntityByEmail(String email) {
		return loginDAO.getEntityByEmail(email);
	}
	public boolean loginCredentials(String email, String password) throws Exception{
		System.out.println("Invoked loginCredentials() in service");
		if(email==null || email.isEmpty()|| email.isBlank()) {
			throw new Exception("Please Enter valid mail..");
		}

		if(password==null || password.isEmpty() || password.isBlank()) {
			throw new Exception("Please Enter valid Password..");
		}
			
		RegisterEntity entity = loginDAO.getEntityByEmail(email);
		if(entity!=null) {
			if(entity.getLoginAttempts() >= maxLoginAttempts) {
				emailService.blockedEmail(entity.getEmail(), entity.getUserName());
				throw new Exception("Your account is blocked. Please reset the password to unblock.");
			}
			if(entity.getPassword().equals(password)) {
				
				return true;
			}
			else {
				int id = entity.getRegisterID();
//				entity.setLoginAttempts(entity.getLoginAttempts()+1);
				loginDAO.updateRegisterEntity(id,entity.getLoginAttempts()+1);
				throw new Exception("Password Incorrect! "+ (maxLoginAttempts - entity.getLoginAttempts())+" left");
			}
		}
		else {
			throw new Exception("mail doesn't exist, Please Register!...");
		}
	}
}
