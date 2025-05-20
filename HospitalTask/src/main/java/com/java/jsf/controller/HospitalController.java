package com.java.jsf.controller;

import java.util.List;

import com.java.jsf.dao.HospitalDaoImpl;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;
import com.java.jsf.model.Specialization;

public class HospitalController {
	
	private Patient patient;
	private Doctor doctor;
	private MedicationHistory medHistory;
	private HospitalDaoImpl hospitalDao;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public MedicationHistory getMedHistory() {
		return medHistory;
	}
	public void setMedHistory(MedicationHistory medHistory) {
		this.medHistory = medHistory;
	}
	public HospitalDaoImpl getHospitalDao() {
		return hospitalDao;
	}
	public void setHospitalDao(HospitalDaoImpl hospitalDao) {
		this.hospitalDao = hospitalDao;
	}
	
	public List<Doctor> showDoctor(){
		return hospitalDao.showDoctor();
	}
	
	public String addDoctor(Doctor doctor) {
		return hospitalDao.addDoctor(doctor);
	}
	
	public List<Doctor> showDoctorByCategory(Specialization specialization){
		return hospitalDao.showByCategory(specialization);
	}
	
	public Doctor searchByDoctorId(String docId){
		return hospitalDao.SearchByDoctorID(docId);
	}
	
	public String addPatient(Patient patient) {
		return hospitalDao.addPatient(patient);
	}
	public Patient searchById(String patientId) {
		return hospitalDao.showPatientById(patientId);
	}
	public List<Patient> searchByDocId(String docId){
		return hospitalDao.showPatientByDoctorId(docId);
	}
	
	public List<MedicationHistory> showMedicalHistory(){
		return hospitalDao.showPatientMedicalHistory();
	}
	
	public String addMedicationHistory(MedicationHistory medHistory) {
		return hospitalDao.addMedicalHistory(medHistory);
	}
	public List<MedicationHistory> showTests(String patientId){
		return hospitalDao.showTests(patientId);
	}

}
