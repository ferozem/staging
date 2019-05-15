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

import com.jp.insurance.entities.Payment;
import com.jp.insurance.exception.PaymentException;
import com.jp.insurance.service.PaymentService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/payments")
public class PaymentController {
	// @Autowired PaymentService
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value="",produces="application/json")
	public List<Payment> getPaymentList() throws PaymentException {
		// call dao layer method and return to Client.
		System.out.println("Payment list");
		return paymentService.getPaymentList();
	}

	//http://localhost:8082/api/payments/1
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="paymentId") Integer paymentId) throws PaymentException{
		Payment payment = paymentService.getPaymentById(paymentId);
		return ResponseEntity.ok().body(payment);
	}
	
	//http://localhost:8082/api/payments/save
	@PostMapping("/save")
	public HttpStatus savePayment(@RequestBody Payment payment) throws PaymentException{
		return paymentService.addPayment(payment)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/payments/1
	@PutMapping("/{paymentId}")
	public HttpStatus updatePayment(@PathVariable(value="paymentId") Integer paymentId,@Valid @RequestBody Payment paymentDetails) throws PaymentException{
		Payment payment = paymentService.getPaymentById(paymentId);
		if(payment==null)
			return HttpStatus.BAD_REQUEST;
		else{
			payment.setCustId(paymentDetails.getCustId());
			payment.setAmount(paymentDetails.getAmount());
			payment.setPaymentDate(paymentDetails.getPaymentDate());
			payment.setPaymentModeType(paymentDetails.getPaymentModeType());
			payment.setStatus(paymentDetails.getStatus());
			return paymentService.updatePayment(payment)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{paymentId}")
	public Map<String, Boolean> deletePaymentById(@PathVariable(value="paymentId")Integer paymentId) throws PaymentException{
		Payment payment = paymentService.getPaymentById(paymentId);
		Map<String, Boolean> response = new HashMap<>();
		if(payment!=null){
			paymentService.deletePaymentById(paymentId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
