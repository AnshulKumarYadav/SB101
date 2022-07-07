package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		 System.out.println("driver connect");
		}
		
		String database = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection connection = DriverManager.getConnection(database,"root","root")) {
			PreparedStatement ps = connection.prepareStatement("select * from employee where eid=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("salary"));
			}
			else {
				System.out.println("Employee does not exist");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
