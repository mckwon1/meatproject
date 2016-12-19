package com.meatproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.meatproject.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public List<Map<String, String>> listMember(String id) {
		return userDAO.listMember(id);
	}

	@Transactional
	public Map<String, Integer> newMemberInsert(Map<String, String> item) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int flag = 0;
		
		flag = userDAO.newMemberInsert(item);
		
		map.put("result", flag);
		
		return map;
	}
	
}
