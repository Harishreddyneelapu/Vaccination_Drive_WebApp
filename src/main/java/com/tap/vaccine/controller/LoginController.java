package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {
	
	public LoginController() {
		super();

	}
	private LoginService loginService;
	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	


	@RequestMapping(value="/userLogin")
	public String userLogin(@RequestParam String email, @RequestParam String password, Model model) throws Exception {
		
		
		System.out.println("Invoked UserLogin in controller...");
		try {
			loginService.loginCredentials(email, password);
			model.addAttribute("responseMessage", "Welcome to User Page...");
			return "/WelcomeUser.jsp";
		}
		catch(Exception e) {
			model.addAttribute("responseMessage", "Login failed:"+e.getMessage());
		}
		return "/login.jsp";
		
		
		
	}
	
	

	@RequestMapping(value="/login")
	public String getLoginPage() {
		return "/login.jsp";
	}
	
	
	@RequestMapping(value="/registerNewUser")
	public String redirectToRegister() {
		return "/Register.jsp";
		
	}
	
	@RequestMapping(value="/forgotPasswordUrl")
	public String redirectForgotPassword() {
		return "/forgotPassword.jsp";
	}
}
