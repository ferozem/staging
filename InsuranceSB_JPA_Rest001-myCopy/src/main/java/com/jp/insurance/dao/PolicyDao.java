/**
 * 
 */
package com.jp.insurance.dao;

import java.util.Date;
import java.util.List;


import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;


public interface PolicyDao {

	Policy getPolicyById(Long policyId) throws PolicyException;

	Policy addPolicy(Policy policy) throws PolicyException;

	boolean updatePolicy(Policy policy) throws PolicyException;
	
	boolean deletePolicy(Long policyId) throws PolicyException;
	
	public List<Policy> getPolicyList()throws PolicyException;//R All Policies -retrieve
	
	public List<Policy> getPolicyListbyCustID(Integer custId)throws PolicyException;//R All Policies -By Cust ID
	
	List<Policy> getPolicyByRenualDate(Date date) throws PolicyException;
	
	List<Policy> getPolicyByExpiryDate(Date date) throws PolicyException;
	
	
	
}
