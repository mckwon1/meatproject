package com.meatproject.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	List<Map<String, String>> listMember(String id);

	int newMemberInsert(Map<String, String> item);

	
}
