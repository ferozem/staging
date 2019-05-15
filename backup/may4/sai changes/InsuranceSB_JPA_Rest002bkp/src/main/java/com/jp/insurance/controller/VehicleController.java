package com.jp.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.entities.Vehicle;
import com.jp.insurance.exception.VehicleException;
import com.jp.insurance.service.VehicleService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/vehicles")
public class VehicleController {
	// @Autowired VehicleService
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value="",produces="application/json")
	public List<Vehicle> getVehicleList() throws VehicleException {
		// call dao layer method and return to Client.
		System.out.println("Vehicle list");
		return vehicleService.getVehicleList();
	}

	//http://localhost:8082/api/vehicles/1
	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value="vehicleId") Integer vehicleId) throws VehicleException{
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		return ResponseEntity.ok().body(vehicle);
	}
	
	//http://localhost:8082/api/vehicles/bydetails/{custId}
		@GetMapping("/bydetails/{custId}")
		public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value="custId") Integer custId,@RequestBody Vehicle vehicle) throws VehicleException{
			Vehicle vehicle1 = vehicleService.getVehicleBydetails(custId, vehicle.getVehicleType(),vehicle.getVehicleRegNumber(),vehicle.getVehicleChasisNumber(),vehicle.getVehicleEngineNumber());
			System.out.println("vehicle by details: "+vehicle1);
			return ResponseEntity.ok().body(vehicle1);
		}
	
	//http://localhost:8082/api/vehicles/save
	@PostMapping("/save")
	public HttpStatus saveVehicle(@RequestBody Vehicle vehicle) throws VehicleException{
		return vehicleService.addVehicle(vehicle)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/vehicles/1
	@PutMapping("/{vehicleId}")
	public HttpStatus updateVehicle(@PathVariable(value="vehicleId") Integer vehicleId,@Valid @RequestBody Vehicle vehicleDetails) throws VehicleException{
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		if(vehicle==null)
			return HttpStatus.BAD_REQUEST;
		else{
			vehicle.setCustId(vehicleDetails.getCustId());
			vehicle.setVehicleRegNumber(vehicleDetails.getVehicleRegNumber());
			vehicle.setVehicleType(vehicleDetails.getVehicleType());
			vehicle.setVehicleChasisNumber(vehicleDetails.getVehicleChasisNumber());
			vehicle.setVehicleEngineNumber(vehicleDetails.getVehicleEngineNumber());
			vehicle.setVehicleManufacturer(vehicleDetails.getVehicleManufacturer());
			vehicle.setVehicleModelNumber(vehicleDetails.getVehicleModelNumber());
			vehicle.setVehicleMfgMMYYYY(vehicleDetails.getVehicleMfgMMYYYY());
			return vehicleService.updateVehicle(vehicle)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{vehicleId}")
	public Map<String, Boolean> deleteVehicleById(@PathVariable(value="vehicleId")Integer vehicleId) throws VehicleException{
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		Map<String, Boolean> response = new HashMap<>();
		if(vehicle!=null){
			vehicleService.deleteVehicleById(vehicleId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
