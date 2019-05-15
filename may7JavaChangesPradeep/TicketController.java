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

import com.jp.insurance.entities.Ticket;
import com.jp.insurance.exception.TicketException;
import com.jp.insurance.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;

//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/tickets")
public class TicketController {
	// @Autowired TicketService
	@Autowired
	private TicketService ticketService;
	
	//http://localhost:8082/api/tickets/
	@GetMapping(value="",produces="application/json")
	public List<Ticket> getTicketList() throws TicketException {
		// call dao layer method and return to Client.
		System.out.println("Ticket list");
		return ticketService.getTicketList();
	}

	//http://localhost:8082/api/tickets/1
	@GetMapping("/{ticketId}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable(value="ticketId") Long ticketId) throws TicketException{
		Ticket ticket = ticketService.getTicketById(ticketId);
		return ResponseEntity.ok().body(ticket);
	}
	
	//http://localhost:8082/api/tickets/save
	@PostMapping("/save")
	public HttpStatus saveTicket(@RequestBody Ticket ticket) throws TicketException{
		System.out.println("From controller: " + ticket);
		Long ticketId = ticketService.addTicket(ticket);
		return ticketId!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/tickets/1
	@PutMapping("/{ticketId}")
	public HttpStatus updateTicket(@PathVariable(value="ticketId") Long ticketId,@Valid @RequestBody Ticket ticketDetails) throws TicketException{
		Ticket ticket = ticketService.getTicketById(ticketId);
		if(ticket==null)
			return HttpStatus.BAD_REQUEST;
		else{
			 
			ticket.setCustId(ticketDetails.getCustId());
			ticket.setTicketDescription(ticketDetails.getTicketDescription());
			ticket.setTicketStatus(ticketDetails.getTicketStatus());
			ticket.setEmpId(ticketDetails.getEmpId());
			//(ticketDetails.getEmployee().getEmpId()); 
				
			return ticketService.updateTicket(ticket)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{ticketId}")
	public Map<String, Boolean> deleteTicketById(@PathVariable(value="ticketId")Long ticketId) throws TicketException{
		Ticket ticket = ticketService.getTicketById(ticketId);
		Map<String, Boolean> response = new HashMap<>();
		if(ticket!=null){
			ticketService.deleteTicketById(ticketId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
	

	//http://localhost:8082/api/ticket/getTicket/byCustId/{custId}	
	@GetMapping(path="/getTicket/byCustId/{custId}" ,produces="application/json")
	public List<Ticket> getTicketByCustId(@PathVariable Integer custId) throws TicketException{
		return ticketService.getTicketListbyCustID(custId);
	}
}
