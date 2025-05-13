package com.java.jsf;

import java.util.ArrayList;
import java.util.List;

public class EmployDao {
	
	public List<Employ> showEmploy(){
		List<Employ> empList = new ArrayList<Employ>();
		empList.add(new Employ(1, "Ananta", "Java", "Developer", 473344));
		empList.add(new Employ(2, "Anshu", "Python", "Analyst", 485832));
		empList.add(new Employ(3, "Abhisekh", "C++", "Lead", 432523));
		empList.add(new Employ(4, "Sulekha", "C", "Doctor", 2345523));
		empList.add(new Employ(5, "Satya", "BhaiLang", "Engineer", 52343.8));
		
		return empList;
	}

}
