package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.jsf.model.Doctor;
import com.java.jsf.util.SessionHelper;

public class HospitalDaoImpl implements DoctorDao{
	
	Session session;

	@Override
	public List<Doctor> viewDoctors() {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("ViewDoctors");
		List<Doctor> docList = query.list();
		
		return docList;
	}

	@Override
	public String addDoctor(Doctor doctor) {
		session = SessionHelper.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		session.close();
		return "AdminDashboard?faces-redirect=true";
	}
	
	public Doctor searchDoc(int docId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("SearchDoctor");
		query.setParameter("doctorId", docId);
		Doctor doctor = (Doctor) query.uniqueResult();
//		session.close();
		return doctor;
	}
	
	public void deleteAppointmentsByDoctorId(Session session, int doctorId) {
	    Session s = SessionHelper.getSessionFactory().openSession();
	    Transaction tx = s.beginTransaction();
	    Query query = s.createQuery("delete from Appointment where doctorId = :doctorId");
	    query.setParameter("doctorId", doctorId);
	    query.executeUpdate();
	    tx.commit();
	    s.close();
	}


	@Override
	public String deleteDoctor(int docId) {
		session = SessionHelper.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Doctor doctor = searchDoc(docId);
		if(doctor != null) {
			deleteAppointmentsByDoctorId(session, docId);
			Query query = session.getNamedQuery("DeleteDoctor");
			query.setParameter("doctorId", doctor.getDoctorId());
			query.executeUpdate();
			tx.commit();
			return "AdminDashboard?faces-redirect=true";
		}else {
			return null;
		}
	}
}
