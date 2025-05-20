package com.java.jsf.model;

public class Doctor {
	
	private String doctorId;
	private String doctorName;
	private Specialization specialization;
	private String location;
	private String mobileNo;
	private Status isStatus;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Status getIsStatus() {
		return isStatus;
	}
	public void setIsStatus(Status isStatus) {
		this.isStatus = isStatus;
	}

}
