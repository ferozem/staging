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

import com.jp.insurance.entities.Receipt;
import com.jp.insurance.exception.ReceiptException;
import com.jp.insurance.service.ReceiptService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/receipts")
public class ReceiptController {
	// @Autowired ReceiptService
	@Autowired
	private ReceiptService receiptService;
	
	@GetMapping(value="",produces="application/json")
	public List<Receipt> getReceiptList() throws ReceiptException {
		// call dao layer method and return to Client.
		System.out.println("Receipt list");
		return receiptService.getReceiptList();
	}

	//http://localhost:8082/api/receipts/1
	@GetMapping("/{receiptId}")
	public ResponseEntity<Receipt> getReceiptById(@PathVariable(value="receiptId") Integer receiptId) throws ReceiptException{
		Receipt receipt = receiptService.getReceiptById(receiptId);
		return ResponseEntity.ok().body(receipt);
	}
	
	//http://localhost:8082/api/receipts/save
	@PostMapping("/save")
	public HttpStatus saveReceipt(@RequestBody Receipt receipt) throws ReceiptException{
		return receiptService.addReceipt(receipt)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/receipts/1
	@PutMapping("/update/{receiptId}")
	public HttpStatus updateReceipt(@PathVariable(value="receiptId") Integer receiptId,@Valid @RequestBody Receipt receiptDetails) throws ReceiptException{
		Receipt receipt = receiptService.getReceiptById(receiptId);
		if(receipt==null)
			return HttpStatus.BAD_REQUEST;
		else{
			receipt.setCost(receiptDetails.getCost());
			receipt.setCustId(receiptDetails.getCustId());
			receipt.setPremiumPaymentId(receiptDetails.getPremiumPaymentId());
			receipt.setTime(receiptDetails.getTime());
			return receiptService.updateReceipt(receipt)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{receiptId}")
	public Map<String, Boolean> deleteReceiptById(@PathVariable(value="receiptId")Integer receiptId) throws ReceiptException{
		Receipt receipt = receiptService.getReceiptById(receiptId);
		Map<String, Boolean> response = new HashMap<>();
		if(receipt!=null){
			receiptService.deleteReceiptById(receiptId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
