package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question6 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		 System.out.println("driver connect");
		}
		
		String database = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection connection = DriverManager.getConnection(database,"root","root")) {
			PreparedStatement ps = connection.prepareStatement("select * from employee where salary<80000");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("salary"));
				System.out.println("==========================");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
