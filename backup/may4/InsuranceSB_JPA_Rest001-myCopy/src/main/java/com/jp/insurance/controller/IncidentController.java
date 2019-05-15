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

import com.jp.insurance.entities.Incident;
import com.jp.insurance.exception.IncidentException;
import com.jp.insurance.service.IncidentService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/incidents")
public class IncidentController {
	// @Autowired IncidentService
	@Autowired
	private IncidentService incidentService;
	
	@GetMapping(value="",produces="application/json")
	public List<Incident> getIncidentList() throws IncidentException {
		// call dao layer method and return to Client.
		System.out.println("Incident list");
		return incidentService.getIncidentList();
	}

	//http://localhost:8082/api/incidents/1
	@GetMapping("/{incidentId}")
	public ResponseEntity<Incident> getIncidentById(@PathVariable(value="incidentId") Integer incidentId) throws IncidentException{
		Incident incident = incidentService.getIncidentById(incidentId);
		return ResponseEntity.ok().body(incident);
	}
	
	//http://localhost:8082/api/incidents/save
	@PostMapping("/save")
	public HttpStatus saveIncident(@RequestBody Incident incident) throws IncidentException{
		return incidentService.addIncident(incident)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/incidents/1
	@PutMapping("/update/{incidentId}")
	public HttpStatus updateIncident(@PathVariable(value="incidentId") Integer incidentId,@Valid @RequestBody Incident incidentDetails) throws IncidentException{
		Incident incident = incidentService.getIncidentById(incidentId);
		if(incident==null)
			return HttpStatus.BAD_REQUEST;
		else{
			incident.setIncidentType(incidentDetails.getIncidentType());
			incident.setIncidentDate(incidentDetails.getIncidentDate());
			incident.setIncidentDescription(incidentDetails.getIncidentDescription());
			
			return incidentService.updateIncident(incident)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{incidentId}")
	public Map<String, Boolean> deleteIncidentById(@PathVariable(value="incidentId")Integer incidentId) throws IncidentException{
		Incident incident = incidentService.getIncidentById(incidentId);
		Map<String, Boolean> response = new HashMap<>();
		if(incident!=null){
			incidentService.deleteIncidentById(incidentId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
