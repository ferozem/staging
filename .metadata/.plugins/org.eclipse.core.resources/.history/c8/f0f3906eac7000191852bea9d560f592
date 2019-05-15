package com.jp.insurance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.dao.CustomerDao;
import com.jp.insurance.dao.CustomerDaoImpl;
import com.jp.insurance.entities.Customer;
import com.jp.insurance.entities.LoginDetails;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.EmployeeException;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.service.CustomerService;
import com.jp.insurance.service.CustomerServiceImpl;
import com.jp.insurance.service.LoginService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CustomerService customerService;

	
	@PostMapping("/usrlogin")
	public boolean userLogin(@RequestBody LoginDetails loginDetails) throws EmployeeException {
		return loginService.userLogin(loginDetails.getLoginUserName(),loginDetails.getLoginPassword());
	}
	
	@GetMapping("/getPoliciesByUserId/{userId}")
	public List<Policy> getPoliciesFromUserId(@PathVariable(value="userId") String userId) throws CustomerException, PolicyException{
		System.out.println("user id form controller "+userId);
		Customer customer = customerService.getCustomerByUserId(userId);
		return customer.getPolicyList();
	}
	
	@GetMapping("/getCustomerIdByUserId/{userId}")
	public int getCustomerIdFromUserId(@PathVariable(value="userId") String userId) throws CustomerException{
		Customer customer = customerService.getCustomerByUserId(userId);
		return customer.getCustId();
	}
	
}
