package com.meatproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/admin.do")
	public String admin() {
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	//CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	//System.out.println("auth = " + user.getLoginVO().getAuth());
    	
    	//젠킨스
    	//aa
    	
    	
		return "admin";
	}
	
}