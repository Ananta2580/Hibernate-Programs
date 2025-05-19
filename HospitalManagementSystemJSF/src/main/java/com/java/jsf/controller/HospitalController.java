package com.java.jsf.controller;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.java.jsf.dao.DoctorDao;
import com.java.jsf.model.Appointment;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.Patient;

public class HospitalController {
	
	private Patient patient;
	private Doctor doctor;
	private DoctorDao docDao;
	private Appointment appointment;
	

	public String deleteDoctorAction() {
	    Map<String, String> params = FacesContext.getCurrentInstance()
	        .getExternalContext().getRequestParameterMap();

	    String id = params.get("doctorId");

	    if (id != null) {
	        int docId = Integer.parseInt(id);
	        docDao.deleteDoctor(docId);
	    }

	    return "ViewDoctor?faces-redirect=true";  // reloads the page
	}
	
	

	public Appointment getAppointment() {
		return appointment;
	}



	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	public DoctorDao getDocDao() {
		return docDao;
	}
	public void setDocDao(DoctorDao docDao) {
		this.docDao = docDao;
	}
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
	
	public List<Doctor> viewDoctor(){
		return docDao.viewDoctors();
	}
	
	public String addDoctor(Doctor doctor1) {
		return docDao.addDoctor(doctor1);
	}
	
	
}
