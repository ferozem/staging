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

import com.jp.insurance.entities.Nominee;
import com.jp.insurance.exception.NomineeException;
import com.jp.insurance.service.NomineeService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/nominee")
public class NomineeController {
	// @Autowired NomineeService
	@Autowired
	private NomineeService nomineeService;
	
	@GetMapping(value="",produces="application/json")
	public List<Nominee> getNomineeList() throws NomineeException {
		// call dao layer method and return to Client.
		System.out.println("Nominee list");
		return nomineeService.getNomineeList();
	}

	//http://localhost:8082/api/nominees/1
	@GetMapping("/{nomineeId}")
	public ResponseEntity<Nominee> getNomineeById(@PathVariable(value="nomineeId") Long nomineeId) throws NomineeException{
		Nominee nominee = nomineeService.getNomineeById(nomineeId);
		return ResponseEntity.ok().body(nominee);
	}
	
	//http://localhost:8082/api/nominees/save
	@PostMapping("/save")
	public HttpStatus saveNominee(@RequestBody Nominee nominee) throws NomineeException{
		return nomineeService.addNominee(nominee)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/nominees/1
	@PutMapping("/{nomineeId}")
	public HttpStatus updateNominee(@PathVariable(value="nomineeId") Long nomineeId,@Valid @RequestBody Nominee nomineeDetails) throws NomineeException{
		Nominee nominee = nomineeService.getNomineeById(nomineeId);
		if(nominee==null)
			return HttpStatus.BAD_REQUEST;
		else{
			nominee.setNomineeName(nomineeDetails.getNomineeName());
			nominee.setNomineeDate(nomineeDetails.getNomineeDate());
			nominee.setNomineeRelation(nomineeDetails.getNomineeRelation());
			nominee.setNomineeIdtype(nomineeDetails.getNomineeIdtype());
			nominee.setNomineeIdnumber(nomineeDetails.getNomineeIdnumber());
			nominee.setNomineePhonenumber(nomineeDetails.getNomineePhonenumber());
			//nominee.setCustomer();
			return nomineeService.updateNominee(nominee)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{nomineeNumber}")
	public Map<String, Boolean> deleteNomineeById(@PathVariable(value="nomineeNumber")Long nomineeNumber) throws NomineeException{
		Nominee nominee = nomineeService.getNomineeById(nomineeNumber);
		Map<String, Boolean> response = new HashMap<>();
		if(nominee!=null){
			nomineeService.deleteNomineeById(nomineeNumber);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
