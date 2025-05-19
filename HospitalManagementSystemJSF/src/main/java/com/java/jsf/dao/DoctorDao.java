package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Doctor;

public interface DoctorDao {
	
	List<Doctor> viewDoctors();
	String addDoctor(Doctor doctor);
	String deleteDoctor(int docId);
	
}
