package com.java.hms;

public class Patient {
	
	private int patientId;
	private String patientName;
	private int age;
	private String gender;
	private String patientAddress;
	private String disease;
	private long patientPhone;
	
	
	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPatientAddress() {
		return patientAddress;
	}


	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public long getPatientPhone() {
		return patientPhone;
	}


	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}

	

	public Patient(int patientId, String patientName, int age, String gender, String patientAddress, String disease,
			long patientPhone) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
		this.patientAddress = patientAddress;
		this.disease = disease;
		this.patientPhone = patientPhone;
	}

	

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", gender="
				+ gender + ", patientAddress=" + patientAddress + ", disease=" + disease + ", patientPhone="
				+ patientPhone + "]";
	}


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
