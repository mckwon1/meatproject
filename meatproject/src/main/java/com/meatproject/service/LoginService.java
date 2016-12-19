package com.meatproject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatproject.dao.LoginDAO;
import com.meatproject.security.LoginVO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	public Map<String, Object> login() {
		return loginDAO.login();
	}

	public int insertShop(LoginVO loginVO) {
		return loginDAO.insertShop(loginVO);
	}
	
	
}
