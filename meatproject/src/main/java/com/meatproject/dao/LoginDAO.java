package com.meatproject.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {

	Map<String, Object> login();
}
