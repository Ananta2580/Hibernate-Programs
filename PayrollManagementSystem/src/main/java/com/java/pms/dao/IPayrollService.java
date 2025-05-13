package com.java.pms.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
import com.java.pms.model.Payroll;

public interface IPayrollService {
	
	String generatePayroll(Payroll payroll) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException;
	Payroll getPayrollById(int payrollId) throws DatabaseConnectionException, SQLException;
	List<Payroll> getPayrollsForEmployee(int empId) throws DatabaseConnectionException, SQLException;
	List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws DatabaseConnectionException, SQLException;

}
