package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Specialization;

public interface DoctorDao {
	List<Doctor> showDoctor();
	String addDoctor(Doctor doctor);
	List<Doctor> showByCategory(Specialization specialization);
	Doctor SearchByDoctorID(String docId);
}
