
package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Customer;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.PolicyException;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean userLogin(String username, String password) {
		System.out.println("User name in dao"+username);
		System.out.println("Password in dao"+password);
		Query query = entityManager.createQuery("from Customer where userId =:userId AND password=:password");
		query.setParameter("userId",username);
		query.setParameter("password",password);
		if(!query.getResultList().isEmpty()){
				return true;
		}
		return false;
	}

	@Override
	public List<Policy> getPoliciesFromUserId(String userId) throws CustomerException, PolicyException {
		System.out.println("user id from json"+userId);
		CustomerDao customerDao = new CustomerDaoImpl();
		PolicyDao policyDao = new PolicyDaoImpl();
		Customer customer = customerDao.getCustomerByUserId(userId);
		System.out.println(customer);
		return policyDao.getPolicyListbyCustID(customer.getCustId());
	}

	
	
}
