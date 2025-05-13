package com.java.cms.dao;

import java.util.List;

import com.java.cms.model.Resolve;

public interface ResolveDao {
	
	List<Resolve> showResolve();
	String resolveComplaint(Resolve resolve);

}
