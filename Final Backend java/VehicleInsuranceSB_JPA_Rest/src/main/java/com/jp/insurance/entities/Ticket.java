package com.jp.insurance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TICKET")
//@JsonIgnoreProperties("customer")
public class Ticket implements Serializable {
	@Id
	@SequenceGenerator(name="TICKET_GEN", sequenceName="TICKET_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TICKET_GEN")
	@Column(name="TICKET_NUMBER")
    private Long ticketNumber;
	@Column(name="CUST_ID")
    private Long custId;
    @Column(name="TICKET_DESCRIPTION")
    private String ticketDescription;
    @Column(name="TICKET_STATUS")
    private String ticketStatus;
    @Column(name="EMPID")
    private Long empId;
    
	
	/*@ManyToOne//(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
    @JoinColumn(name="EMPID")
   @JsonBackReference
    private Employee employee;*/
    
//    @ManyToOne//(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
//    @JoinColumn(name="CUST_ID")
//    //@JsonManagedReference
//    @JsonBackReference
//    private Customer customer;
    
    /*public Integer getEmpId() {
		return employee.getEmpId();
	}*/
    
   
	public Long getTicketNumber() {
		return ticketNumber;
	}
	public Ticket(Long ticketNumber, String ticketDescription, String ticketStatus, Long empId, Long custId) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketDescription = ticketDescription;
		this.ticketStatus = ticketStatus;
		this.empId = empId;
		this.custId = custId;
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
	
	
	
	
	public Ticket() {
		super();
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", ticketDescription=" + ticketDescription + ", ticketStatus="
				+ ticketStatus + ", empId=" + empId + ", custId=" + custId + "]";
	}
	

	
  

}
