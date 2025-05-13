package com.java.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.model.Employee;
import com.java.pms.util.DBConnUtil;

public class EmployeeServices implements IEmployeeService{

	@Override
	public Employee getEmployeeById(int empId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		Employee employee = null;
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from employee where EmployeeID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			employee = new Employee();
			employee.setEmpId(rs.getInt("EmployeeID"));
			employee.setfName(rs.getString("FirstName"));
            employee.setlName(rs.getString("LastName"));
            employee.setDOB(rs.getDate("DateOfBirth"));
            employee.setGender(rs.getString("Gender"));
            employee.setEmail(rs.getString("Email"));
            employee.setMobNo(rs.getLong("PhoneNumber"));
            employee.setAddress(rs.getString("Address"));
            employee.setPosition(rs.getString("Position"));
            employee.setJoinDate(rs.getDate("JoiningDate"));
            employee.setTerminationDate(rs.getDate("TerminationDate"));

		}
		else {
			throw new EmployeeNotFoundException("Employee not found");
		}
		
		return employee;
		
	}

	@Override
	public List<Employee> getAllEmployees() throws DatabaseConnectionException, SQLException {
		Employee employee = null;
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from employee";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			employee = new Employee();
			employee.setEmpId(rs.getInt("EmployeeID"));
			employee.setfName(rs.getString("FirstName"));
            employee.setlName(rs.getString("LastName"));
            employee.setDOB(rs.getDate("DateOfBirth"));
            employee.setGender(rs.getString("Gender"));
            employee.setEmail(rs.getString("Email"));
            employee.setMobNo(rs.getLong("PhoneNumber"));
            employee.setAddress(rs.getString("Address"));
            employee.setPosition(rs.getString("Position"));
            employee.setJoinDate(rs.getDate("JoiningDate"));
            employee.setTerminationDate(rs.getDate("TerminationDate"));
            
            empList.add(employee);
		}
		return empList;
	}

	@Override
	public String addEmployee(Employee employee) throws DatabaseConnectionException, SQLException {
		Connection conn = DBConnUtil.getConnection("db");
		String query = "INSERT INTO Employee (EmployeeID, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, employee.getEmpId());
	    ps.setString(2, employee.getfName());
	    ps.setString(3, employee.getlName());
	    ps.setDate(4, new java.sql.Date(employee.getDOB().getTime()));
	    ps.setString(5, employee.getGender());
	    ps.setString(6, employee.getEmail());
	    ps.setLong(7, employee.getMobNo());
	    ps.setString(8, employee.getAddress());
	    ps.setString(9, employee.getPosition());
	    ps.setDate(10, new java.sql.Date(employee.getJoinDate().getTime()));
	    
	    if (employee.getTerminationDate() != null) {
	        ps.setDate(11, new java.sql.Date(employee.getTerminationDate().getTime()));
	    } else {
	        ps.setNull(11, java.sql.Types.DATE);
	    }
	    
	    ps.executeUpdate();
	    
	    return "Employee inserted successfully to the table";
	}

	@Override
	public String updateEmployee(Employee employee) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		Connection conn = DBConnUtil.getConnection("db");
		Employee emp = getEmployeeById(employee.getEmpId());
		
		String query = "UPDATE Employee SET FirstName=?, LastName=?, DateOfBirth=?, Gender=?, Email=?, "
                + "PhoneNumber=?, Address=?, Position=?, JoiningDate=?, TerminationDate=? WHERE EmployeeID=?";
		
		PreparedStatement ps = conn.prepareStatement(query); 
		
		if(emp != null) {
			ps.setString(1, employee.getfName());
		    ps.setString(2, employee.getlName());
		    ps.setDate(3, new java.sql.Date(employee.getDOB().getTime()));
		    ps.setString(4, employee.getGender());
		    ps.setString(5, employee.getEmail());
		    ps.setLong(6, employee.getMobNo());
		    ps.setString(7, employee.getAddress());
		    ps.setString(8, employee.getPosition());
		    ps.setDate(9, new java.sql.Date(employee.getJoinDate().getTime()));
		    
		    if (employee.getTerminationDate() != null) {
		        ps.setDate(10, new java.sql.Date(employee.getTerminationDate().getTime()));
		    } else {
		        ps.setNull(10, java.sql.Types.DATE);
		    }
		    ps.setInt(11, employee.getEmpId());
		    
		    ps.executeUpdate();
		}
		
		return "Employee details updated Successfully";
	}

	@Override
	public String removeEmployee(int empId) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		Connection conn = DBConnUtil.getConnection("db");
		Employee emp = getEmployeeById(empId);
		String query = "delete from employee where EmployeeID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		ps.executeUpdate();
		
		return "Employee deleted Successfully";
	}

}
