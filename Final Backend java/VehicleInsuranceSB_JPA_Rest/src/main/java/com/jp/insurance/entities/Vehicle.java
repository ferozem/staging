package com.jp.insurance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	
	@SequenceGenerator(name="VEHICLE_GEN", sequenceName="VEHICLE_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VEHICLE_GEN")
    @Id
    @Column(name="VEHICLE_ID")
	private Integer vehicleId;
	
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="VEHICLE_REG_NUMBER")
	private String vehicleRegNumber;
	
	@Column(name="VEHICLE_CHASIS_NUMBER")
	private String vehicleChasisNumber;
	//private Integer vehicleChasisNumber;
	
	@Column(name="VEHICLE_ENGINE_NUMBER")
	private String vehicleEngineNumber;
	//private Integer vehicleEngineNumber;
	
	@Column(name="VEHICLE_MANUFACTURER")
	private String vehicleManufacturer;
	
	@Column(name="VEHICLE_MODEL_NUMBER")
	private String vehicleModelNumber;
	//private Integer vehicleModelNumber;
	
	
	@Column(name="VEHICLE_MFG_MMYYYY")
	private String vehicleMfgMMYYYY;
	
	@Column(name="VEHICLE_IDV_VALUE")
	private Double vehicleIdvValue;

	public Vehicle(Integer vehicleId, Integer custId, String vehicleType, String vehicleRegNumber,
			String vehicleChasisNumber, String vehicleEngineNumber, String vehicleManufacturer,
			String vehicleModelNumber, String vehicleMfgMMYYYY, Double vehicleIdvValue) {
		super();
		this.vehicleId = vehicleId;
		this.custId = custId;
		this.vehicleType = vehicleType;
		this.vehicleRegNumber = vehicleRegNumber;
		this.vehicleChasisNumber = vehicleChasisNumber;
		this.vehicleEngineNumber = vehicleEngineNumber;
		this.vehicleManufacturer = vehicleManufacturer;
		this.vehicleModelNumber = vehicleModelNumber;
		this.vehicleMfgMMYYYY = vehicleMfgMMYYYY;
		this.vehicleIdvValue = vehicleIdvValue;
	}

	public Vehicle() {
		
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}

	

	public String getVehicleChasisNumber() {
		return vehicleChasisNumber;
	}

	public void setVehicleChasisNumber(String vehicleChasisNumber) {
		this.vehicleChasisNumber = vehicleChasisNumber;
	}

	public String getVehicleEngineNumber() {
		return vehicleEngineNumber;
	}

	public void setVehicleEngineNumber(String vehicleEngineNumber) {
		this.vehicleEngineNumber = vehicleEngineNumber;
	}

	public String getVehicleModelNumber() {
		return vehicleModelNumber;
	}

	public void setVehicleModelNumber(String vehicleModelNumber) {
		this.vehicleModelNumber = vehicleModelNumber;
	}

	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	

	public String getVehicleMfgMMYYYY() {
		return vehicleMfgMMYYYY;
	}

	public void setVehicleMfgMMYYYY(String vehicleMfgMMYYYY) {
		this.vehicleMfgMMYYYY = vehicleMfgMMYYYY;
	}

	
	public Double getVehicleIdvValue() {
		return vehicleIdvValue;
	}

	public void setVehicleIdvValue(Double vehicleIdvValue) {
		this.vehicleIdvValue = vehicleIdvValue;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", custId=" + custId + ", vehicleType=" + vehicleType
				+ ", vehicleRegNumber=" + vehicleRegNumber + ", vehicleChasisNumber=" + vehicleChasisNumber
				+ ", vehicleEngineNumber=" + vehicleEngineNumber + ", vehicleManufacturer=" + vehicleManufacturer
				+ ", vehicleModelNumber=" + vehicleModelNumber + ", vehicleMfgMMYYYY=" + vehicleMfgMMYYYY
				+ ", vehicleIdvValue=" + vehicleIdvValue + "]";
	}

	
	
	
	
	
	
	
}
