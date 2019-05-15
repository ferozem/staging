package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.VehicleDao;
import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.VehicleException;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;

	@Override
	@Transactional
	public Integer addVehicle(Vehicle vehicle) throws VehicleException {
		// call dao layer method and return to Client.
		return vehicleDao.addVehicle(vehicle);
	}

	@Override
	public List<Vehicle> getVehicleList() throws VehicleException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return vehicleDao.getVehicleList();
	}

	@Override
	@Transactional
	public boolean updateVehicle(Vehicle vehicle) throws VehicleException {
		// call dao layer method and return to Client.
		return vehicleDao.updateVehicle(vehicle);
	}

	@Override
	@Transactional
	public boolean deleteVehicleById(Integer vehicleId) throws VehicleException {
		// call dao layer method and return to Client.
		return vehicleDao.deleteVehicleById(vehicleId);
	}

	@Override
	public Vehicle getVehicleById(Integer vehicleId) throws VehicleException {
		// call dao layer method and return to Client.
		return vehicleDao.getVehicleById(vehicleId);
	}
	
	@Override
	public Vehicle getVehicleBydetails(Integer custId, String vehicleType, String vehicleRegNumber,
			String vehicleChasisNumber, String vehicleEngineNumber) throws VehicleException {
		return vehicleDao.findVehicleBydetails(custId, vehicleType, vehicleRegNumber, vehicleChasisNumber, vehicleEngineNumber);
	}

}
