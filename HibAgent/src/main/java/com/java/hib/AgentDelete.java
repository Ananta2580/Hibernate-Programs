package com.java.hib;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AgentDelete {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Id");
		int agentId = sc.nextInt();
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where agentId = "+ agentId);
		
		Agent agent = (Agent) query.uniqueResult();
		if(agent != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(agent);
			transaction.commit();
			System.out.println("Agent deleted successfully");
		}else {
			System.out.println("Agent not deleted successfully");
		}
	}

}
