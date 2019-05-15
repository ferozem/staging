package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.CustomerDao;
import com.jp.insurance.entities.Customer;
import com.jp.insurance.exception.CustomerException;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public Integer addCustomer(Customer customer) throws CustomerException {
		// call dao layer method and return to Client.
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList() throws CustomerException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return customerDao.getCustomerList();
	}

	@Override
	@Transactional
	public boolean updateCustomer(Customer customer) throws CustomerException {
		// call dao layer method and return to Client.
		return customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public boolean deleteCustomerById(Integer empId) throws CustomerException {
		// call dao layer method and return to Client.
		return customerDao.deleteCustomerById(empId);
	}

	@Override
	public Customer getCustomerById(Integer empId) throws CustomerException {
		// call dao layer method and return to Client.
		return customerDao.getCustomerById(empId);
	}

	@Override
	public Customer getCustomerByUserId(String userId) throws CustomerException {
		
		return customerDao.getCustomerByUserId(userId);
	}

}
