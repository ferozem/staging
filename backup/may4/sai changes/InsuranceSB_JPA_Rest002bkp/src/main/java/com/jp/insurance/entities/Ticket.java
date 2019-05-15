package com.jp.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TICKET")
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
    @Column(name="EMPID")
    private Long empId;
    
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
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Ticket(Long ticketNumber, String ticketDescription, String ticketStatus, Long empId) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketDescription = ticketDescription;
		this.ticketStatus = ticketStatus;
		this.empId = empId;
	}
	public Ticket() {
		super();
	}
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", ticketDescription=" + ticketDescription + ", ticketStatus="
				+ ticketStatus + ", empId=" + empId + "]";
	}

   /* @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
    @JoinColumn(name="EMPID")
    private Employee employee;*/

  

}
