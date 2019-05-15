package com.jp.insurance.entities;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
//@Table(name="POLICY")
//public class BuyPolicy implements Serializable{
//@JsonIgnoreProperties("nominee")	
public class BuyPolicy implements Serializable{
	
	private static final long serialVersionUID = 3897977255041938629L;
	
	private Integer custId;
	private Integer productNumber;
	private Integer tenure;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date policyIssueDate;
	@JsonBackReference
	private Vehicle vehicle;
	private String nomineeName;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date nomineeDate;
	private String nomineeRelation;
	private String nomineeIdtype;
	private String nomineeIdnumber;
	private Long nomineePhonenumber;
	 
	
	
	public BuyPolicy() {
		super();
	}



	public Integer getCustId() {
		return custId;
	}



	public void setCustId(Integer custId) {
		this.custId = custId;
	}



	public Integer getProductNumber() {
		return productNumber;
	}



	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}



	public Integer getTenure() {
		return tenure;
	}



	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}



	public Date getPolicyIssueDate() {
		return policyIssueDate;
	}



	public void setPolicyIssueDate(Date policyIssueDate) {
		this.policyIssueDate = policyIssueDate;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}



	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	public String getNomineeName() {
		return nomineeName;
	}



	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}



	public Date getNomineeDate() {
		return nomineeDate;
	}



	public void setNomineeDate(Date nomineeDate) {
		this.nomineeDate = nomineeDate;
	}



	public String getNomineeRelation() {
		return nomineeRelation;
	}



	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}



	public String getNomineeIdtype() {
		return nomineeIdtype;
	}



	public void setNomineeIdtype(String nomineeIdtype) {
		this.nomineeIdtype = nomineeIdtype;
	}



	public String getNomineeIdnumber() {
		return nomineeIdnumber;
	}



	public void setNomineeIdnumber(String nomineeIdnumber) {
		this.nomineeIdnumber = nomineeIdnumber;
	}



	public Long getNomineePhonenumber() {
		return nomineePhonenumber;
	}



	public void setNomineePhonenumber(Long nomineePhonenumber) {
		this.nomineePhonenumber = nomineePhonenumber;
	}



	public BuyPolicy(Integer custId, Integer productNumber, Integer tenure, Date policyIssueDate, Vehicle vehicle,
			String nomineeName, Date nomineeDate, String nomineeRelation, String nomineeIdtype, String nomineeIdnumber,
			Long nomineePhonenumber) {
		super();
		this.custId = custId;
		this.productNumber = productNumber;
		this.tenure = tenure;
		this.policyIssueDate = policyIssueDate;
		this.vehicle = vehicle;
		this.nomineeName = nomineeName;
		this.nomineeDate = nomineeDate;
		this.nomineeRelation = nomineeRelation;
		this.nomineeIdtype = nomineeIdtype;
		this.nomineeIdnumber = nomineeIdnumber;
		this.nomineePhonenumber = nomineePhonenumber;
	}



	@Override
	public String toString() {
		return "BuyPolicy [custId=" + custId + ", productNumber=" + productNumber + ", tenure=" + tenure
				+ ", policyIssueDate=" + policyIssueDate + ", vehicle=" + vehicle + ", nomineeName=" + nomineeName
				+ ", nomineeDate=" + nomineeDate + ", nomineeRelation=" + nomineeRelation + ", nomineeIdtype="
				+ nomineeIdtype + ", nomineeIdnumber=" + nomineeIdnumber + ", nomineePhonenumber=" + nomineePhonenumber
				+ "]";
	}
		
	
}
