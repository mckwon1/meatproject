package com.meatproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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
	public Map<String, Object> newMemberInsert(Map<String, String> item) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int userChk = 0; 
		
		userChk = userDAO.oneMember(item);
		
		if(userChk != 0){
			map.put("result", "이미 가입된 회원입니다.");
		}else{
			userDAO.newMemberInsert(item);
			map.put("result", "등록완료");
		}
		
		return map;
	}

	public Map<String, String> selectUser(String id) {
		return userDAO.selectUser(id);
	}

	public Map<String, Object> memberUpdate(Map<String, String> item) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//포인트가 0 이면 유저 정보만 업데이트
		if(Integer.valueOf(item.get("newPoint")) == 0){
			int userChk = 0; 
			
			userChk = userDAO.oneMember(item);
			
			if(userChk != 0){
				map.put("result", "등록된 번호입니다.");
			}else{
				userDAO.updateUser(item);
				map.put("result", "수정완료");
			}
		}else{
		//포인트가 있으면, 포인트 인설트
			userDAO.updateUser(item);
			userDAO.insertUserPoint(item);
			map.put("result", "적립 완료");
			
		}
		
		return map;
	}
	
}
