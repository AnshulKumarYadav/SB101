package com.daoPattern.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provideConnection()
	{
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem with loading the driver main class");
		}
		
		String dataBase = "jdbc:mysql://localhost:3306/db3" ;
		
		try {
			conn = DriverManager.getConnection(dataBase, "root", "root");
		} catch (SQLException e) {
			System.out.println("Connection not established");
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
}
