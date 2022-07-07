package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;


//Develop a JDBC application to get the salary of a particular employee, whose Id is given by the user.


//mysql> create database db1;
//Query OK, 1 row affected (0.03 sec)
//
//mysql> use db1;
//Database changed

//mysql> create table employee
//-> (
//-> eid int primary key,
//-> name varchar(15),
//-> address varchar(15),
//-> salary int
//-> );
//Query OK, 0 rows affected (0.10 sec)
//
//mysql>


public class InsertData {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = scanner.nextInt();
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter address:");
		String address = scanner.next();
		System.out.println("Enter Salary:");
		int salary = scanner.nextInt();
		
		
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Problem with loading the driver main class");
			}
			String cString = "jdbc:mysql://localhost:3306/db1";
			try(Connection connection = DriverManager.getConnection(cString,"root","root");) {
				Statement statement =  connection.createStatement();
				int x = statement.executeUpdate("insert into employee values("+id+",'"+name+"' ,'"+address+"',"+salary+")");
				
				if(x>0) {
					System.out.println(x+" rows inseted");
				}
				else {
					System.out.println("not inserted");
				}
				
			} catch (SQLException e) {
				System.out.println("Problem in establisation of connection ");
			}
		
	}

}
