package com.jp.insurance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT")
public class Payment {
	
	@SequenceGenerator(name="PAYMENT_GEN", sequenceName="PAYMENT_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PAYMENT_GEN")
    @Id
    @Column(name="PAYMENT_ID")
	private Integer paymentId;
	
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="AMOUNT")
	private Double amount;
	
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;
	
	@Column(name="PAYMENT_MODE_TYPE")
	private String paymentModeType;
	
	@Column(name="STATUS")
	private String status;

	public Payment(Integer paymentId, Integer custId, Double amount, Date paymentDate, String paymentModeType,
			String status) {
		super();
		this.paymentId = paymentId;
		this.custId = custId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentModeType = paymentModeType;
		this.status = status;
	}

	public Payment() {
		
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentModeType() {
		return paymentModeType;
	}

	public void setPaymentModeType(String paymentModeType) {
		this.paymentModeType = paymentModeType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", custId=" + custId + ", amount=" + amount + ", paymentDate="
				+ paymentDate + ", paymentModeType=" + paymentModeType + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
