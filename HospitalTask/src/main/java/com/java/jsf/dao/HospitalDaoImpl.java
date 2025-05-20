package com.java.jsf.dao;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;
import com.java.jsf.model.Specialization;
import com.java.jsf.model.Status;
import com.java.jsf.util.SessionHelper;
import com.java.jsf.util.UserIdGenerator;

public class HospitalDaoImpl implements PatientDao,DoctorDao,MedicationDao{
	
	Session session;
	
	private String localcode;
	
	

	public String getLocalcode() {
		return localcode;
	}

	public void setLocalcode(String localcode) {
		this.localcode = localcode;
	}
	
	public void categoryLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localcode = e.getNewValue().toString();
		System.out.println(this.localcode);
	}
	
	public List<Doctor> getCategories(){
		session = SessionHelper.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		Projection projection = Projections.distinct(Projections.property("specialization")); 
		cr.setProjection(projection);
		List<Doctor> list = cr.list();
		return list;
	}

	@Override
	public List<Doctor> showDoctor() {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowDoctors");
		List<Doctor> doctorList = query.list();
		return doctorList;
	}

	@Override
	public String addDoctor(Doctor doctor) {
		session = SessionHelper.getSessionFactory().openSession();
		String docId = UserIdGenerator.getNextDoctorId(session);
		doctor.setDoctorId(docId);
		doctor.setIsStatus(Status.valueOf("ACTIVE"));
		
		Transaction tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		
		return "DoctorDashBoard?faces-redirect=true";
	}

	@Override
	public List<Doctor> showByCategory(Specialization specialization) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowDoctorsByCategory");
		query.setParameter("specialization", specialization);
		List<Doctor> docList = query.list();
		return docList;
	}

	@Override
	public Doctor SearchByDoctorID(String docId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowDoctorById");
		query.setParameter("doctorId", docId);
		Doctor doctor = (Doctor) query.uniqueResult();
		return doctor;
	}

	@Override
	public Patient showPatientById(String patientId) {
		
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowPatientById");
		query.setParameter("patientId", patientId);
		Patient patient = (Patient) query.uniqueResult();
		return patient;
		
	}

	@Override
	public List<Patient> showPatientByDoctorId(String doctorId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowPatientByDoctorId");
		query.setParameter("doctorId", doctorId);
		List<Patient> patientList = query.list();
		return patientList;
	}

	@Override
	public String addPatient(Patient patient) {
		session = SessionHelper.getSessionFactory().openSession();
		String patientId = UserIdGenerator.getNextPatientId(session);
		patient.setPatientId(patientId);
		
		Transaction tx = session.beginTransaction();
		session.save(patient);
		tx.commit();
		
		return "PatientDashboard?faces-redirect=true";
	}

	@Override
	public List<MedicationHistory> showPatientMedicalHistory() {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowMedicationHistory");
		List<MedicationHistory> medicalhistory = query.list();
		return medicalhistory;
	}

	@Override
	public String addMedicalHistory(MedicationHistory medHistory) {
		session = SessionHelper.getSessionFactory().openSession();
		String medId = UserIdGenerator.getNextMedId(session);
		medHistory.setMedId(medId);
		
		Transaction tx = session.beginTransaction();
		session.save(medHistory);
		tx.commit();
		
		return "MedicationHistory?faces-redirect=true";
	}

	@Override
	public List<MedicationHistory> showTests(String patientId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ShowTests");
		query.setParameter("patientId", patientId);
		List<MedicationHistory> testList = query.list();
		return testList;
	}
	
}
