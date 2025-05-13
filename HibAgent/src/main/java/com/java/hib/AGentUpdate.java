package com.java.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AGentUpdate {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		
		System.out.println("Enter AgentId");
		agent.setAgentId(sc.nextInt());
		
		System.out.println("Enter Name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender");
		agent.setGender(sc.next());
		System.out.println("Enter Marital Status(0/1)");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter Premium");
		agent.setPremium(sc.nextDouble());
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(agent);
		transaction.commit();
		System.out.println("Agent Updated Successfully");
	}

}
