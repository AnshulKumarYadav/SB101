package com.utility.usecases;

import java.util.List;
import java.util.Scanner;

import com.utility.bean.Employee;
import com.utility.dao.EmployeeDao;
import com.utility.dao.EmployeeDaoImpl;
import com.utility.exception.EmployeeException;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.err.println("Enter 1 choice for Save Details");
		System.err.println("Enter 2 choice for get employee Details by id");
		System.err.println("Enter 3 choice for Get all employee Details");
		System.err.println("Enter 4 choice for delete employee Details by id");
		
		int choice = scanner.nextInt();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		if(choice==1)
		{
			System.out.println("Enter employee id");
			int empId  = scanner.nextInt();
			System.out.println("Enter name: ");
			String name = scanner.next();
			System.out.println("Enter address");
			String address = scanner.next();
			System.out.println("Enter salary");
			int salary = scanner.nextInt();
			String string = employeeDao.saveEmployeeDetails(new Employee(empId, name, address, salary));
			System.out.println(string);
		}
		else if(choice==2)
		{
			System.out.println("Enter id");
			int empId  = scanner.nextInt();
			
			
			try {
				Employee employee = (employeeDao.getEmployeeById(empId));
				System.out.println(employee.getEid());
				System.out.println(employee.getName());
				System.out.println(employee.getAddress());
				System.out.println(employee.getSalary());
				System.out.println("===============================");
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
			
		}
		else if(choice==3)
		{
			List<Employee>  arr = employeeDao.getAllEmployees();
			for(Employee i: arr)
			{
				System.out.println(i.getEid());
				System.out.println(i.getName());
				System.out.println(i.getAddress());
				System.out.println(i.getSalary());
				System.out.println("=============================");
			}
		}
		else if(choice==4)
		{
			System.out.println("Enter id");
			int empId  = scanner.nextInt();
			
			try {
				String message= employeeDao.deleteEmployee(empId);
				System.out.println(message);
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
