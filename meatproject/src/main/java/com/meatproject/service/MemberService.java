package com.meatproject.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatproject.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public String memberPoint(String pNum) {
		
		Map<String, String> phoneNum = new HashMap<String, String>();
		String[] tem = pNum.split("-");
		phoneNum.put("phone1", tem[0]);		
		phoneNum.put("phone2", tem[1]);		
		phoneNum.put("phone3", tem[2]);		
		
	    DecimalFormat Commas = new DecimalFormat("#,###");
		
	    return (String)Commas.format(memberDAO.memberPoint(phoneNum));
	}

}
