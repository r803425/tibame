package com.cha103g5.csimg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/g5?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "ZAQ!2wsx";

	public static void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}