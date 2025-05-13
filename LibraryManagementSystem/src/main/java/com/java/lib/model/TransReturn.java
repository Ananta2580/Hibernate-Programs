package com.java.lib.model;

import java.sql.Date;

public class TransReturn {
	
	private String username;
	private int bookId;
	private Date fromDate;
	private Date toDate;
	private double fine;
	
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public TransReturn(String username, int bookId, Date fromDate, Date toDate, double fine) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fine = fine;
	}
	public TransReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
