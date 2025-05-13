package com.java.hms.dao;

import java.util.List;

import com.java.hms.Patient;

public interface PatientDao {
	
	String addPatient(Patient patient);
	List<Patient> showAllPatient();
	Patient getPatientById(int patientId);

}
