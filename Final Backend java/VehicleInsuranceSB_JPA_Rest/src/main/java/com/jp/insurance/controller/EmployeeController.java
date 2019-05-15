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

import com.jp.insurance.entities.Employee;
import com.jp.insurance.exception.EmployeeException;
import com.jp.insurance.service.EmployeeService;



//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/employees")
public class EmployeeController {
	// @Autowired IEmployeeService
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="",produces="application/json")
	public List<Employee> getEmployeeList() throws EmployeeException {
		// call dao layer method and return to Client.
		System.out.println("EMployee list");
		return employeeService.getEmployeeList();
	}

	//http://localhost:8082/api/employees/1
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="employeeId") Integer empId) throws EmployeeException{
		Employee employee = employeeService.getEmployeeById(empId);
		return ResponseEntity.ok().body(employee);
	}
	
	//http://localhost:8082/api/employees/save
	@PostMapping("/save")
	public HttpStatus saveEmployee(@RequestBody Employee employee) throws EmployeeException{
		
		return employeeService.addEmployee(employee)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/employees/1
	@PutMapping("/{employeeId}")
	public HttpStatus updateEmployee(@PathVariable(value="employeeId") Integer employeeId,@Valid @RequestBody Employee employeeDetails) throws EmployeeException{
		Employee employee = employeeService.getEmployeeById(employeeId);
		if(employee==null)
			return HttpStatus.BAD_REQUEST;
		else{
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			return employeeService.updateEmployee(employee)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{employeeId}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable(value="employeeId")Integer employeeId) throws EmployeeException{
		Employee employee = employeeService.getEmployeeById(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		if(employee!=null){
			employeeService.deleteEmployeeById(employeeId);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
