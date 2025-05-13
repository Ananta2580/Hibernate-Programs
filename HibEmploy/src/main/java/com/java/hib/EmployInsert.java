package com.java.hib;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployInsert {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employ employ = new Employ();
		
		System.out.println("Enter Employ Number  ");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Employ Name  ");
		employ.setName(sc.next());
		System.out.println("Enter Employ Gender  ");
		employ.setGender(sc.next());
		System.out.println("Enter Employ Department  ");
		employ.setDept(sc.next());
		System.out.println("Enter Employ Designation  ");
		employ.setDesig(sc.next());
		System.out.println("Enter Employ Basic  ");
		employ.setBasic(sc.nextDouble());
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employ);
		transaction.commit();
		System.out.println("Employ inserted successfully");
		
	}
	

}
