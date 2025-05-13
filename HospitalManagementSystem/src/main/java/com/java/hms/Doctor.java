package com.java.hms;

public class Doctor {
	
	private int doctorId;
	private String doctorName;
	private String specialization;
	private long doctorPhone;
	
	
	

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public long getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(long doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public Doctor(int doctorId, String doctorName, String specialization, long doctorPhone) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.doctorPhone = doctorPhone;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ ", doctorPhone=" + doctorPhone + "]";
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
