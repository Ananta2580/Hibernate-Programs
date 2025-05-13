package com.java.hms.dao;

import java.util.List;

import com.java.hms.Doctor;

public interface DoctorDao {
	
	String addDoctor(Doctor doctor);
	List<Doctor> showDoctors();
	List<Doctor> getDoctorbySpecialization(String specialization);

}
