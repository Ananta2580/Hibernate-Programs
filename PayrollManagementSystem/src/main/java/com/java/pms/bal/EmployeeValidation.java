package com.java.pms.bal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.MyException.InvalidInputException;
import com.java.pms.dao.EmployeeServices;
import com.java.pms.dao.IEmployeeService;
import com.java.pms.model.Employee;

public class EmployeeValidation {
	
	static IEmployeeService employeeServices = null;
	public static Employee getEmployeeValid(int empId) throws DatabaseConnectionException, SQLException, InvalidInputException, EmployeeNotFoundException {
		if(empId <= 0) {
			throw new InvalidInputException("Invalid Input");
		}
		employeeServices = new EmployeeServices();
		return employeeServices.getEmployeeById(empId);
	}
	
	public static List<Employee> getAllEmployeeValid() throws DatabaseConnectionException, SQLException{
		employeeServices = new EmployeeServices();
		return employeeServices.getAllEmployees();
	}
	
	public static String addEmployeeValid(Employee emp) throws InvalidInputException, DatabaseConnectionException, SQLException {
		employeeServices = new EmployeeServices();
		if(!isValidEmployee(emp)) {
			return "Enter valid input";
		}
		
		return employeeServices.addEmployee(emp);
	}
	
	public String updateEmployeeValid(Employee emp) throws InvalidInputException, DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		employeeServices = new EmployeeServices();
		if(!isValidEmployee(emp)) {
			return "Enter valid input";
		}
		return employeeServices.updateEmployee(emp);
	}
	
	public String removeEmployeeValid(int empId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		employeeServices = new EmployeeServices();
		return employeeServices.removeEmployee(empId);
	}
	
	public static boolean isValidEmployee(Employee emp) throws InvalidInputException {

	    if (emp.getEmpId() <= 0) {
	        throw new InvalidInputException("Employee ID must be a positive integer.");
	    }

	    if (emp.getfName() == null || !emp.getfName().matches("[a-zA-Z]+")) {
	        throw new InvalidInputException("First name must contain only letters.");
	    }

	    if (emp.getfName() == null || !emp.getfName().matches("[a-zA-Z]+")) {
	        throw new InvalidInputException("Last name must contain only letters.");
	    }

	    if (emp.getDOB() == null) {
	        throw new InvalidInputException("Date of Birth cannot be null.");
	    } else {
	        LocalDate dob = emp.getDOB().toLocalDate();
	        if (dob.isAfter(LocalDate.now()) || emp.calculateAge() < 18) {
	            throw new InvalidInputException("Employee must be at least 18 years old.");
	        }
	    }

	    if (emp.getEmail() == null || !emp.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        throw new InvalidInputException("Invalid email format.");
	    }

	    if (String.valueOf(emp.getMobNo()).length() != 10) {
	        throw new InvalidInputException("Mobile number must be exactly 10 digits.");
	    }

	    if (emp.getAddress() == null || emp.getAddress().isEmpty()) {
	        throw new InvalidInputException("Address cannot be empty.");
	    }

	    if (emp.getPosition() == null || emp.getPosition().isEmpty()) {
	        throw new InvalidInputException("Position cannot be empty.");
	    }

	    if (emp.getJoinDate() == null || emp.getJoinDate().toLocalDate().isAfter(LocalDate.now())) {
	        throw new InvalidInputException("Joining date cannot be in the future.");
	    }

	    if (emp.getTerminationDate() != null &&
	        emp.getTerminationDate().toLocalDate().isBefore(emp.getJoinDate().toLocalDate())) {
	        throw new InvalidInputException("Termination date must be after joining date.");
	    }

	    return true;
	}


}
