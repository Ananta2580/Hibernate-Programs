package com.java.pms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.model.Employee;

public interface IEmployeeService {
	Employee getEmployeeById(int empId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	List<Employee> getAllEmployees() throws DatabaseConnectionException, SQLException;
	String addEmployee(Employee employee) throws DatabaseConnectionException, SQLException;
	String updateEmployee(Employee employee) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	String removeEmployee(int empId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
}
