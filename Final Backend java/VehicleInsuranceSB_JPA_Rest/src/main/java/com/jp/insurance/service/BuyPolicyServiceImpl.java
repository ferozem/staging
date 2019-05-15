package com.jp.insurance.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.insurance.dao.CustomerDao;
import com.jp.insurance.dao.PolicyDao;
import com.jp.insurance.dao.PolicyDaoImpl;
import com.jp.insurance.dao.ProductDao;
import com.jp.insurance.dao.VehicleDao;
import com.jp.insurance.entities.BuyPolicy;
import com.jp.insurance.entities.Customer;
import com.jp.insurance.entities.Nominee;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.entities.Product;
import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.NomineeException;
import com.jp.insurance.exception.PolicyException;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.exception.VehicleException;



@Service
public class BuyPolicyServiceImpl implements BuyPolicyService {
	private final Logger logger = LoggerFactory.getLogger(PolicyDaoImpl.class);
	
	private Double policyFactor; 
	private Double calcPremium;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	LocalDateTime localDateTime = LocalDateTime.now();
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private PolicyDao policyDao;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private NomineeService nomineeService;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private ISendMail iSendMail;
	

	@Override
//	public Policy buyPolicy(Integer custId, Vehicle vehicle, Integer productNumber, Integer tenure,
//			Date policyIssueDate) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException {
//	
	public Policy buyPolicy(BuyPolicy buyPolicy) throws PolicyException, ProductException, CustomerException, VehicleException, NomineeException {
	
		//Initialize fields
				Policy policy= new Policy();
				Integer custId = null;
				Integer productNumber = null;
				Integer tenure = null;
				Date policyIssueDate = null;
				Vehicle vehicle = new Vehicle();
				String nomineeName = null;
				Date nomineeDate = null;
				String nomineeRelation = null;
				String nomineeIdtype = null;
				String nomineeIdnumber = null;
				Long nomineePhonenumber = null;
				Nominee nominee =  new Nominee();
				
				//populate from request body
						
				vehicle = buyPolicy.getVehicle();
				//System.out.println("Vehicle details received are : "+vehicle);
				
				//nominee = buyPolicy.getNominee();
				//System.out.println("Nominee details received are : "+nominee);
				custId = buyPolicy.getCustId();
				//System.out.println("Cust ID received  : "+custId);
				productNumber = buyPolicy.getProductNumber();
				//System.out.println("productNumber received  : "+productNumber);
				tenure = buyPolicy.getTenure();
				//System.out.println("tenure received  : "+tenure);
				policyIssueDate = buyPolicy.getPolicyIssueDate();
				//System.out.println("policy issue date received  : "+tenure);
				nomineeName = buyPolicy.getNomineeName();
				//System.out.println("nomineeName received  : "+nomineeName);
				nomineeDate = buyPolicy.getNomineeDate();
				//System.out.println("nomineeDate received  : "+nomineeDate);
				nomineeRelation = buyPolicy.getNomineeRelation();
				//System.out.println("nomineeRelation received  : "+nomineeRelation);
				nomineeIdtype = buyPolicy.getNomineeIdtype();
				//System.out.println("nomineeIdtype received  : "+nomineeIdtype);
				nomineeIdnumber = buyPolicy.getNomineeIdnumber();
				//System.out.println("nomineeIdnumber received  : "+nomineeIdnumber);
				nomineePhonenumber = buyPolicy.getNomineePhonenumber();
				//System.out.println("nomineePhonenumber received  : "+nomineePhonenumber);
				
				
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy"); 
		
		String localDate = localDateTime.format(formatter);
		Date date1=null;
		Date date2=null;
		String dt1 = null;
		try {
			date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(localDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//System.out.println("Today Date: " +date1);
		Product product = productDao.getProductById(productNumber);
		
		//System.out.println("product details " +product);
		//System.out.println("customer Id: " + custId);
		Customer customer = customerDao.getCustomerById(custId);
		//System.out.println("Customer details " +customer);
		
		Customer customer1 = null;
		//String userId1=null;
		//userId1="pradeep";
		//customer1 = customerDao.getCustomerByUserId(userId1);
		
		//System.out.println("Customer fetched by user id: "+ userId1 +"is: " + customer1);
		
		Vehicle vehicle1 = vehicleDao.findVehicleBydetails(custId, vehicle.getVehicleType(),vehicle.getVehicleRegNumber(), vehicle.getVehicleChasisNumber(), vehicle.getVehicleEngineNumber());
		
		if (vehicle1 != null)
		{
			System.out.println("vehicle found in db:" +vehicle1);
		}
		switch (product.getProductType())
		{
			case "2WLR INSURANCE" :
				policyFactor = 0.01;
				System.out.println("2WLR INSURANCE: "+ "Factor: " +policyFactor);
			case "3WLR INSURANCE" :
				policyFactor = 0.02;
				System.out.println("3WLR INSURANCE: "+ "Factor: " +policyFactor);
			case "4WLR INSURANCE" :
				policyFactor = 0.03;
				System.out.println("4WLR INSURANCE: "+ "Factor: " +policyFactor);
			default:
				policyFactor = 0.04;
				System.out.println("Default: "+ "Factor: " +policyFactor);
		}
		
		//System.out.println(product.getProductPrice());
		//System.out.println(vehicle.getVehicleIdvValue());
		calcPremium = ((product.getProductPrice()) + (vehicle.getVehicleIdvValue()*policyFactor));
		//System.out.println("calcPremium :" +calcPremium );
		
		switch (tenure)
		{
			case 1 :
				calcPremium = calcPremium*1;
				System.out.println("Tenure: "+ "premium: " +calcPremium);
				if(!(policyIssueDate == null))
				{
					date1 = policyIssueDate;
				}
				calendar.setTime(date1);
				calendar.add(Calendar.DATE,365);
				dt1 = formatter1.format(calendar.getTime());
				try {
					date2 = new SimpleDateFormat("dd-MMM-yyyy").parse(dt1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2 :
				calcPremium = calcPremium*0.85;
				System.out.println("Tenure: "+ "premium: " +calcPremium);
				if(!(policyIssueDate == null))
				{
					date1 = policyIssueDate;
				}
				calendar.setTime(date1);
				calendar.add(Calendar.DATE,730);
				dt1 = formatter1.format(calendar.getTime());
				try {
					date2 = new SimpleDateFormat("dd-MMM-yyyy").parse(dt1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3 :
				calcPremium = calcPremium*0.65;
				System.out.println("Tenure: "+ "premium: " +calcPremium);
				if(!(policyIssueDate == null))
				{
					date1 = policyIssueDate;
				}
				calendar.setTime(date1);
				calendar.add(Calendar.DATE,1095);
				dt1 = formatter1.format(calendar.getTime());
				try {
					date2 = new SimpleDateFormat("dd-MMM-yyyy").parse(dt1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				calcPremium = calcPremium*1;
				System.out.println("Tenure: "+ "premium: " +calcPremium);
		}
		
		//Populating Policy Details
		
		//policy issue date 
		if (date1!=null)
		{
			policy.setPolicyIssueDate(date1);
			System.out.println("date format done: "+date1);
		}
		else
		{
			System.out.println("date format error!!!!");
		}
		//policy Expiry and renewal date 
		if (date2!=null)
		{
			policy.setPolicyExpiryDate(date2);
			policy.setRenualDate(date2);
			System.out.println("date format done: "+date1);
			
		}
		else
		{
			System.out.println("date format error!!!!");
		}
		
		//policySumAssured
		policy.setPolicySumAssured(vehicle.getVehicleIdvValue());
		//set Policy Type
		policy.setPolicyType(productNumber);
		//vechicleRegId
		policy.setVechicleRegId(vehicle.getVehicleRegNumber());
		//policy status
		policy.setPolicyStatus("Active");
		//total premium
		policy.setTotalPremium(calcPremium);
		//Policy Customer	
		policy.setCustomer(customer);
		
		//INSERTING VEHICLE DETAILS
		
		if (vehicle1 == null){
			vehicle.setCustId(custId);
			vehicleService.addVehicle(vehicle);
			//System.out.println("inserted vehicle in db:" + vehicle);
			logger.info("inserted vehicle in db:" + vehicle);
		}
		else
		{
			vehicle = vehicle1;
			System.out.println("referred vehicle in db:" + vehicle);
			logger.info("referred vehicle in db:" + vehicle);
			//vehicle.setVehicleId(vehicle1.getVehicleId());
		}
		
		
		// Inserting nominee details. 
		
		nominee.setCustomer(customer);
		nominee.setNomineeName(nomineeName);
		nominee.setNomineeDate(nomineeDate);
		nominee.setNomineeRelation(nomineeRelation);
		nominee.setNomineeIdtype(nomineeIdtype);
		nominee.setNomineePhonenumber(nomineePhonenumber);
		
		nomineeService.addNominee(nominee);
		
		//System.out.println(nominee);
		//Policy Nominee
		policy.setNominee(nominee);
		logger.info("inserted nominee in db:" + nominee);
		
		//Policy Vehicle
		
		policy.setVehicle(vehicle);
		logger.info("inserted vehicle in db:" + vehicle);
		
		//Inserting Policy 
		policyService.addPolicy(policy);
		logger.info("inserted policy in db:" + policy);
		
		//Email Service 
				logger.info("Sending Email to :"+ customer.getCustEmail());
		/*
		 * System.out.println("Policy create :"+ policy);
		 * System.out.println("Sending Email to :"+ customer.getCustEmail());
		 */
				iSendMail.MailJpmc(customer.getCustEmail(), policy.getPolicyNumber());
		
//conversion of localdate to sql date
//		LocalDate locald = LocalDate.of(1967, 06, 22);
//		Date date = Date.valueOf(locald); // Magic happens here!
//		r.setDateOfBirth(date);
		return policy;
	}

}
