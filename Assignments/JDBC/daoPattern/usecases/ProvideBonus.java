package com.daoPattern.usecases;

import java.util.Scanner;

import com.daoPattern.dao.EmployeeDao;
import com.daoPattern.dao.EmployeeDaoImp;

public class ProvideBonus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter bonus to give employee");
		int bonus = sc.nextInt();
		
		EmployeeDao employeeDao = new EmployeeDaoImp();
		boolean  a =  employeeDao.provideBonus(bonus);
		System.out.println(a);
		
	}
}
