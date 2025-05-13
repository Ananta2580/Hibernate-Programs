package com.java.hib.dao;

import com.java.hib.model.Employee;

public interface EmployeeDao {
	
	String addEmployee(Employee employee);

	String generatePassword(String user, int otp);
	
	String validatePassword(String user, String password);
	
	String updatePassword(String user, String pwd);

}
