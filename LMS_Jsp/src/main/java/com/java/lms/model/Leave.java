package com.java.lms.model;

import java.sql.Date;


public class Leave {
	private int leaveId;
	private int noOfDays;
	private String leaveMgrCmts;
	private int empId;
	private Date leaveStDt;
	private Date leaveEndDt;
	private String leaveType;
	private String leaveStatus;
	private String leaveReason;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getLeaveMgrCmts() {
		return leaveMgrCmts;
	}
	public void setLeaveMgrCmts(String leaveMgrCmts) {
		this.leaveMgrCmts = leaveMgrCmts;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getLeaveStDt() {
		return leaveStDt;
	}
	public void setLeaveStDt(Date leaveStDt) {
		this.leaveStDt = leaveStDt;
	}
	public Date getLeaveEndDt() {
		return leaveEndDt;
	}
	public void setLeaveEndDt(Date leaveEndDt) {
		this.leaveEndDt = leaveEndDt;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public Leave(int leaveId, int noOfDays, String leaveMgrCmts, int empId, Date leaveStDt, Date leaveEndDt,
			String leaveType, String leaveStatus, String leaveReason) {
		super();
		this.leaveId = leaveId;
		this.noOfDays = noOfDays;
		this.leaveMgrCmts = leaveMgrCmts;
		this.empId = empId;
		this.leaveStDt = leaveStDt;
		this.leaveEndDt = leaveEndDt;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.leaveReason = leaveReason;
	}
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", noOfDays=" + noOfDays + ", leaveMgrCmts=" + leaveMgrCmts + ", empId="
				+ empId + ", leaveStDt=" + leaveStDt + ", leaveEndDt=" + leaveEndDt + ", leaveType=" + leaveType
				+ ", leaveStatus=" + leaveStatus + ", leaveReason=" + leaveReason + "]";
	}
	
	
	
}
