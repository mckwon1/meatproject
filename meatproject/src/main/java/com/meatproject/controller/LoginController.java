package com.meatproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meatproject.security.CustomUserDetails;
import com.meatproject.security.LoginVO;
import com.meatproject.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
     
    @Autowired
    private LoginService loginService;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login(HttpSession session) {
        logger.info("Welcome login! {}", session.getId());
        return "login";
    }
    
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public void logout(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
         
        logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
         
         
        session.invalidate();
    }
     
    @RequestMapping(value = "login_success", method = RequestMethod.GET)
    public void login_success(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
         
        logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
        session.setAttribute("userLoginInfo", userDetails);
    }
     
    @RequestMapping(value = "page1", method = RequestMethod.GET)
    public void page1() {      
    }
     
    @RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
    public void login_duplicate() {    
        logger.info("Welcome login_duplicate!");
    }
    
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public void insertShop (LoginVO loginVO) {
    	if (loginVO != null) {
    		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    		String hashedPassword = passwordEncoder.encode(loginVO.getPassword());
    		
    		loginVO.setPassword(hashedPassword);
    		
    		int cnt = loginService.insertShop(loginVO);
    	} else {
    		logger.debug("loginVO {} ", loginVO);
    	}
    }
}