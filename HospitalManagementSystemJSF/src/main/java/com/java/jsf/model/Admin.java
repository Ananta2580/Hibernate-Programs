package com.java.jsf.model;

public class Admin {
	
	private String email;
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String adminLogin() {
		if(this.email.equals("admin@gmail.com") && this.password.equals("admin")) {
			return "AdminDashboard?faces-redirect=true";
		}
		else {
			return null;
		}
	}
	
	

}
