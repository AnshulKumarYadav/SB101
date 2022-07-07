package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = sc.nextInt();
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		 System.out.println("driver connect");
		}
		
		String database = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection connection = DriverManager.getConnection(database,"root","root")) {
			PreparedStatement ps = connection.prepareStatement("insert into employee(eid,name,salary)values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, salary);
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				System.out.println(x+" row affected");
			}
			else {
				System.out.println("Non of the row affected");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
