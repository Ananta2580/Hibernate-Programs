package com.java.hib.dao;

import java.util.List;

import com.java.hib.Agent;
import com.java.hib.Login;

public interface AgentDao {
	
	List<Agent> showAgent();
	Agent searchAgent(int agentId);
	String addAgent(Agent agent);
	String updateAgent(Agent agent);
	String deleteAgent(int agentId);
	String createUser(Login login);
	long login(String user, String pwd);
	Login authenticate(String user, String pwd);
}
