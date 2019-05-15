
package com.jp.insurance.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.service.FutureDate;



@Repository
public class PolicyDaoImpl implements PolicyDao {
	private final Logger logger = LoggerFactory.getLogger(PolicyDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Policy getPolicyById(Long policyId) throws PolicyException{
		return entityManager.find(Policy.class,policyId);
	}
	
	
	@Override
	public List<Policy> getPolicyList() throws PolicyException {
		List<Policy> policyList = null;
		logger.info("Trying to get policies at dao getPolicyList method");
		try {
		Query query = entityManager.createQuery("from Policy");
		policyList=query.getResultList();
		logger.info("Got policy list at dao getPolicyList method : "+policyList);
		System.out.println(" policyList at dao : "+policyList);
		}catch (Exception e) {
			logger.error("Failed to get policy list at dao getPolicyList method");
		}
		return policyList;
	}

	@Override
	public Policy addPolicy(Policy policy) throws PolicyException{
		//System.out.println("Policy Added in Database : " + policy);
		logger.info("Trying to persist policy at dao addPolicy method");
		try {
		entityManager.persist(policy);
		logger.info("Persisted policy at dao addPolicy method with unique Id : "+policy.getPolicyNumber());
		}catch (Exception e) {
			logger.error("Failed to persist policy at dao addPolicy method");
		}
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
		logger.info("Trying to get policies by custId at dao getPolicyListbyCustID method");
		try {
		logger.info("Trying to get policies at dao getPolicyListbyCustID method");
		Query query = entityManager.createQuery("from Policy where CUST_ID =:custId");
		query.setParameter("custId", custId);
		if(!query.getResultList().isEmpty())
		{
			policyList = query.getResultList();
			logger.info("got  policies at dao getPolicyListbyCustID method" +policyList);

		}
		}catch (Exception e) {
			logger.error("Failed to got  policies at dao getPolicyListbyCustID method");
		}
		//System.out.println("Policy List by Cust Id: "+policyList  );
		//return query.getResultList();
		return policyList;
	
	}

	
	
}
