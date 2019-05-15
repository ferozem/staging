
package com.jp.insurance.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.insurance.dao.PolicyDao;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;




@Service("policyService")
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyDao policyDao;
	
	
	@Override
	public Policy getPolicyById(Long policyId) throws PolicyException {
		return policyDao.getPolicyById(policyId);
	}
	
	@Override
	public List<Policy> getPolicyList() throws PolicyException {
		// call dao layer method and return to Client.
		System.out.println("From policy service");
		return policyDao.getPolicyList();
	}
	@Override
	public Policy addPolicy(Policy policy) throws PolicyException {
		return policyDao.addPolicy(policy);
	}
	
	@Override
	public List<Policy> getRenualPoliciesByDays (int days) throws PolicyException {
		FutureDate futureDate = new FutureDate();
		System.out.println(futureDate.getFutureDate(days));
		return policyDao.getPolicyByRenualDate(futureDate.getFutureDate(days));
	} 
	
	@Override
	public List<Policy> getRenualPoliciesByDate (Date date) throws PolicyException {
		return policyDao.getPolicyByRenualDate(date);
	} 
	@Override
	public List<Policy> getPolicyListbyCustID(Integer custId) throws PolicyException {
		
		return policyDao.getPolicyListbyCustID(custId);
	} 
}
