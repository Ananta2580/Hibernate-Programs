package com.java.pms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.PayrollGenerationException;
import com.java.pms.model.Payroll;
import com.java.pms.model.Tax;
import com.java.pms.util.DBConnUtil;


public class TaxService implements ITaxService{

	@Override
	public String calculateTax(Tax tax) throws DatabaseConnectionException, SQLException, PayrollGenerationException {
		
		List<Payroll> payList = PayrollService.getPayrollsForYear(tax.getEmpId(), tax.getTaxYear());
		
		if(payList.isEmpty() || payList == null) {
			throw new PayrollGenerationException("Payroll not generated for this employee");
		}
		
		double netSal = payList.get(0).getNetSal();
	    double annualIncome = netSal * 12;
	    
		double taxAmount = calculateTaxFromSlab(annualIncome);
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "INSERT INTO Tax (EmployeeID, TaxYear, TaxableIncome, TaxAmount)\r\n"
				+ "VALUES (?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, tax.getEmpId());
		ps.setInt(2, tax.getTaxYear());
		ps.setDouble(3, annualIncome);
		ps.setDouble(4, taxAmount);
		
		ps.executeUpdate();
		
		
		return "Tax calculated and inserted into db successfully";
		
	}
	
	public double calculateTaxFromSlab(double income) {
	    if (income <= 250000) {
	        return 0;
	    } 
	    else if (income <= 500000) {
	        return (income - 250000) * 0.05;
	    } 
	    else if (income <= 1000000) {
	        return (250000 * 0.05) + ((income - 500000) * 0.2);
	    } 
	    else {
	        return (250000 * 0.05) + (500000 * 0.2) + ((income - 1000000) * 0.3);
	    }
	}

	@Override
	public Tax getTaxById(int taxId) throws DatabaseConnectionException, SQLException {
		
		Tax tax = null;
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Tax where TaxID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, taxId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			tax = new Tax();
			tax.setTaxId(rs.getInt("TaxID"));
			tax.setEmpId(rs.getInt("EmployeeID"));
	        tax.setTaxYear(rs.getInt("TaxYear"));
	        tax.setTaxIncome(rs.getDouble("TaxableIncome"));
	        tax.setTaxAmount(rs.getDouble("TaxAmount"));
		}
		return tax;
	}

	@Override
	public List<Tax> getTaxesForEmployee(int empId) throws DatabaseConnectionException, SQLException {
		Tax tax = null;
		List<Tax> taxList = new ArrayList<Tax>();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Tax where EmployeeID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			tax = new Tax();
			tax.setTaxId(rs.getInt("TaxID"));
			tax.setEmpId(rs.getInt("EmployeeID"));
	        tax.setTaxYear(rs.getInt("TaxYear"));
	        tax.setTaxIncome(rs.getDouble("TaxableIncome"));
	        tax.setTaxAmount(rs.getDouble("TaxAmount"));
	        
	        taxList.add(tax);
		}
		return taxList;
	}

	@Override
	public List<Tax> getTaxesForYear(int taxYear) throws DatabaseConnectionException, SQLException {
		Tax tax = null;
		List<Tax> taxList = new ArrayList<Tax>();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from Tax where TaxYear = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, taxYear);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			tax = new Tax();
			tax.setTaxId(rs.getInt("TaxID"));
			tax.setEmpId(rs.getInt("EmployeeID"));
	        tax.setTaxYear(rs.getInt("TaxYear"));
	        tax.setTaxIncome(rs.getDouble("TaxableIncome"));
	        tax.setTaxAmount(rs.getDouble("TaxAmount"));
	        
	        taxList.add(tax);
		}
		return taxList;
	}

	
}
