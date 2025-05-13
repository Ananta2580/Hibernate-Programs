package com.java.jsf;

import javax.faces.event.ActionEvent;

public class NameBean {
	
	private String firstName;
	private String lastName;
	private String fullName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public NameBean(String firstName, String lastName, String fullName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
	}
	public NameBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NameBean [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + "]";
	}
	
	public void result(ActionEvent ae) {
		this.fullName = this.firstName + " " + this.lastName;
	}

}
