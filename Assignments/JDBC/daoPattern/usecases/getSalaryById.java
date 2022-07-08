package com.daoPattern.usecases;

import java.util.Scanner;

import com.daoPattern.bean.Employee;
import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class getSalaryById {
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter eid: ");
		int eid = sc.nextInt();
		
		EmployeeDao employeeDao = new EmployeeDaoImp();
		
		int x =  employeeDao.getSalaryByid(eid);
		
		System.out.println(x);
		
	}
}
