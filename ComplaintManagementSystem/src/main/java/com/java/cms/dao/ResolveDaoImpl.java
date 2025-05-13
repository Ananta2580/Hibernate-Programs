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

import com.java.cms.model.Complaint;
import com.java.cms.model.Resolve;

public class ResolveDaoImpl implements ResolveDao{
	
	SessionFactory sf ;
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
	public List<Resolve> showResolve() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Resolve.class);
		return cr.list();
	}

	@Override
	public String resolveComplaint(Resolve resolve) {
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(resolve);
		
		ComplaintDao comp = new ComplaintDaoImpl();
		Complaint complaint = comp.searchComplaint(resolve.getComplaintId());
		complaint.setStatus("Resolved");
		session.update(complaint);
		
		tx.commit();
		return "Your Complaint is processed";
	}

}
