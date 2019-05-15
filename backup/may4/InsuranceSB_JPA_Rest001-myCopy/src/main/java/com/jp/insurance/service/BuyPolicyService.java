
package com.jp.insurance.service;

import java.util.Date;
import java.util.List;

import com.jp.insurance.entities.BuyPolicy;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.NomineeException;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.exception.VehicleException;


public interface BuyPolicyService {
	
	//Policy buyPolicy(Integer custId, Vehicle vehicle, Integer productNumber, Integer tenure, Date policyIssueDate) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException;
	Policy buyPolicy(BuyPolicy buyPolicy) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException;
	
}
