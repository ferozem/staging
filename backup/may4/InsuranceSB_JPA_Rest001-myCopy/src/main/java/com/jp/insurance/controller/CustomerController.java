package com.jp.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.entities.Customer;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.service.CustomerService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/customers")
public class CustomerController {
	// @Autowired CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="",produces="application/json")
	public List<Customer> getCustomerList() throws CustomerException {
		// call dao layer method and return to Client.
		System.out.println("EMployee list");
		return customerService.getCustomerList();
	}

	//http://localhost:8082/api/customers/1
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="customerId") Integer empId) throws CustomerException{
		Customer customer = customerService.getCustomerById(empId);
		return ResponseEntity.ok().body(customer);
	}
	
	//http://localhost:8082/api/customers/save
	@PostMapping("/save")
	public HttpStatus saveCustomer(@RequestBody Customer customer) throws CustomerException{
		return customerService.addCustomer(customer)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/customers/1
	@PutMapping("/{customerId}")
	public HttpStatus updateCustomer(@PathVariable(value="customerId") Integer customerId,@Valid @RequestBody Customer customerDetails) throws CustomerException{
		Customer customer = customerService.getCustomerById(customerId);
		if(customer==null)
			return HttpStatus.BAD_REQUEST;
		else{
			customer.setCustFname(customerDetails.getCustFname());
			customer.setCustLname(customerDetails.getCustLname());
			customer.setCustDob(customerDetails.getCustDob());
			//customer.setCustAddress(customerDetails.getCustAddress());
			customer.setCustEmail(customerDetails.getCustEmail());
			
	
			return customerService.updateCustomer(customer)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{customerId}")
	public Map<String, Boolean> deleteCustomerById(@PathVariable(value="customerId")Integer customerId) throws CustomerException{
		Customer customer = customerService.getCustomerById(customerId);
		Map<String, Boolean> response = new HashMap<>();
		if(customer!=null){
			customerService.deleteCustomerById(customerId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
	
	//http://localhost:8082/api/customers/byUserId/{userId}
			@GetMapping("/byUserId/{userId}")
			public ResponseEntity<Customer>  getCustomerById(@PathVariable(value="userId") String userId) throws CustomerException{
				Customer customer = customerService.getCustomerByUserId(userId);
				return ResponseEntity.ok().body(customer);
			}
}
