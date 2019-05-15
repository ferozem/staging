package com.jp.insurance.entities;

import org.springframework.stereotype.Component;

/*
 * This class is used to hold the values
 * coming from request body during login
 * this not a JPA entity
 */

@Component
public class LoginDetails {
	private String loginUserName;
	private String loginPassword;
	
	public LoginDetails() {
		//Default constructor
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginUserName=" + loginUserName + ", loginPassword=" + loginPassword + "]";
	}
	
	
	
	
}
