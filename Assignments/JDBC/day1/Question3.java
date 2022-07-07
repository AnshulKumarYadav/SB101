package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Question3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		 System.out.println("driver connect");
		}
		
		String database = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection connection = DriverManager.getConnection(database,"root","root")) {
			PreparedStatement ps = connection.prepareStatement("update employee set salary = salary+500");
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				System.out.println(x+" row affected");
			}
			else {
				System.out.println("Nothing affected");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
