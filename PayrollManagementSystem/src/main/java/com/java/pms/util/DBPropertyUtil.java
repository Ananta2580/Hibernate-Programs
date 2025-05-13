package com.java.pms.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {
	
	
	public static String getConnUrl(String fileName) {
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		return rb.getString("url");
	}
	public static String getConnDriver(String fileName) {
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		return rb.getString("driver");
	}
	public static String getConnUser(String fileName) {
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		return rb.getString("user");
	}
	public static String getConnPassword(String fileName) {
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		return rb.getString("password");
	}

}
