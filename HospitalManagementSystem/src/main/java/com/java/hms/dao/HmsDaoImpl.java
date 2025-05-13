package com.java.hms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.java.hms.Appointment;
import com.java.hms.Doctor;
import com.java.hms.Patient;

public class HmsDaoImpl implements PatientDao,DoctorDao,AppointmentDao{
	
	SessionFactory sf;
	Session session;

	@Override
	public String addDoctor(Doctor doctor) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(doctor);
		transaction.commit();
		
		return "Doctor inserted Successfully";
	}

	@Override
	public List<Doctor> showDoctors() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		return cr.list();
	}

	@Override
	public List<Doctor> getDoctorbySpecialization(String specialization) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		cr.add(Restrictions.eq("specialization", specialization));
		return cr.list();
	}

	@Override
	public String addPatient(Patient patient) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(patient);
		transaction.commit();
		return "Patient added successfully";
	}

	@Override
	public List<Patient> showAllPatient() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient.class);
		return cr.list();
	}

	@Override
	public Patient getPatientById(int patientId) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("patientId", patientId));
		Patient patient = (Patient) cr.uniqueResult();
		
		return patient;
	}

	@Override
	public String bookAppointment(Appointment appointment) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(appointment);
		tr.commit();
		return "Appointment Booked Successfully";
	}

	@Override
	public List<Appointment> viewAppointmentBydocId(int docId) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Appointment.class);
		cr.add(Restrictions.eq("doctorId", docId));
		return cr.list();
	}

	
	

}
