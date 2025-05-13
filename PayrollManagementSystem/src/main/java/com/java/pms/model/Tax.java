package com.java.pms.model;


public class Tax {
	private int taxId;
	private int empId;
	private int taxYear;
	private double taxIncome;
	private double taxAmount;
	public int getTaxId() {
		return taxId;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	public double getTaxIncome() {
		return taxIncome;
	}
	public void setTaxIncome(double taxIncome) {
		this.taxIncome = taxIncome;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Tax(int taxId, int empId, int taxYear, double taxIncome, double taxAmount) {
		super();
		this.taxId = taxId;
		this.empId = empId;
		this.taxYear = taxYear;
		this.taxIncome = taxIncome;
		this.taxAmount = taxAmount;
	}
	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
