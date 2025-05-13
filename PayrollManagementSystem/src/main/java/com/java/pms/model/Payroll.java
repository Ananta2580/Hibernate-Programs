package com.java.pms.model;

import java.sql.Date;

public class Payroll {
	private int payrollId;
	private int empId;
	private Date payPeriodStartDate;
	private Date payPeriodEndDate;
	private double basicSal;
	private double overTimePay;
	private double deductions;
	private double netSal;
	public int getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	public double getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}
	public double getOverTimePay() {
		return overTimePay;
	}
	public void setOverTimePay(double overTimePay) {
		this.overTimePay = overTimePay;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getNetSal() {
		return netSal;
	}
	public void setNetSal(double netSal) {
		this.netSal = netSal;
	}
	public Payroll(int payrollId, int empId, Date payPeriodStartDate, Date payPeriodEndDate, double basicSal,
			double overTimePay, double deductions, double netSal) {
		super();
		this.payrollId = payrollId;
		this.empId = empId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSal = basicSal;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.netSal = netSal;
	}
	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
