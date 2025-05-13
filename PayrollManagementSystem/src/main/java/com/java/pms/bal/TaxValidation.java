package com.java.pms.bal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.java.pms.MyException.DatabaseConnectionException;
import com.java.pms.MyException.PayrollGenerationException;
import com.java.pms.MyException.TaxCalculationException;
import com.java.pms.dao.ITaxService;
import com.java.pms.dao.TaxService;
import com.java.pms.model.Tax;

public class TaxValidation {
	
	public String calculateTaxValid(Tax tax) throws TaxCalculationException, DatabaseConnectionException, SQLException, PayrollGenerationException {
		ITaxService taxService = new TaxService();
		
		if(!isValidTax(tax)) {
			return "Enter valid details";
		}
		
		return taxService.calculateTax(tax);
		
	}
	
	public Tax getTaxByIdValid(int taxId) throws DatabaseConnectionException, SQLException {
		ITaxService taxService = new TaxService();
		return taxService.getTaxById(taxId);
	}
	
	public List<Tax> getTaxByempIdValid(int empId) throws DatabaseConnectionException, SQLException{
		ITaxService taxService = new TaxService();
		return taxService.getTaxesForEmployee(empId);
	}
	
	public List<Tax> getTaxByYearValid(int taxYear) throws DatabaseConnectionException, SQLException{
		ITaxService taxService = new TaxService();
		return taxService.getTaxesForYear(taxYear);
	}
	
	public static boolean isValidTax(Tax tax) throws TaxCalculationException {
	    
	    if (tax == null) {
	        throw new TaxCalculationException("Tax object cannot be null.");
	    }

	    int year = tax.getTaxYear();
	    int currentYear = LocalDate.now().getYear();
	    if (year < 2000 || year > currentYear) {
	        throw new TaxCalculationException("Invalid tax year: " + year);
	    }
	    return true;
	}


}
