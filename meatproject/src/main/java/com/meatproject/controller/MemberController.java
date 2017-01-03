package com.meatproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meatproject.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//유저 포인트 조회
	@RequestMapping("/memberPoint")
	@ResponseBody
	public Map<String, String> memberPoint(String pNum) {
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", memberService.memberPoint(pNum));
		
		return result;
	}
}