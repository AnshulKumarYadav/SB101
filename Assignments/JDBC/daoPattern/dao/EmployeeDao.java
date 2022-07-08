package com.daoPattern.dao;

import java.util.List;

import com.daoPattern.bean.Employee;

public interface EmployeeDao {
	
	public String insertDetails(Employee e);
	
	public int getSalaryByid(int eid);
	
	public Boolean provideBonus(int bonus);
	
	public String insertWithourAddress(int eid,String name,int salary);
	
	public Employee getEmployeeById(int eid);
	
	public  List<Employee> getEmployeeBySalary(int salary);
	
	public List<Employee> getAllEmployees();

}
