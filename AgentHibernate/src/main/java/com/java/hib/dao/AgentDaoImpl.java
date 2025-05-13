package com.java.hib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.hib.Agent;

public class AgentDaoImpl implements AgentDao{

	@Override
	public List<Agent> showAgent() {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent");
		List<Agent> agentList = query.list();
		return agentList;
	}

	@Override
	public Agent searchAgent(int agentId) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where agentId="+agentId);
		Agent agent = (Agent)query.uniqueResult();
		return agent;
	}

	@Override
	public String addAgent(Agent agent) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(agent);
		transaction.commit();
		return "Agent inserted successfully";
	}

	@Override
	public String updateAgent(Agent agent) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(agent);
		transaction.commit();
		return "Agent Updated successfully";
	}

	@Override
	public String deleteAgent(int agentId) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where agentId="+agentId);
		
		Agent agent = searchAgent(agentId);
		Transaction transaction = session.beginTransaction();
		session.delete(agent);
		transaction.commit();
		
		return "Agent deleted Successfully";
		
	}
	

}
