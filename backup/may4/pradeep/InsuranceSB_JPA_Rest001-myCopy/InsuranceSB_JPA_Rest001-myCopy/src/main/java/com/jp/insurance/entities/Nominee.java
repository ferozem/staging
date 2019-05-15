package com.jp.insurance.entities;

import java.util.Date;

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

@Entity
@Table(name="NOMINEE")
public class Nominee {
	@Id
	@SequenceGenerator(name="NOMINEE_GEN", sequenceName="NOMINEE_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="NOMINEE_GEN")
	
    @Column(name="NOMINEE_ID ")
    private Long nomineeId;
	/*@Column(name="CUST_ID ")
	private Long custId;*/
    

	@Column(name="NOMINEE_NAME")
    private String nomineeName;
    @Column(name="NOMINEE_DATE")
    private Date nomineeDate;
    @Column(name="NOMINEE_RELATION")
    private String nomineeRelation;
    @Column(name="NOMINEE_IDTYPE")
    private String nomineeIdtype;
    @Column(name="NOMINEE_IDNUMBER")
    private String nomineeIdnumber;
    @Column(name="NOMINEE_PHONENUMBER")
    private Long nomineePhonenumber;
    @ManyToOne//(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//EAGER FETCHING and LAZY FETCHING
    @JoinColumn(name="CUST_ID")
   @JsonBackReference
    private Customer customer;
    
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Nominee() {
		super();
	}
	
	public Nominee(Long nomineeId, String nomineeName, Date nomineeDate, String nomineeRelation, String nomineeIdtype,
			String nomineeIdnumber, Long nomineePhonenumber, Customer customer) {
		super();
		this.nomineeId = nomineeId;
		this.nomineeName = nomineeName;
		this.nomineeDate = nomineeDate;
		this.nomineeRelation = nomineeRelation;
		this.nomineeIdtype = nomineeIdtype;
		this.nomineeIdnumber = nomineeIdnumber;
		this.nomineePhonenumber = nomineePhonenumber;
		this.customer = customer;
	}

	public Long getNomineeId() {
		return nomineeId;
	}
	public void setNomineeId(Long nomineeId) {
		this.nomineeId = nomineeId;
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
	

	public Integer getCustId() {
		return customer.getCustId();
	}
	
	@Override
	public String toString() {
		return "Nominee [nomineeId=" + nomineeId + ", nomineeName=" + nomineeName + ", nomineeDate=" + nomineeDate
				+ ", nomineeRelation=" + nomineeRelation + ", nomineeIdtype=" + nomineeIdtype + ", nomineeIdnumber="
				+ nomineeIdnumber + ", nomineePhonenumber=" + nomineePhonenumber + ", getCustId()=" + getCustId() + "]";
	}
	
    
}
