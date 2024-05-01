package com.tap.vaccine.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class VaccineService {
	private RegisterDAO registerDAO = null;
	
	
	@Autowired
	public VaccineService(RegisterDAO registerDAO) {
		super();
		this.registerDAO = registerDAO;
	}



	public VaccineService() {
		super();
		System.out.println("vaccineService Created");
	}



	public boolean validateRegisterEntity(String username, String password, String cnfPassword, String email,
			String mobileNo, String gender, String dob) {
		if(username !=null && !username.isEmpty()) {
			System.out.println("username is valid");
		}else {
			System.out.println("username is in valid");
			return false;
		}if(password !=null && !password.isEmpty()) {
			System.out.println("password is valid");
		}else {
			System.out.println("password is in valid");
			return false;
		}if(cnfPassword !=null && !cnfPassword.isEmpty()) {
			System.out.println("cnfPassword is valid");
		}else {
			System.out.println("cnfPassword is in valid");
			return false;
		}if(email !=null && !email.isEmpty()) {
			System.out.println("email is valid");
		}else {
			System.out.println("email is in valid");
			return false;
		}if(mobileNo !=null && !mobileNo.isEmpty()) {
			System.out.println("mobileNo is valid");
		}else {
			System.out.println("mobileNo is in valid");
			return false;
		}if(gender !=null && !gender.isEmpty()) {
			System.out.println("gender is valid");
		}else {
			System.out.println("gender is in valid");
			return false;
		}if(dob !=null) {
			System.out.println("dob is valid");
			RegisterEntity entity = new RegisterEntity(username,password,email,mobileNo,gender,dob);
			boolean result = registerDAO.saveRegisterEntity(entity);
			try {
				registerDAO.sendEmail(email);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return result;
		}else {
			System.out.println("dob is in valid");
			return false;
		}
		
	}
	public boolean validateUsername(String username) {
		return username !=null && !username.isEmpty()?true:false;
	}
	public boolean validatePassword(String password) {
		return password !=null && !password.isEmpty()?true:false;
	}
	public boolean validateCnfPassword(String cnfPassword) {
		return cnfPassword !=null && !cnfPassword.isEmpty()?true:false;
	}
	public boolean validateEmail(String email) {
		return email !=null && !email.isEmpty()?true:false;
	}
	public boolean validateMobileNo(String mobileNo) {
		return mobileNo !=null && !mobileNo.isEmpty()?true:false;
	}
	public boolean validateGender(String gender) {
		return gender !=null && !gender.isEmpty()?true:false;
	}
	public boolean validateDod(String dob) {
		return dob !=null && !dob.isEmpty()?true:false;
	}
}
