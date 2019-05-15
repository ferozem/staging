package com.jp.insurance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable{
	@Id
	@Column(name="EMPLOYEE_ID")
	private Integer empId;
	
	@Column(name="EMPLOYEE_FNAME")
	private String firstName;
	
	@Column(name="EMPLOYEE_LNAME")
	private String lastName;
	
	@Column(name="EMPLOYEE_USERNAME")
	private String empUsername;
	
	@Column(name="EMPLOYEE_PASSWORD")
	private String empPassword;

	public Employee() {
		//Default Constructor
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getUserPassword() {
		return empPassword;
	}

	public void setUserPassword(String userPassword) {
		this.empPassword = userPassword;
	}
	
	
	
	
	
	

}
