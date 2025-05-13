package com.java.hib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.hib.Agent;
import com.java.hib.Login;
import com.java.hib.util.EncryptPassword;

public class AgentDaoImpl implements AgentDao{

	@Override
	public List<Agent> showAgent() {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		return cr.list();
	}

	@Override
	public Agent searchAgent(int agentId) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		cr.add(Restrictions.eq("agentId", agentId));
		Agent agent = (Agent) cr.uniqueResult();
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
		
		Agent agent = (Agent)query.uniqueResult();
		if(agent != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(agent);
			transaction.commit();
			return "Agent deleted Successfully";
		}
		else {
			return "Agent not deleted Successfully";
		}
		
	}

	@Override
	public String createUser(Login login) {
		String encr = EncryptPassword.getCode(login.getPassCode());
		login.setPassCode(encr);
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(login);
		transaction.commit();
		
		return "Created Successfully";
	}
	
	@Override
	public Login authenticate(String user, String pwd) {
		String encr = EncryptPassword.getCode(pwd);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", user));
		cr.add(Restrictions.eq("passCode", encr));
		Login login = (Login)cr.uniqueResult();
		System.out.println("Login is " +login);
		return login;
	}

	@Override
	public long login(String user, String pwd) {
		String encr = EncryptPassword.getCode(pwd);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", user));
		cr.add(Restrictions.eq("passCode", encr));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		return count;
	}


}
