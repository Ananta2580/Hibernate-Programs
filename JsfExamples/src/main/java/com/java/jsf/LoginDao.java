package com.java.jsf;

public class LoginDao {
	
	public String validateMe(String user, String pwd) {
		if(user.equals("Ananta") && pwd.equals("Swain")) {
			return "Menu.jsp?faces-redirect=true";
		}
		else {
			return "Login.jsp?faces-redirect=true";
		}
	}

}
