package com.java.pms.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.model.FinancialRecord;

public interface IFinancialRecordService {
	
	String addFinancialRecord(FinancialRecord fRecord) throws DatabaseConnectionException, SQLException;
	FinancialRecord getFinancialRecordById(int recordId) throws DatabaseConnectionException, SQLException;
	List<FinancialRecord> getFinancialRecordsForEmployee(int empId) throws DatabaseConnectionException, SQLException;
	List<FinancialRecord> getFinancialRecordsForDate(Date date) throws DatabaseConnectionException, SQLException;
}
