package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.CustomerDao;
import com.jp.insurance.dao.EmployeeDao;

import com.jp.insurance.entities.Employee;
import com.jp.insurance.exception.EmployeeException;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public Integer addEmployee(Employee employee) throws EmployeeException {
        // call dao layer method and return to Client.
        return employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeList() throws EmployeeException {
        // call dao layer method and return to Client.
        System.out.println("From service");
        return employeeDao.getEmployeeList();
    }

    @Override
    @Transactional
    public boolean updateEmployee(Employee employee) throws EmployeeException {
        // call dao layer method and return to Client.
        return employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public boolean deleteEmployeeById(Integer empId) throws EmployeeException {
        // call dao layer method and return to Client.
        return employeeDao.deleteEmployeeById(empId);
    }

    @Override
    public Employee getEmployeeById(Integer empId) throws EmployeeException {
        // call dao layer method and return to Client.
        return employeeDao.getEmployeeById(empId);
    }

}
