
package com.jp.insurance.dao;

import java.util.List;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.PolicyException;

public interface LoginDao {
	
	boolean userLogin(String username, String password);

	List<Policy> getPoliciesFromUserId(String userId) throws CustomerException, PolicyException;
	
}
