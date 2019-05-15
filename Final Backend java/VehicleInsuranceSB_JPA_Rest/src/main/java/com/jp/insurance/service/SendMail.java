package com.jp.insurance.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.PolicyException;


@Service
public class SendMail implements ISendMail{
	
	@Autowired
		
	private PolicyService policyService;
	
	public String MailJpmc(String toName , Long policyId) throws PolicyException {
		System.out.println("Mail Sending to " +toName);
    final String username = "jcavinsurance@gmail.com";
    final String password = "jcavin@28";
//    final String username = "jpmcbus1@gmail.com";
//    final String password = "welcome1@";

    Properties prop = new Properties();
    
	prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS
    
    Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

    	//List<Bookings> book =  userService.getPassengerList(ticketNo);
    	Policy policy = policyService.getPolicyById(policyId);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("jcavinsurance@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                //InternetAddress.parse("sc800611@gmail.com, sureshch_us@yahoo.com")
                InternetAddress.parse(toName)
                
        );
        System.out.println("Mail Sending to " +toName);
        message.setSubject("Your Vehicle Insurance Policy Number : "+policyId+ " Created  ");
        message.setText("Dear Customer,"
                + "\n\n Your Policy details listed below" 
              
                                     		        		
        		);
        
       
        		
        	
        	message.setText(
        	"Dear Customer,"
        	+"\n Name Of the Customer   :" +policy.getCustomer().getCustFname() + policy.getCustomer().getCustLname()
        	+ "\n\n Your Policy details listed below" 
        	+"\n Your Policy Issue Date :" + policy.getPolicyType()
        	+"\n\n Your Policy Issue Date :" + policy.getPolicyIssueDate()
        	+"\n Your Policy Issue Date :" + policy.getPolicyExpiryDate()
        	+"\n Your TotalPremium :" + policy.getTotalPremium()
        	+"\n Source Location :" +policy.getNominee()
        	+"\n Total No of Seats :" + policy.getVechicleRegId()
        	+"\n VehicleChasisNumber :" +policy.getVehicle().getVehicleChasisNumber()
        	+"\n VehicleEngineNumber :" +policy.getVehicle().getVehicleEngineNumber()
        	+"\n VehicleIdvValue :" +policy.getVehicle().getVehicleIdvValue()
        	    	        	);
        	
	    
        
        Transport.send(message);

        System.out.println("Done");
        
        System.out.println("Email sent to :"+ toName);
        return "Done";

    } catch (MessagingException e) {
        e.printStackTrace();
        return "Not Done";
    }
    
	}
    

}

