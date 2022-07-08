package com.daoPattern.usecases;

import java.util.List;
import java.util.Scanner;

import com.daoPattern.bean.Employee;
import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class getEmployeesBySalary {
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println("Enter salary: ");
		int salary = scanner.nextInt();
	
		
		EmployeeDao employeeDao = new EmployeeDaoImp();
		List<Employee> employees = employeeDao.getEmployeeBySalary(salary);
		
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
