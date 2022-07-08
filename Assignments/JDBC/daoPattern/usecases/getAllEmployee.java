package com.daoPattern.usecases;

import java.util.List;

import com.daoPattern.bean.Employee;
import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class getAllEmployee {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImp();
		List<Employee> employees = employeeDao.getAllEmployees();
		
		for(Employee e: employees)
		{
			System.out.println(e.getEid());
			System.out.println(e.getName());
			System.out.println(e.getAddress());
			System.out.println(e.getSalary());
			System.out.println("==================");
		}
	}
}
