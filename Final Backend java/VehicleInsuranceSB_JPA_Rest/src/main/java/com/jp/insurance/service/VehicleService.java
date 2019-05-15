package com.jp.insurance.service;
import java.util.List;

import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.VehicleException;



/** @author Feroze **/
public interface VehicleService {
	//CRUDS Operation
	public Integer addVehicle(Vehicle vehicle)throws VehicleException;//C-create
	public List<Vehicle> getVehicleList()throws VehicleException;//R All Vehicle -retrieve
	public boolean updateVehicle(Vehicle vehicle)throws VehicleException;//U-update
	public boolean deleteVehicleById(Integer vehicleId)throws VehicleException;//D-delete
	public Vehicle getVehicleById(Integer vehicleId)throws VehicleException;//S-search
	public Vehicle getVehicleBydetails(Integer custId, String vehicleType, String vehicleRegNumber,
			String vehicleChasisNumber, String vehicleEngineNumber) throws VehicleException;
}
