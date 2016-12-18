package com.meatproject.security;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

 
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private LoginVO loginVO;
    
    public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public CustomUserDetails(LoginVO loginVO) {
        // TODO Auto-generated constructor stub
        this.loginVO = loginVO;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(loginVO.getAuth()));
        return authorities;
    }
 
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.loginVO.getPassword();
    }
 
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.loginVO.getId();
    }
 
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
 }