package com.meatproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meatproject.security.CustomUserDetails;
import com.meatproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user.do") 
	public String user(HttpSession session) {
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("auth = " + user.getLoginVO().getAuth());
        return "user";
    }
	
	//멤버 리스트
	@RequestMapping("/memberList")
	public String login() {
		
		return "/user/memberList";
	}
	
	//멤버 리스트 호출
	@RequestMapping("/listMember")
	@ResponseBody
	public Map<String, Object> listMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, String>> list = userService.listMember();
		
		map.put("data", list);
		
		return map;
	}

}