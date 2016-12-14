package com.meatproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meatproject.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("login")
	public String login() {
		
		//aa 33
		
		System.out.println("test :: "+loginService.login());
		
		return "/login";
	}
}