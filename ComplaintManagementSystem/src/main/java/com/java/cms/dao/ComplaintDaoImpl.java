package com.java.cms.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.java.cms.model.Complaint;
import com.java.cms.util.UserIdGenerator;

public class ComplaintDaoImpl implements ComplaintDao{
	
	SessionFactory sf;
	Session session;
	
	public Date convertToSqlDate(String str) throws ParseException {
		System.out.println("String is " +str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(str);
		Date sqlDate = new Date(date.getTime());
		System.out.println("Date is " +sqlDate);
		return sqlDate;
	}
	

	@Override
	public String addComplaint(Complaint complaint) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		String nextUserId = UserIdGenerator.getNextUserId(session);
		complaint.setComplaintId(nextUserId);
		complaint.setStatus("Pending");
		
		Transaction tx = session.beginTransaction();
		session.save(complaint);
		tx.commit();
		
		return "Complaint Registered Successfully";
	}

	@Override
	public Complaint searchComplaint(String complaintId) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Complaint.class);
		cr.add(Restrictions.eq("complaintId", complaintId));
		Complaint complaint = (Complaint) cr.uniqueResult();
		return complaint;
		
	}

	@Override
	public List<Complaint> showComplaint() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Complaint.class);
		return cr.list();
	}

}
