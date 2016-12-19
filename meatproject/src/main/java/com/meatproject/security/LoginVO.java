package com.meatproject.security;

import java.io.Serializable;
public class LoginVO implements Serializable {

	private static final long serialVersionUID = 2318848646884054384L;
	
	private String id;
    private String password;
    private String auth;
    private String sNum;
    
    public LoginVO() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginVO(String id, String password) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.password = password;
    }
    
    public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAuth() {
        return auth;
    }
 
    public void setAuth(String auth) {
        this.auth = auth;
    }
 
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name=" + id + ", password=" + password;
    }
}
