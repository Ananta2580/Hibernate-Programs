package com.java.cms.util;

import org.hibernate.Session;

import com.java.cms.model.Complaint;

public class UserIdGenerator {
	
	public static String getNextUserId(Session session) {
		String prefix = "C";
		String sql = "select max(complaintId) from Complaint";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}

}
