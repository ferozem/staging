package com.jp.insurance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.entities.LoginDetails;
import com.jp.insurance.exception.EmployeeException;
import com.jp.insurance.service.LoginService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginDetails loginDetailsBean;

	
	@PostMapping("/usrlogin")
	public boolean userLogin(@RequestBody LoginDetails loginDetails) throws EmployeeException {
		loginDetailsBean.setLoginUserName(loginDetails.getLoginUserName());
		System.out.println(loginDetailsBean.getLoginUserName());
		return loginService.userLogin(loginDetails.getLoginUserName(),loginDetails.getLoginPassword());
	}
	
	
	
}
