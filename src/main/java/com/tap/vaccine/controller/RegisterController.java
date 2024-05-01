package com.tap.vaccine.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.VaccineService;

@Controller
public class RegisterController {
	
	private VaccineService vaccineService;
	

	@Autowired
	public RegisterController(VaccineService vaccineService) {		
		
		super();
		this.vaccineService=vaccineService;
	}
	
	
	public RegisterController() {
		super();

	}


	@RequestMapping(value = "/registerVaccine")
	public String registerData(@RequestParam String username, @RequestParam String password,
			@RequestParam String cnfPassword, @RequestParam String email, @RequestParam String mobileNo,
			@RequestParam String gender, @RequestParam String dob, Model model) {
		System.out.println("invoked registerData()");
		boolean isValid = vaccineService.validateRegisterEntity(username,password,cnfPassword,email,mobileNo,gender,dob);
		if (isValid) {
			model.addAttribute("responseMessage", "DATA IS VALID & SAVED");
			model.addAttribute("isValid", true);
			
		} else {
			model.addAttribute("responseMessage", "DATA IS INVALID & NOT SAVED");
			model.addAttribute("isValid", false);
		}
		return "/Register.jsp";
	} 
	
	
	
	@RequestMapping(value="/register")
	public String getRegisterPage() {
		return "/Register.jsp";
	}
}
