package com.jp.insurance.service;

import com.jp.insurance.entities.Employee;
import com.jp.insurance.exception.EmployeeException;

import java.util.List;

public interface EmployeeService {
    //CRUDS Operation
    public Integer addEmployee(Employee employee)throws EmployeeException;//C-create
    public List<Employee> getEmployeeList()throws EmployeeException;//R All Employee -retrieve
    public boolean updateEmployee(Employee employee)throws EmployeeException;//U-update
    public boolean deleteEmployeeById(Integer empId)throws EmployeeException;//D-delete
    public Employee getEmployeeById(Integer empId)throws EmployeeException;//S-search
}
