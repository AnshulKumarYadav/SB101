package com.daoPattern.usecases;

import java.util.Scanner;

import com.daoPattern.bean.Employee;
import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class insertWithoutAddress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter eid: ");
		int eid = sc.nextInt();
		
		System.out.println("Enter name: ");
		String name = sc.next();
		
		System.out.println("Enter salary: ");
		int salary = sc.nextInt();
		
		
		EmployeeDao emp = new EmployeeDaoImp();
		
		Employee employee = new Employee();
		employee.setEid(eid);
		employee.setName(name);
		employee.setSalary(salary);
		String message =  emp.insertWithourAddress(employee.getEid(),employee.getName(),employee.getSalary());
		
		System.out.println(message);
	}
}
