package com.java.pms.model;

import java.sql.Date;

public class FinancialRecord {
	private int recordId;
	private int empId;
	private Date recordDate;
	private String desc;
	private double amount;
	private String recordType;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public FinancialRecord(int recordId, int empId, Date recordDate, String desc, double amount, String recordType) {
		super();
		this.recordId = recordId;
		this.empId = empId;
		this.recordDate = recordDate;
		this.desc = desc;
		this.amount = amount;
		this.recordType = recordType;
	}
	public FinancialRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
