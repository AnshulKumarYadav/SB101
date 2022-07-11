package com.utility.dao;

import java.util.List;

import com.utility.bean.Employee;
import com.utility.exception.EmployeeException;

public interface EmployeeDao {
	
	public String saveEmployeeDetails(Employee employee);
	
	public Employee getEmployeeById(int empId) throws EmployeeException;
	
	public List<Employee> getAllEmployees();
	
	public String deleteEmployee(int empId)throws EmployeeException;
	
}
