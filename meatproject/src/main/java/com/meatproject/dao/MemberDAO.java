package com.meatproject.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {

	int memberPoint(Map<String, String> member);


	
}
