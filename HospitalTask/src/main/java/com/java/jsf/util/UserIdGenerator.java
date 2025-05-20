package com.java.jsf.util;

import org.hibernate.Session;

public class UserIdGenerator {
	
	public static String getNextPatientId(Session session) {
		String prefix = "PTH";
		String sql = "select max(patientId) from Patient";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}
	
	public static String getNextDoctorId(Session session) {
		String prefix = "HSKDS";
		String sql = "select max(doctorId) from Doctor";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}
	
	public static String getNextMedId(Session session) {
		String prefix = "MHD";
		String sql = "select max(medId) from MedicationHistory";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "0001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}

}

