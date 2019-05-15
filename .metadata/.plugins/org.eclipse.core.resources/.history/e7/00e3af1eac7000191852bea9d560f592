
package com.jp.insurance.service;

import java.util.List;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.PolicyException;

public interface LoginService {
	public boolean userLogin(String username, String password);

	public List<Policy> getPoliciesFromUserId(String userId) throws CustomerException, PolicyException;
}
