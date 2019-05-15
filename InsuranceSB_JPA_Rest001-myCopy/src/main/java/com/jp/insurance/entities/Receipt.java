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
@Table(name="RECEIPT")
public class Receipt {

	@SequenceGenerator(name="RECEIPT_GEN", sequenceName="RECEIPT_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="RECEIPT_GEN")
    @Id
    @Column(name="RECEIPT_ID")
    private Integer receiptId;

    @Column(name="PREMIUM_PAYMENT_ID")
    private Integer premiumPaymentId;

    @Column(name="CUST_ID")
    private Integer custId;

    @Column(name="COST")
    private Double cost;
    
    @Column(name="TIME")
    private Date time;

	public Integer getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}

	public Integer getPremiumPaymentId() {
		return premiumPaymentId;
	}

	public void setPremiumPaymentId(Integer premiumPaymentId) {
		this.premiumPaymentId = premiumPaymentId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Receipt() {
		super();
	}

	public Receipt(Integer receiptId, Integer premiumPaymentId, Integer custId, Double cost, Date time) {
		super();
		this.receiptId = receiptId;
		this.premiumPaymentId = premiumPaymentId;
		this.custId = custId;
		this.cost = cost;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Receipt [receiptId=" + receiptId + ", premiumPaymentId=" + premiumPaymentId + ", custId=" + custId
				+ ", cost=" + cost + ", time=" + time + "]";
	}


}
