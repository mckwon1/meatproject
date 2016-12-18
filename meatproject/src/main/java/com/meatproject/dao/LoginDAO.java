package com.meatproject.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.meatproject.security.LoginVO;

@Repository
public interface LoginDAO {

	Map<String, Object> login();

	int insertShop(LoginVO loginVO);
	
	LoginVO selectUser(String shopId);
}
