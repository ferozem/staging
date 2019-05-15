package com.jp.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TICKET")
@JsonIgnoreProperties("customer")
public class Ticket {
	@Id
	@SequenceGenerator(name="TICKET_GEN", sequenceName="TICKET_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TICKET_GEN")
	
    @Column(name="TICKET_NUMBER")
    private Long ticketNumber;
    @Column(name="TICKET_DESCRIPTION")
    private String ticketDescription;
    @Column(name="TICKET_STATUS")
    private String ticketStatus;
   /* @Column(name="EMPID")
    private Long empId;*/
   
	
	@ManyToOne//(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
    @JoinColumn(name="EMPID")
   @JsonBackReference
	//@JsonManagedReference
    private Employee employee;
    
    @ManyToOne//(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
    @JoinColumn(name="CUST_ID")
   //@JsonBackReference
    @JsonManagedReference
    private Customer customer;
    
   /* public Integer getEmpId() {
		return employee.getEmpId();
	}*/
    
    
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
	
	public Ticket(Long ticketNumber, String ticketDescription, String ticketStatus, Employee employee,
			Customer customer) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketDescription = ticketDescription;
		this.ticketStatus = ticketStatus;
		this.employee = employee;
		this.customer = customer;
	}
	public Ticket() {
		super();
	}
	

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", ticketDescription=" + ticketDescription + ", ticketStatus="
				+ ticketStatus + ", employee=" + employee + ", customer=" + customer + "]";
	}

  

}
