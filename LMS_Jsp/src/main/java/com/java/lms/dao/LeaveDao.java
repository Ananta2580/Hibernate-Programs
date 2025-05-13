package com.java.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.model.Leave;

public interface LeaveDao {
	String applyLeave(Leave leave) throws ClassNotFoundException, SQLException;
	List<Leave> showLeaveHistory(int empId) throws ClassNotFoundException, SQLException;
	List<Leave> pendingLeaveList(int mgrId) throws ClassNotFoundException, SQLException;
	String manageLeaveDao(int leaveId, int mgrId, boolean isAccepted, String mgrComment) throws ClassNotFoundException, SQLException;
}
