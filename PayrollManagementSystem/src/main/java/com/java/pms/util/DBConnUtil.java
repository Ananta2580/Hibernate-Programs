package com.java.pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.java.pms.MyException.DatabaseConnectionException;

public class DBConnUtil {
	
	public static Connection getConnection(String fileName) throws DatabaseConnectionException {
		
		Connection conn = null;
		
		String driver = DBPropertyUtil.getConnDriver(fileName);
		String user = DBPropertyUtil.getConnUser(fileName);
		String pass = DBPropertyUtil.getConnPassword(fileName);
		String url = DBPropertyUtil.getConnUrl(fileName);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
