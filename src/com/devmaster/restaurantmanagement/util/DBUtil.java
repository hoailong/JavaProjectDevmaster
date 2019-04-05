package com.devmaster.restaurantmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
//	static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public static Connection getSqlConn(){
		Connection conn = null;
		String strConnection = "jdbc:sqlserver://HH-201807241030;databaseName=RestaurantProj;user=sa;password=123456;";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Class.forName(resourceBundle.getString("driverName"));
			conn = DriverManager.getConnection(strConnection);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Lỗi: " + e.toString());
		}
		return conn;
	}
}
