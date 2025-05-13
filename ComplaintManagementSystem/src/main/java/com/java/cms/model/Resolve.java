package com.java.cms.model;

import java.sql.Date;

public class Resolve {
	
	private int resolveId;
	private String complaintId;
	private Date complaintDate;
	private Date resolveDate;
	private String resolvedBy;
	private String comments;
	public int getResolveId() {
		return resolveId;
	}
	public void setResolveId(int resolveId) {
		this.resolveId = resolveId;
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public Date getResolveDate() {
		return resolveDate;
	}
	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Resolve(int resolveId, String complaintId, Date complaintDate, Date resolveDate, String resolvedBy,
			String comments) {
		super();
		this.resolveId = resolveId;
		this.complaintId = complaintId;
		this.complaintDate = complaintDate;
		this.resolveDate = resolveDate;
		this.resolvedBy = resolvedBy;
		this.comments = comments;
	}
	public Resolve() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Resolve [resolveId=" + resolveId + ", complaintId=" + complaintId + ", complaintDate=" + complaintDate
				+ ", resolveDate=" + resolveDate + ", resolvedBy=" + resolvedBy + ", comments=" + comments + "]";
	}
	
	public long getTat() {
	    long diffInMillis = this.resolveDate.getTime() - this.complaintDate.getTime();
	    return (diffInMillis / (1000 * 60 * 60 * 24)) + 1;
	}
	
	

}
