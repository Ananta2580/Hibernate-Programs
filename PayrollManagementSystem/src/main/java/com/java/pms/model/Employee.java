package com.java.pms.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Employee {
	
	private int empId;
	private String fName;
	private String lName;
	private Date DOB;
	private String gender;
	private String email;
	private long mobNo;
	private String address;
	private String position;
	private Date joinDate;
	private Date terminationDate;
	
	public int calculateAge() {
		if(DOB == null) {
			return 0;
		}
		LocalDate dob = DOB.toLocalDate();
		LocalDate current = LocalDate.now();
		return Period.between(dob, current).getYears();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public Employee(int empId, String fName, String lName, Date dOB, String gender, String email, long mobNo,
			String address, String position, Date joinDate, Date terminationDate) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		DOB = dOB;
		this.gender = gender;
		this.email = email;
		this.mobNo = mobNo;
		this.address = address;
		this.position = position;
		this.joinDate = joinDate;
		this.terminationDate = terminationDate;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
