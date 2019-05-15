
package com.jp.insurance.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.service.FutureDate;


@Repository
public class PolicyDaoImpl implements PolicyDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Policy getPolicyById(Long policyId) throws PolicyException{
		return entityManager.find(Policy.class,policyId);
	}
	
	
	@Override
	public List<Policy> getPolicyList() throws PolicyException {
		Query query = entityManager.createQuery("from Policy");
		return query.getResultList();
	}

	@Override
	public Policy addPolicy(Policy policy) throws PolicyException{
		System.out.println("User Added in Database : " + policy);
		entityManager.persist(policy);
		return policy;
	}
	
	@Override
	public boolean updatePolicy(Policy policy) throws PolicyException{
		return entityManager.merge(policy)!=null;
	}

	@Override
	public boolean deletePolicy(Long policyId) throws PolicyException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Policy> getPolicyByRenualDate (Date date) throws PolicyException {
		String dateStr = new SimpleDateFormat("DD-MMM-YY").format(date);
		Query qry = entityManager.createQuery("from Policy where renualDate=:date");
		return qry.setParameter("date",dateStr).getResultList();
		
	}

	@Override
	public List<Policy> getPolicyByExpiryDate(Date date) throws PolicyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Policy> getPolicyListbyCustID(Integer custId) throws PolicyException {
		List<Policy> policyList=null;
		System.out.println("GET POLICY BY CUST ID:");
		Query query = entityManager.createQuery("from Policy where CUST_ID =:custId");
		query.setParameter("custId", custId);
		if(!query.getResultList().isEmpty())
		{
			policyList = query.getResultList();

		}
		System.out.println("Policy List by Cust Id: "+policyList  );
		return query.getResultList();
	
	}

	
}