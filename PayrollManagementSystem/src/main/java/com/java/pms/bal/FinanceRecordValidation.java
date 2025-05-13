package com.java.pms.bal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.FinancialRecordException;
import com.java.pms.dao.FinancialRecordService;
import com.java.pms.dao.IFinancialRecordService;
import com.java.pms.model.FinancialRecord;

public class FinanceRecordValidation {
	
	public String addFinanceValid(FinancialRecord record) throws FinancialRecordException, DatabaseConnectionException, SQLException {
		
		IFinancialRecordService financialRecordService = new FinancialRecordService();
		
		if(!isValidFinanceRecord(record)) {
			return "Enter valid details";
		}
		return financialRecordService.addFinancialRecord(record);
	}
	
	public FinancialRecord getFinanceRecordValid(int recordId) throws DatabaseConnectionException, SQLException {
		IFinancialRecordService financialRecordService = new FinancialRecordService();
		
		return financialRecordService.getFinancialRecordById(recordId);
	}
	
	public List<FinancialRecord> getFinanceRecordByEmpValid(int empId) throws DatabaseConnectionException, SQLException{
		IFinancialRecordService financialRecordService = new FinancialRecordService();
		
		return financialRecordService.getFinancialRecordsForEmployee(empId);
	}
	
	public List<FinancialRecord> getFinanceRecordByDateValid(Date date) throws DatabaseConnectionException, SQLException{
		IFinancialRecordService financialRecordService = new FinancialRecordService();
		
		return financialRecordService.getFinancialRecordsForDate(date);
	}
	
	public static boolean isValidFinanceRecord(FinancialRecord record) throws FinancialRecordException {
		if (record.getDesc() == null || record.getDesc().trim().isEmpty()) {
	        throw new FinancialRecordException("Description cannot be empty.");
	    }


	    if (record.getRecordType() == null || record.getRecordType().trim().isEmpty()) {
	        throw new FinancialRecordException("Type must be provided (e.g., income, expense, tax payment).");
	    }
	    
	    return true;
	}
}
