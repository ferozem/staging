package com.jp.insurance.dao;
import java.util.List;

import com.jp.insurance.entities.Customer;
import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.VehicleException;

/** @author Feroze **/
public interface VehicleDao {
	public Integer addVehicle(Vehicle vehicle)throws VehicleException;//C-create
	public List<Vehicle> getVehicleList()throws VehicleException;//R All Vehicle -retrieve
	public boolean updateVehicle(Vehicle vehicle)throws VehicleException;//U-update
	public boolean deleteVehicleById(Integer vehicleId)throws VehicleException;//D-delete
	public Vehicle getVehicleById(Integer vehicleId)throws VehicleException;//S-search
	public Vehicle findVehicleBydetails(Integer custId, String vehicleType,String vehicleRegNumber, Integer vehicleChasisNumber, Integer vehicleEngineNumber)throws VehicleException;//S-search
}
