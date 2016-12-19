package com.meatproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meatproject.security.CustomUserDetails;
import com.meatproject.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin.do")
	public String admin() {
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("auth = " + user.getLoginVO().getAuth());
		return "admin";
	}
	
	@RequestMapping("memberList")
	public String login() {
		
		return "/admin/memberList";
	}
	
	@RequestMapping("listMember")
	@ResponseBody
	public Map<String, Object> listMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, String>> list = adminService.listMember();
		
		map.put("data", list);
		
		return map;
	}
	
	
}