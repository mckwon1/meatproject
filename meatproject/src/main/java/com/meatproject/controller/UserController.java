package com.meatproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meatproject.security.CustomUserDetails;
import com.meatproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user.do") 
	public String user(HttpSession session, Model model) {
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("auth = " + user.getLoginVO().getAuth());
    	
        return "/user/memberList";
    }
	
	//멤버 리스트
	@RequestMapping("/memberList")
	public String memberList() {
		
		return "/user/memberList";
	}
	
	//멤버 리스트 호출
	@RequestMapping("/listMember")
	@ResponseBody
	public Map<String, Object> listMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Map<String, String>> list = userService.listMember(user.getLoginVO().getId());
		
		map.put("data", list);
		return map;
	}
	
	//멤버 가입
	@RequestMapping("/newMember")
	public String newMember() {
		
		return "/user/newMember";
	}
	
	//멤버 가입등록
	@RequestMapping("/newMemberInsert")
	@ResponseBody
	public Map<String, Integer> newMemberInsert(@RequestParam Map<String, String> item) {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		item.put("sNum", user.getLoginVO().getsNum());
		
		return userService.newMemberInsert(item);
	}

}