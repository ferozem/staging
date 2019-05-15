
package com.jp.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.insurance.dao.LoginDao;

@Service("loginService")
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean userLogin(String username, String password) {
		
		return loginDao.userLogin(username,password);
	}

	
}
