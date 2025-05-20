package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.MedicationHistory;

public interface MedicationDao {
	List<MedicationHistory> showPatientMedicalHistory();
	String addMedicalHistory(MedicationHistory medHistory);
	List<MedicationHistory> showTests(String patientId);
}
