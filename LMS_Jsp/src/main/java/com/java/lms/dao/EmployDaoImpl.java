package com.java.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.Employ;
import com.java.lms.util.ConnectionHelper;

public class EmployDaoImpl implements EmployDao{
	Connection connection;
	PreparedStatement ps;

	@Override
	public List<Employ> showEmploydao() throws ClassNotFoundException, SQLException {
		List<Employ> employeeList = new ArrayList<Employ>();
		Employ employ=null;
		
		connection = ConnectionHelper.getConnection();
		String query = "select * from employee";
		ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			employ = new Employ();
			employ.setEmpId(rs.getInt("Emp_Id"));
			employ.setEmpName(rs.getString("Emp_Name"));
			employ.setEmpMail(rs.getString("Emp_Mail"));
			employ.setEmpMobno(rs.getLong("Emp_Mob_No"));
			employ.setEmpJoinDate(rs.getDate("Emp_Dt_Join"));
			employ.setEmpDept(rs.getString("Emp_Dept"));
			employ.setEmpMgrId(rs.getInt("Emp_Manager_Id"));
			employ.setEmpLeaveBal(rs.getInt("Emp_Avail_Leave_Bal"));
			
			employeeList.add(employ);
		}
		
		return employeeList;
		
	}

	@Override
	public Employ searchEmployDao(int empId) throws ClassNotFoundException, SQLException {
		
		Employ employ = null;
		String query = "select * from employee where EMP_ID = ?";
		connection = ConnectionHelper.getConnection();
		ps = connection.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			employ = new Employ();
			employ.setEmpId(rs.getInt("Emp_Id"));
			employ.setEmpName(rs.getString("Emp_Name"));
			employ.setEmpMail(rs.getString("Emp_Mail"));
			employ.setEmpMobno(rs.getLong("Emp_Mob_No"));
			employ.setEmpJoinDate(rs.getDate("Emp_Dt_Join"));
			employ.setEmpDept(rs.getString("Emp_Dept"));
			employ.setEmpMgrId(rs.getInt("Emp_Manager_Id"));
			employ.setEmpLeaveBal(rs.getInt("Emp_Avail_Leave_Bal"));
		}
		
		return employ;
		
	}

	@Override
	public String updateEmployDao(int empId, int newLeaveBal) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		
		String query = "update employee set Emp_Avail_Leave_Bal = ? where emp_id = ?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, newLeaveBal);
		ps.setInt(2, empId);
		
		ps.executeUpdate();
		
		return "Leave Balance updated successfully";
	}

}
