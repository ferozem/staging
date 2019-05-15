package com.jp.insurance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@SequenceGenerator(name="CUSTOMER_GEN", sequenceName="CUSTOMER_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CUSTOMER_GEN")
    @Id
    @Column(name="CUST_ID")
    private Integer custId;

    @Column(name="CUST_FNAME")
    private String custFname;

    @Column(name="CUST_LNAME")
    private String custLname;

    @Column(name="CUST_DOB")
    private Date custDob;

    @Column(name="CUST_GENDER")
    private String custGender;


    @Column(name="ADDRESS_LINE1")
    private String custAddressLine1;
    @Column(name="ADDRESS_LINE2")
    private String custAddressLine2;
    @Column(name="CITY")
    private String custCity;
    @Column(name="STATE")
    private String custState;
    @Column(name="ZIPCODE")
    private String custZipCode;
    @Column(name="COUNTRY")
    private String custCountry;
    @Column(name="CUST_MOB_NUMBER")
    private String mobile;
    @Column(name="CUST_EMAIL")
    private String custEmail;
    @Column(name="BLOODGROUP")
    private String customerbloodGroup;
    @Column(name="ID_TYPE")
    private String identityType;
    @Column(name="ID_NUMBER")
    private String idNumber;
    @Column(name="USERID")
    private String userId;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="CUST_MARITAL_STATUS")
    private String maritalStatus;
    
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	 @JsonManagedReference
	private List<Nominee> nomineeList;
    
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	 @JsonManagedReference
	private List<Ticket> ticketList;

    public List<Nominee> getNomineeList() {
		return nomineeList;
	}

	public void setNomineeList(List<Nominee> nomineeList) {
		this.nomineeList = nomineeList;
	}
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Policy> policyList; 
   
	public List<Policy> getPolicyList() {
			return policyList;
		}

	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}


	public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustFname() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    public Date getCustDob() {
        return custDob;
    }

    public void setCustDob(Date custDob) {
        this.custDob = custDob;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustAddressLine1() {
		return custAddressLine1;
	}

	public void setCustAddressLine1(String custAddressLine1) {
		this.custAddressLine1 = custAddressLine1;
	}

	public String getCustAddressLine2() {
		return custAddressLine2;
	}

	public void setCustAddressLine2(String custAddressLine2) {
		this.custAddressLine2 = custAddressLine2;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustZipCode() {
		return custZipCode;
	}

	public void setCustZipCode(String custZipCode) {
		this.custZipCode = custZipCode;
	}

	public String getCustCountry() {
		return custCountry;
	}

	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

 
    public Customer() {

    }

	public String getCustomerbloodGroup() {
		return customerbloodGroup;
	}

	public void setCustomerbloodGroup(String customerbloodGroup) {
		this.customerbloodGroup = customerbloodGroup;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public Customer(Integer custId, String custFname, String custLname, Date custDob, String custGender,
			String custAddressLine1, String custAddressLine2, String custCity, String custState, String custZipCode,
			String custCountry, String mobile, String custEmail, String customerbloodGroup, String identityType,
			String idNumber, String userId, String password, String maritalStatus) {
		super();
		this.custId = custId;
		this.custFname = custFname;
		this.custLname = custLname;
		this.custDob = custDob;
		this.custGender = custGender;
		this.custAddressLine1 = custAddressLine1;
		this.custAddressLine2 = custAddressLine2;
		this.custCity = custCity;
		this.custState = custState;
		this.custZipCode = custZipCode;
		this.custCountry = custCountry;
		this.mobile = mobile;
		this.custEmail = custEmail;
		this.customerbloodGroup = customerbloodGroup;
		this.identityType = identityType;
		this.idNumber = idNumber;
		this.userId = userId;
		this.password = password;
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custFname=" + custFname + ", custLname=" + custLname + ", custDob="
				+ custDob + ", custGender=" + custGender + ", custAddressLine1=" + custAddressLine1
				+ ", custAddressLine2=" + custAddressLine2 + ", custCity=" + custCity + ", custState=" + custState
				+ ", custZipCode=" + custZipCode + ", custCountry=" + custCountry + ", mobile=" + mobile
				+ ", custEmail=" + custEmail + ", customerbloodGroup=" + customerbloodGroup + ", identityType="
				+ identityType + ", idNumber=" + idNumber + ", userId=" + userId + ", password=" + password
				+ ", maritalStatus=" + maritalStatus + "]";
	}

	}
