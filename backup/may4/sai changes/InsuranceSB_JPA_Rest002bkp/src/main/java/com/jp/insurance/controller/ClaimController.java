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

import com.jp.insurance.entities.Claim;
import com.jp.insurance.exception.ClaimException;
import com.jp.insurance.service.ClaimService;



//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/claims")
public class ClaimController {
	// @Autowired ClaimService
	@Autowired
	private ClaimService claimService;
	
	//http://localhost:8082/api/claims/
	@GetMapping(value="",produces="application/json")
	public List<Claim> getClaimList() throws ClaimException {
		// call dao layer method and return to Client.
		System.out.println("Claim list");
		return claimService.getClaimList();
	}

	//http://localhost:8082/api/claims/1
	@GetMapping("/{claimId}")
	public ResponseEntity<Claim> getClaimById(@PathVariable(value="claimId") Integer claimId) throws ClaimException{
		Claim claim = claimService.getClaimById(claimId);
		return ResponseEntity.ok().body(claim);
	}
	
	//http://localhost:8082/api/claims/save
	@PostMapping("/save")
	public HttpStatus saveClaim(@RequestBody Claim claim) throws ClaimException{
		return claimService.addClaim(claim)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/claims/1
	@PutMapping("/{claimId}")
	public HttpStatus updateClaim(@PathVariable(value="claimId") Integer claimId,@Valid @RequestBody Claim claimDetails) throws ClaimException{
		Claim claim = claimService.getClaimById(claimId);
		if(claim==null)
			return HttpStatus.BAD_REQUEST;
		else{
			claim.setAmountPaid(claimDetails.getAmountPaid());  
			claim.setClaimAmount(claimDetails.getClaimAmount());
			claim.setClaimStatus(claimDetails.getClaimStatus());
			claim.setCustId(claimDetails.getCustId());
			claim.setDamageType(claimDetails.getDamageType());
			claim.setDateOfClaim(claimDetails.getDateOfClaim());
			claim.setDateSettled(claimDetails.getDateSettled());
			claim.setPolicyNumber(claimDetails.getPolicyNumber());
		
			return claimService.updateClaim(claim)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{claimId}")
	public Map<String, Boolean> deleteClaimById(@PathVariable(value="claimId")Integer claimId) throws ClaimException{
		Claim claim = claimService.getClaimById(claimId);
		Map<String, Boolean> response = new HashMap<>();
		if(claim!=null){
			claimService.deleteClaimById(claimId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
