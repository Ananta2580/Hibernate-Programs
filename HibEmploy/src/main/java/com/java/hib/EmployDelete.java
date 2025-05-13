package com.java.hib;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployDelete {
	
	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ No");
		empno = sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Employ where empno = "+empno);
		Employ employ = (Employ)query.uniqueResult();
		if(employ != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(employ);
			transaction.commit();
			System.out.println("Employ Record deleted");
		}
		else {
			System.out.println("Not deleted");
		}
	}

}
