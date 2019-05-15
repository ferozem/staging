package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Employee;
import com.jp.insurance.exception.EmployeeException;


//prep-work 1 -@Repository EmployeeDaoImpl
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee.getEmpId();
	}
	
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeException {
	
		return entityManager.merge(employee)!=null;
	}

	@Override
	public boolean deleteEmployeeById(Integer empId) throws EmployeeException {
		Employee employee = getEmployeeById(empId);
		if(employee == null)
		return false;
		else{
			entityManager.remove(employee);
			return true;
		}
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		
		return entityManager.find(Employee.class, empId);
	}
	
}
