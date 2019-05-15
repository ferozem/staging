package com.jp.insurance.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.entities.BuyPolicy;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.NomineeException;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.exception.VehicleException;
import com.jp.insurance.service.BuyPolicyService;
import com.jp.insurance.service.FutureDate;
import com.jp.insurance.service.PolicyService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/policy")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	@Autowired
	private BuyPolicyService buypolicyService;
	@Autowired
	private FutureDate futureDate;

//http://localhost:8080/api/policy/getPolicy/10001	
	@GetMapping(path="/getPolicy/{id}" ,produces="application/json")
	public Policy getPolicyById(@PathVariable Long id) throws PolicyException{
		return policyService.getPolicyById(id);
	}
	
	//http://localhost:8080/api/policy/list
	@GetMapping(value="/list",produces="application/json")
	public List<Policy> getPolicyList() throws PolicyException {
		// call dao layer method and return to Client.
		System.out.println("Policy list");
		return policyService.getPolicyList();
	}
	
	@Transactional
	@PostMapping(path="/addPolicy")
	public String addPolicy(@RequestBody Policy policy) throws PolicyException{
		Policy addedPolicy = policyService.addPolicy(policy);
		if(addedPolicy!=null)
			return "Policy Added with id: "+addedPolicy.getPolicyNumber();
		return "Adding Policy Failed!!";
	}
	
	//http://localhost:8080/api/policy/buyPolicy
		@Transactional
		//@PostMapping(path="/buyPolicy/{custId}/{productNumber}/{tenure}/{policyIssueDate}")
		@PostMapping(path="/buyPolicy/")
		//Integer custId, Vehicle vehicle, Integer productNumber, Integer tenure, Date policyIssueDate
		//public String buyPolicy(@RequestBody Integer custId, @RequestBody Vehicle vehicle,@RequestBody Integer productNumber,@RequestBody Integer tenure,@RequestBody Date policyIssueDate) throws PolicyException, ProductException, CustomerException, VehicleException{
		//	public String buyPolicy(@PathVariable Integer custId, @RequestBody Vehicle vehicle,@PathVariable Integer productNumber,@PathVariable Integer tenure,@PathVariable Date policyIssueDate) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException{
		//	Policy buyedPolicy = buypolicyService.buyPolicy(custId,vehicle,productNumber,tenure,policyIssueDate);
		public String buyPolicy(@RequestBody() BuyPolicy buyPolicy) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException{
			System.out.println("From Controller$$$$$$$$$$$$:" + buyPolicy);
			Policy buyedPolicy = buypolicyService.buyPolicy(buyPolicy);
			if(buyedPolicy!=null)
				return "Policy Added with id: "+buyedPolicy.getPolicyNumber();
			return "Adding Policy Failed!!";
		}
		
	
	
	@GetMapping(path="/getRenualPoliciesByDate/{date}" ,produces="application/json")
	public List<Policy> getRenualPoliciesByDate(@PathVariable Date date) throws PolicyException{
		return policyService.getRenualPoliciesByDate(date);
	}
	
	@GetMapping(path="/getRenualPolicies/{days}" ,produces="application/json")
	public List<Policy> getRenualPoliciesByDays(@PathVariable Integer days) throws PolicyException{
		Date futuredate = futureDate.getFutureDate(days);
		java.sql.Date date = new java.sql.Date(futuredate.getTime());
		return policyService.getRenualPoliciesByDate(date);
	}
	
	//http://localhost:8080/api/policy/getPolicy/byCustId/{custId}	
			@GetMapping(path="/getPolicy/byCustId/{custId}" ,produces="application/json")
			public List<Policy> getPolicyById(@PathVariable Integer custId) throws PolicyException{
				return policyService.getPolicyListbyCustID(custId);
			}
}
