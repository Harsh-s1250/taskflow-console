package com.taskflow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/taskflow";
	private static final String  USERNAME = "root";
	private static final String PASSWORD = "Harshad@1250";
	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		}catch(SQLException e) {
			System.out.println("Database Connection failed: "+e.getMessage());
		}
		return null;
	}
}
