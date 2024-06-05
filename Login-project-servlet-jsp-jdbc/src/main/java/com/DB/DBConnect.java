package com.DB;

import java.sql.*;

public class DBConnect {

	private static Connection conn;

	public static Connection getConnection() {

		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage", "root", "root");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
}
