package com.java.pms.bal;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.EmployeeNotFoundException;
//import com.java.pms.MyException.InvalidInputException;
import com.java.pms.MyException.PayrollGenerationException;
import com.java.pms.dao.IPayrollService;
import com.java.pms.dao.PayrollService;
import com.java.pms.model.Payroll;

public class PayrollValidation {
	
	public static String generatePayrollValid(Payroll payroll) throws DatabaseConnectionException, SQLException, EmployeeNotFoundException, PayrollGenerationException {
		IPayrollService payrollService = new PayrollService();
		
		if(!isValidPayrollPeriod(payroll.getPayPeriodStartDate(),payroll.getPayPeriodEndDate())) {
			return "Give Correct details";
		}
		return payrollService.generatePayroll(payroll);
	}
	
	public static Payroll getPayrollIdValid(int payId) throws DatabaseConnectionException, SQLException {
		IPayrollService payrollService = new PayrollService();
		
		return payrollService.getPayrollById(payId);
	}
	
	public static List<Payroll> getPayrollByEmpValid(int empId) throws DatabaseConnectionException, SQLException{
		IPayrollService payrollService = new PayrollService();
		return payrollService.getPayrollsForEmployee(empId);
	}
	
	public static List<Payroll> getPayrollByDateValid(Date start, Date end) throws DatabaseConnectionException, SQLException, PayrollGenerationException{
		IPayrollService payrollService = new PayrollService();
		
		if(!isValidPayrollPeriod(start, end)) {
			System.out.println("Enter the correct date");
		}
		
		return payrollService.getPayrollsForPeriod(start, end);
	}
	
	
	public static boolean isValidPayrollPeriod(Date startDate, Date endDate) throws PayrollGenerationException {
	    if (startDate == null || endDate == null) {
	        throw new PayrollGenerationException("Start date and end date cannot be null.");
	    }

	    LocalDate start = startDate.toLocalDate();
	    LocalDate end = endDate.toLocalDate();
	    LocalDate today = LocalDate.now();

	    if (start.isAfter(end)) {
	        throw new PayrollGenerationException("Start date cannot be after end date.");
	    }

	    if (start.isAfter(today) || end.isAfter(today)) {
	        throw new PayrollGenerationException("Start or end date cannot be in the future.");
	    }

	    return true;
	}

	
}
