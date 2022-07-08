package com.daoPattern.usecases;

import java.util.Scanner;

import com.daoPattern.bean.Employee;
import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class getEmployeeById {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id");
		int eid = scanner.nextInt();
		
		EmployeeDao employeeDao = new EmployeeDaoImp();
		Employee e = employeeDao.getEmployeeById(eid);
		
		System.out.println(e.getEid());
		System.out.println(e.getName());
		System.out.println(e.getAddress());
		System.out.println(e.getSalary());
		System.out.println("==================================");
		
	}
	
}
