package com.meatproject.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	List<Map<String, String>> listMember(String id);

	void newMemberInsert(Map<String, String> item);

	int oneMember(Map<String, String> item);

	Map<String, String> selectUser(String id);

	
}
