package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.VehicleException;


//prep-work 1 -@Repository VehicleDaoImpl
@Repository
public class VehicleDaoImpl implements VehicleDao {
	
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addVehicle(Vehicle vehicle) throws VehicleException {
		entityManager.persist(vehicle);
		return vehicle.getVehicleId();
	}

	@Override
	public List<Vehicle> getVehicleList() throws VehicleException {
		Query query = entityManager.createQuery("from Vehicle");
	return query.getResultList();
		//return query.getSingleResult();
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) throws VehicleException {
		return entityManager.merge(vehicle)!=null;
	}

	@Override
	public boolean deleteVehicleById(Integer vehicleId) throws VehicleException {
		Vehicle vehicle = getVehicleById(vehicleId);
		if(vehicle == null)
		return false;
		else{
			entityManager.remove(vehicle);
			return true;
		}
	}

	@Override
	public Vehicle getVehicleById(Integer vehicleId) throws VehicleException {
		return entityManager.find(Vehicle.class, vehicleId);
	}

	@Override
	public Vehicle findVehicleBydetails(Integer custId, String vehicleType, String vehicleRegNumber,
			Integer vehicleChasisNumber, Integer vehicleEngineNumber) throws VehicleException {
		Vehicle vehicle = null;
		Query query = entityManager.createQuery("from Vehicle where custId =:custId and vehicleType =:vehicleType and vehicleRegNumber =:vehicleRegNumber and vehicleChasisNumber = :vehicleChasisNumber and vehicleEngineNumber =:vehicleEngineNumber");
		query.setParameter("custId", custId);
		query.setParameter("vehicleType", vehicleType);
		query.setParameter("vehicleRegNumber", vehicleRegNumber);
		query.setParameter("vehicleChasisNumber", vehicleChasisNumber);
		query.setParameter("vehicleEngineNumber", vehicleEngineNumber);
		
		if(!query.getResultList().isEmpty())
		{
			vehicle = (Vehicle) query.getSingleResult();

		}
		return vehicle;
		
		
	}

}
