
package com.jp.insurance.service;

import java.util.Date;
import java.util.List;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;


public interface PolicyService {
	
	Policy getPolicyById(Long policyId) throws PolicyException;

	Policy addPolicy(Policy policy) throws PolicyException;

	public List<Policy> getPolicyList()throws PolicyException;//R All Product -retrieve
	
	List<Policy> getRenualPoliciesByDays(int days) throws PolicyException;

	List<Policy> getRenualPoliciesByDate(Date date) throws PolicyException;
	
	public List<Policy> getPolicyListbyCustID(Integer custId)throws PolicyException;//R All Policies -By Cust ID
	
}
