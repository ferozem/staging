
package com.jp.insurance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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

	
	
}
