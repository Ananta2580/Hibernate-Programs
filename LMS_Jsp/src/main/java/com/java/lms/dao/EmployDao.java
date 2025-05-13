package com.java.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.model.Employ;

public interface EmployDao {
	List<Employ> showEmploydao() throws ClassNotFoundException, SQLException;
	Employ searchEmployDao(int empId) throws ClassNotFoundException, SQLException;
	String updateEmployDao(int empId, int newLeaveBal) throws ClassNotFoundException, SQLException;
	
}
