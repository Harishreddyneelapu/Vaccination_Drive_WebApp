package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tap.vaccine.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
		super();
		this.forgotPasswordService = forgotPasswordService;
	}


	public ForgotPasswordController() {
		super();

	}
	
}
