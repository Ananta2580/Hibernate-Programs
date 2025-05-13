package com.java.pms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.PayrollGenerationException;
import com.java.pms.model.Tax;

public interface ITaxService {
	String calculateTax(Tax tax) throws DatabaseConnectionException, SQLException, PayrollGenerationException;
	Tax getTaxById(int taxId) throws DatabaseConnectionException, SQLException;
	List<Tax> getTaxesForEmployee(int empId) throws DatabaseConnectionException, SQLException;
	List<Tax> getTaxesForYear(int taxYear) throws DatabaseConnectionException, SQLException;
}
