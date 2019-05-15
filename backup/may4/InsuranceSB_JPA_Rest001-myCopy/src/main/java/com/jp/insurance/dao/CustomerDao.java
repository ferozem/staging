package com.jp.insurance.dao;
import java.util.List;

import com.jp.insurance.entities.Customer;
import com.jp.insurance.exception.CustomerException;



/** @author Smita **/
public interface CustomerDao {
	public Integer addCustomer(Customer customer)throws CustomerException;//C-create
	public List<Customer> getCustomerList()throws CustomerException;//R All Customer -retrieve
	public boolean updateCustomer(Customer customer)throws CustomerException;//U-update
	public boolean deleteCustomerById(Integer empId)throws CustomerException;//D-delete
	public Customer getCustomerById(Integer empId)throws CustomerException;//S-search
	public Customer getCustomerByUserId(String userId)throws CustomerException;//S-search
}
