package com.java.cms.dao;

import java.util.List;

import com.java.cms.model.Complaint;

public interface ComplaintDao {
	
	String addComplaint(Complaint complaint);
	Complaint searchComplaint(String complaintId);
	List<Complaint> showComplaint();

}
