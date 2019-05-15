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
@Table(name="CLAIM")
public class Claim {

	@SequenceGenerator(name="CUSTOMER_GEN", sequenceName="CUSTOMER_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CUSTOMER_GEN")
    @Id
    @Column(name="CLAIM_ID")
    private Integer claimId;
	
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="POLICY_NUMBER")
	private Integer policyNumber;
	
	@Column(name="CLAIM_AMOUNT")
	private Double claimAmount;

    @Column(name="DAMAGE_TYPE")
    private String damageType;

    @Column(name="DATE_OF_CLAIM")
    private Date dateOfClaim;

    @Column(name="DATE_SETTLED")
    private Date dateSettled;

    @Column(name="AMOUNT_PAID")
    private Double amountPaid;

    @Column(name="CLAIM_STATUS")
    private String claimStatus;

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public Date getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(Date dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

	public Date getDateSettled() {
		return dateSettled;
	}

	public void setDateSettled(Date dateSettled) {
		this.dateSettled = dateSettled;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Claim(Integer claimId, Integer custId, Integer policyNumber, Double claimAmount, String damageType,
			Date dateOfClaim, Date dateSettled, Double amountPaid, String claimStatus) {
		super();
		this.claimId = claimId;
		this.custId = custId;
		this.policyNumber = policyNumber;
		this.claimAmount = claimAmount;
		this.damageType = damageType;
		this.dateOfClaim = dateOfClaim;
		this.dateSettled = dateSettled;
		this.amountPaid = amountPaid;
		this.claimStatus = claimStatus;
	}

	
	public Claim() {
		super();
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", custId=" + custId + ", policyNumber=" + policyNumber + ", claimAmount="
				+ claimAmount + ", damageType=" + damageType + ", dateOfClaim=" + dateOfClaim + ", dateSettled="
				+ dateSettled + ", amountPaid=" + amountPaid + ", claimStatus=" + claimStatus + "]";
	}

    


}
