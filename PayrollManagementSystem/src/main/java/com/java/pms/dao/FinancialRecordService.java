package com.java.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.model.FinancialRecord;
import com.java.pms.util.DBConnUtil;

public class FinancialRecordService implements IFinancialRecordService{

	@Override
	public String addFinancialRecord(FinancialRecord fRecord) throws DatabaseConnectionException, SQLException {
		Connection conn = DBConnUtil.getConnection("db");
		String query = "INSERT INTO FinancialRecord (EmployeeID, RecordDate, Description, Amount, RecordType)\r\n"
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, fRecord.getEmpId());
		ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
		ps.setString(3, fRecord.getDesc());
		ps.setDouble(4, fRecord.getAmount());
		ps.setString(5, fRecord.getRecordType());
		
		ps.executeUpdate();
		return "Financial record inserted successfully";
	
	}

	@Override
	public FinancialRecord getFinancialRecordById(int recordId) throws DatabaseConnectionException, SQLException {
		
		FinancialRecord fRecord = new FinancialRecord();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from FinancialRecord where RecordID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, recordId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			fRecord.setRecordId(rs.getInt("RecordID"));
	        fRecord.setEmpId(rs.getInt("EmployeeID"));
	        fRecord.setDesc(rs.getString("Description"));
	        fRecord.setAmount(rs.getDouble("Amount"));
	        fRecord.setRecordType(rs.getString("RecordType"));
	        fRecord.setRecordDate(rs.getDate("RecordDate"));
		}
		return fRecord;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int empId) throws DatabaseConnectionException, SQLException {
		FinancialRecord fRecord = null;
		List<FinancialRecord> recordList = new ArrayList<FinancialRecord>();
		
		Connection conn = DBConnUtil.getConnection("db");
		String query = "select * from FinancialRecord where EmployeeID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, empId);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			fRecord = new FinancialRecord();
			fRecord.setRecordId(rs.getInt("RecordID"));
	        fRecord.setEmpId(rs.getInt("EmployeeID"));
	        fRecord.setDesc(rs.getString("Description"));
	        fRecord.setAmount(rs.getDouble("Amount"));
	        fRecord.setRecordType(rs.getString("RecordType"));
	        fRecord.setRecordDate(rs.getDate("RecordDate"));
	        
	        recordList.add(fRecord);
		}
		return recordList;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForDate(Date date) throws DatabaseConnectionException, SQLException {
		List<FinancialRecord> recordList = new ArrayList<>();
		FinancialRecord fRecord = null;
	    
	    Connection conn = DBConnUtil.getConnection("db");
	    String query = "SELECT * FROM FinancialRecord WHERE RecordDate = ?";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setDate(1, date);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()) {
	    	fRecord = new FinancialRecord();
	    	fRecord.setRecordId(rs.getInt("RecordID"));
	        fRecord.setEmpId(rs.getInt("EmployeeID"));
	        fRecord.setDesc(rs.getString("Description"));
	        fRecord.setAmount(rs.getDouble("Amount"));
	        fRecord.setRecordType(rs.getString("RecordType"));
	        fRecord.setRecordDate(rs.getDate("RecordDate"));
	        
	        recordList.add(fRecord);
	    }
	    return recordList;
	}

}
