package com.meatproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatproject.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public List<Map<String, String>> listMember(String id) {
		return userDAO.listMember(id);
	}
	
}
