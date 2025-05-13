package com.java.lms.model;

import java.sql.Date;

public class Employ {
	private int empId;
	private String empName;
	private String empMail;
	private long empMobno;
	private Date empJoinDate;
	private String empDept;
	private int empMgrId;
	private int empLeaveBal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public long getEmpMobno() {
		return empMobno;
	}
	public void setEmpMobno(long empMobno) {
		this.empMobno = empMobno;
	}
	public Date getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(Date empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public int getEmpMgrId() {
		return empMgrId;
	}
	public void setEmpMgrId(int empMgrId) {
		this.empMgrId = empMgrId;
	}
	public int getEmpLeaveBal() {
		return empLeaveBal;
	}
	public void setEmpLeaveBal(int empLeaveBal) {
		this.empLeaveBal = empLeaveBal;
	}
	public Employ(int empId, String empName, String empMail, long empMobno, Date empJoinDate, String empDept,
			int empMgrId, int empLeaveBal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empMail = empMail;
		this.empMobno = empMobno;
		this.empJoinDate = empJoinDate;
		this.empDept = empDept;
		this.empMgrId = empMgrId;
		this.empLeaveBal = empLeaveBal;
	}
	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", empMail=" + empMail + ", empMobno=" + empMobno
				+ ", empJoinDate=" + empJoinDate + ", empDept=" + empDept + ", empMgrId=" + empMgrId + ", empLeaveBal="
				+ empLeaveBal + "]";
	}
	
	
}
