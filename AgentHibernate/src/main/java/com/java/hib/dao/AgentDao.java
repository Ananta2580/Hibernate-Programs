package com.java.hib.dao;

import java.util.List;

import com.java.hib.Agent;

public interface AgentDao {
	
	List<Agent> showAgent();
	Agent searchAgent(int agentId);
	String addAgent(Agent agent);
	String updateAgent(Agent agent);
	String deleteAgent(int agentId);

}
