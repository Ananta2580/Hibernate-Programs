package com.java.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.model.Employee;
import com.java.pms.model.Payroll;
import com.java.pms.util.DBConnUtil;

public class PayrollService implements IPayrollService{
	
	public static double getBasicSalaryByPosition(String position) {
	    switch (position.toLowerCase()) {
	        case "intern":
	            return 10000.0;
	        case "junior developer":
	            return 25000.0;
	        case "developer":
	            return 40000.0;
	        case "senior developer":
	            return 60000.0;
	        case "team lead":
	            return 80000.0;
	        case "manager":
	            return 100000.0;
	        default:
	            return 15000.0;
	    }
	}


	@Override
	public String generatePayroll(Payroll payroll) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException {
		IEmployeeService empService = new EmployeeServices();
		Employee employee = empService.getEmployeeById(payroll.getEmpId());
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary)\r\n"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		double basicSal = getBasicSalaryByPosition(employee.getPosition());
		double deduction = basicSal * 0.10;
		double netSal = basicSal + payroll.getOverTimePay() - deduction;
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, payroll.getEmpId());
		ps.setDate(2, payroll.getPayPeriodStartDate());
		ps.setDate(3, payroll.getPayPeriodEndDate());
		ps.setDouble(4, basicSal);
		ps.setDouble(5, payroll.getOverTimePay());
		ps.setDouble(6, deduction);
		ps.setDouble(7, netSal);
		
		ps.executeUpdate();
		
		return "Payroll Inserted successfully";
	}


	@Override
	public Payroll getPayrollById(int payrollId) throws DatabaseConnectionException, SQLException {
		
		Payroll payroll = null;
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Payroll where PayrollID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, payrollId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			payroll = new Payroll();
			payroll.setPayrollId(rs.getInt("PayrollID"));
	        payroll.setEmpId(rs.getInt("EmployeeID"));
	        payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	        payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	        payroll.setBasicSal(rs.getDouble("BasicSalary"));
	        payroll.setOverTimePay(rs.getDouble("OvertimePay"));
	        payroll.setDeductions(rs.getDouble("Deductions"));
	        payroll.setNetSal(rs.getDouble("NetSalary"));
	        
		}
		
		return payroll;
		
	}


	@Override
	public List<Payroll> getPayrollsForEmployee(int empId) throws DatabaseConnectionException, SQLException {
		Payroll payroll = null;
		List<Payroll> payList = new ArrayList<Payroll>();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Payroll where EmployeeID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			payroll = new Payroll();
			payroll.setPayrollId(rs.getInt("PayrollID"));
	        payroll.setEmpId(rs.getInt("EmployeeID"));
	        payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	        payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	        payroll.setBasicSal(rs.getDouble("BasicSalary"));
	        payroll.setOverTimePay(rs.getDouble("OvertimePay"));
	        payroll.setDeductions(rs.getDouble("Deductions"));
	        payroll.setNetSal(rs.getDouble("NetSalary"));
	        
	        payList.add(payroll);
		}
		return payList;
	}


	@Override
	public List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws DatabaseConnectionException, SQLException {
		Payroll payroll = null;
		List<Payroll> payList = new ArrayList<Payroll>();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Payroll where"
				+ " PayPeriodStartDate >= ? and PayPeriodEndDate <= ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setDate(1, startDate);
		ps.setDate(2, endDate);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			payroll = new Payroll();
			payroll.setPayrollId(rs.getInt("PayrollID"));
	        payroll.setEmpId(rs.getInt("EmployeeID"));
	        payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	        payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	        payroll.setBasicSal(rs.getDouble("BasicSalary"));
	        payroll.setOverTimePay(rs.getDouble("OvertimePay"));
	        payroll.setDeductions(rs.getDouble("Deductions"));
	        payroll.setNetSal(rs.getDouble("NetSalary"));
	        
	        payList.add(payroll);
		}
		return payList;
	}
	
	
	public static List<Payroll> getPayrollsForYear(int empId, int year) throws DatabaseConnectionException, SQLException {
		List<Payroll> payList = new ArrayList<>();
		Connection conn = DBConnUtil.getConnection("db");
		String query = "SELECT * FROM Payroll WHERE EmployeeID = ? AND YEAR(PayPeriodStartDate) = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		ps.setInt(2, year);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
		    Payroll payroll = new Payroll();
		    payroll.setPayrollId(rs.getInt("PayrollID"));
		    payroll.setEmpId(rs.getInt("EmployeeID"));
		    payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
		    payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
		    payroll.setBasicSal(rs.getDouble("BasicSalary"));
		    payroll.setOverTimePay(rs.getDouble("OvertimePay"));
		    payroll.setDeductions(rs.getDouble("Deductions"));
		    payroll.setNetSal(rs.getDouble("NetSalary"));
		    payList.add(payroll);
		}
		
		return payList;

		}

}
