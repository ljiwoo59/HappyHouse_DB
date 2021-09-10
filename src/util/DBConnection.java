package com.customer.util;

import java.sql.*;

public class DBConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DB_ID = "ssafy";
	private static final String DB_PASS = "ssafy";
	
	static {
		try {
			Class.forName(DRIVER);
//			System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �꽦怨�!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			System.out.println("�뱶�씪�씠踰� 濡쒕뵫 �떎�뙣!!!");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, DB_ID, DB_PASS);
	}
}
