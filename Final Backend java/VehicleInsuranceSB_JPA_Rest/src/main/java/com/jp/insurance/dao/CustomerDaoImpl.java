package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Customer;
import com.jp.insurance.exception.CustomerException;


//prep-work 1 -@Repository CustomerDaoImpl
@Repository
public class CustomerDaoImpl implements CustomerDao {
	private final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addCustomer(Customer customer) throws CustomerException {
		logger.info("Trying to persist customer at dao addCustomer method");
		try {
		entityManager.persist(customer);
		logger.info("Persisted customer at dao addCustomer method with unique Id : "+customer.getCustId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Failed to persist customer at dao addCustomer method");
			
		}
		return customer.getCustId();
	}
	
	@Override
	public List<Customer> getCustomerList() throws CustomerException {
		logger.info("Trying to list customers at dao getCustomerList method");
		List<Customer> customerList=null;
		try {
			
			Query query = entityManager.createQuery("from Customer");
			customerList = query.getResultList();
			logger.info("Listed customers list at dao getCustomerList method");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Failed to list customer at dao getCustomerList method");
			
		}
		return customerList;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws CustomerException {
	
		return entityManager.merge(customer)!=null;
	}

	@Override
	public boolean deleteCustomerById(Integer empId) throws CustomerException {
		Customer customer = getCustomerById(empId);
		if(customer == null)
		return false;
		else{
			entityManager.remove(customer);
			return true;
		}
	}

	@Override
	public Customer getCustomerById(Integer empId) throws CustomerException {
		
		return entityManager.find(Customer.class, empId);
	}
	@Override
	public Customer getCustomerByUserId(String userId) throws CustomerException {
		
		Customer customer = null;
		Query query = entityManager.createQuery("from Customer where userId =:userId");
		query.setParameter("userId", userId);
		
		
		if(!query.getResultList().isEmpty())
		{
			customer = (Customer) query.getSingleResult();

		}
		System.out.println("customer by user ID: "+userId + customer );
		return customer;
		
		
	}
}
