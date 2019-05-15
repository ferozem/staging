
package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.insurance.dao.LoginDao;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.PolicyException;

@Service("loginService")
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean userLogin(String username, String password) {
		
		return loginDao.userLogin(username,password);
	}

	@Override
	public List<Policy> getPoliciesFromUserId(String userId) throws CustomerException, PolicyException{
		return loginDao.getPoliciesFromUserId(userId);
	}

	
}
