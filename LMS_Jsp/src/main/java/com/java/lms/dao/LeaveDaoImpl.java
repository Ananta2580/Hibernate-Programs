package com.java.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.Employ;
import com.java.lms.model.Leave;
import com.java.lms.util.ConnectionHelper;

public class LeaveDaoImpl implements LeaveDao{
	
	Connection connection;
	PreparedStatement ps;
	
	public Date convertToSqlDate(String str) throws ParseException {
		System.out.println("String is " +str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(str);
		Date sqlDate = new Date(date.getTime());
		System.out.println("Date is " +sqlDate);
		return sqlDate;
	}

	@Override
	public String applyLeave(Leave leave) throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();

	    LocalDate today = LocalDate.now();
	    LocalDate startDate = leave.getLeaveStDt().toLocalDate();
	    LocalDate endDate = leave.getLeaveEndDt().toLocalDate();

	    // 1. Validate leave dates
	    if (startDate.isBefore(today) || endDate.isBefore(today)) {
	        return "Leave start or end date cannot be in the past.";
	    }
	    if (startDate.isAfter(endDate)) {
	        return "Leave start date cannot be after end date.";
	    }

	    // 2. Check for overlapping leave dates
	    if (isLeaveOverlapping(leave)) {
	        return "You have already applied for leave during this period.";
	    }

	    // 3. Calculate number of days excluding weekends and holidays
	    long diff = leave.getLeaveEndDt().getTime() - leave.getLeaveStDt().getTime();
	    int totalLeaveDays = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

	    // Calculate the number of weekends and special holidays
	    int weekends = countWeekends(startDate, endDate);
	    int specialHolidays = countSpecialHolidays(startDate, endDate);

	    // Subtract weekends and special holidays from the total days
	    int actualLeaveDays = totalLeaveDays - weekends - specialHolidays;

	    // 4. Check if employee has enough leave balance
	    EmployDao employDao = new EmployDaoImpl();
	    Employ employ = employDao.searchEmployDao(leave.getEmpId());

	    if (employ.getEmpLeaveBal() < actualLeaveDays) {
	        return "Insufficient Leave Balance.";
	    }

	    // 5. Insert leave details into the database
	    String query = "INSERT INTO leave_history (LEAVE_NO_OF_DAYS, LEAVE_MNGR_COMMENTS, EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE, LEAVE_STATUS, LEAVE_REASON) "
	                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    ps = connection.prepareStatement(query);
	    ps.setInt(1, actualLeaveDays);
	    ps.setString(2, "");  // Manager comments (can be updated later)
	    ps.setInt(3, leave.getEmpId());
	    ps.setDate(4, leave.getLeaveStDt());
	    ps.setDate(5, leave.getLeaveEndDt());
	    ps.setString(6, leave.getLeaveType());
	    ps.setString(7, "PENDING");
	    ps.setString(8, leave.getLeaveReason());

	    int leaveRow = ps.executeUpdate();

	    // 6. Update leave balance if leave is applied successfully
	    if (leaveRow > 0) {
	        employ.setEmpLeaveBal(employ.getEmpLeaveBal() - actualLeaveDays);
	        employDao.updateEmployDao(employ.getEmpId(), employ.getEmpLeaveBal());
	        return "Leave applied successfully. Please wait for manager approval.";
	    } else {
	        return "Failed to apply for leave.";
	    }
	}

	// Check for overlapping leave dates
	private boolean isLeaveOverlapping(Leave leave) throws SQLException {
	    String checkQuery = "SELECT * FROM leave_history WHERE EMP_ID = ? "
	                        + "AND ((LEAVE_START_DATE BETWEEN ? AND ?) OR (LEAVE_END_DATE BETWEEN ? AND ?))";
	    ps = connection.prepareStatement(checkQuery);
	    ps.setInt(1, leave.getEmpId());
	    ps.setDate(2, leave.getLeaveStDt());
	    ps.setDate(3, leave.getLeaveEndDt());
	    ps.setDate(4, leave.getLeaveStDt());
	    ps.setDate(5, leave.getLeaveEndDt());
	    ResultSet rs = ps.executeQuery();
	    return rs.next();  // If there is any record, it means the leave dates overlap
	}

	// Count weekends (Saturdays and Sundays) within the range
	private int countWeekends(LocalDate startDate, LocalDate endDate) {
	    int weekends = 0;
	    LocalDate date = startDate;

	    while (!date.isAfter(endDate)) {
	        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            weekends++;
	        }
	        date = date.plusDays(1);
	    }
	    return weekends;
	}

	// Count special holidays (example list of holidays, replace with actual holidays)
	private int countSpecialHolidays(LocalDate startDate, LocalDate endDate) {
	    int specialHolidays = 0;

	    // List of special holidays (example)
	    List<LocalDate> holidays = new ArrayList<>();
	    holidays.add(LocalDate.of(2025, 1, 1)); // New Year's Day
	    holidays.add(LocalDate.of(2025, 12, 25)); // Christmas

	    LocalDate date = startDate;
	    while (!date.isAfter(endDate)) {
	        if (holidays.contains(date)) {
	            specialHolidays++;
	        }
	        date = date.plusDays(1);
	    }
	    return specialHolidays;
	}
	@Override
	public List<Leave> showLeaveHistory(int empId) throws ClassNotFoundException, SQLException {
		
		Leave leave = null;
		List<Leave> leaveList = new ArrayList<Leave>();
		connection = ConnectionHelper.getConnection();
		
		String query = "select * from leave_history where emp_Id = ?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			leave = new Leave();
			leave.setLeaveId(rs.getInt("leave_id"));
	        leave.setEmpId(rs.getInt("emp_id"));
	        leave.setLeaveStDt(rs.getDate("leave_start_date"));
	        leave.setLeaveEndDt(rs.getDate("leave_end_date"));
	        leave.setLeaveType(rs.getString("leave_type"));
	        leave.setLeaveReason(rs.getString("leave_reason"));
	        leave.setLeaveStatus(rs.getString("leave_status"));
	        leave.setLeaveMgrCmts(rs.getString("leave_mngr_comments"));
	        leave.setNoOfDays(rs.getInt("leave_no_of_days"));
	        
	        leaveList.add(leave);
		}
		
		return leaveList;
		
	}

	@Override
	public List<Leave> pendingLeaveList(int mgrId) throws ClassNotFoundException, SQLException {
		Leave leave = null;
		List<Leave> pendingList = new ArrayList<Leave>();
		connection = ConnectionHelper.getConnection();
		
		String query = "select * from leave_history where emp_id in\r\n"
				+ "(\r\n"
				+ "select Emp_Id from employee where emp_manager_id= ? \r\n"
				+ ") and leave_status = 'PENDING'";
		
		ps = connection.prepareStatement(query);
		ps.setInt(1, mgrId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			leave = new Leave();
			leave = new Leave();
			leave.setLeaveId(rs.getInt("leave_id"));
	        leave.setEmpId(rs.getInt("emp_id"));
	        leave.setLeaveStDt(rs.getDate("leave_start_date"));
	        leave.setLeaveEndDt(rs.getDate("leave_end_date"));
	        leave.setLeaveType(rs.getString("leave_type"));
	        leave.setLeaveReason(rs.getString("leave_reason"));
	        leave.setLeaveStatus(rs.getString("leave_status"));
	        leave.setLeaveMgrCmts(rs.getString("leave_mngr_comments"));
	        leave.setNoOfDays(rs.getInt("leave_no_of_days"));
	        
	        pendingList.add(leave);
		}
		
		return pendingList;
		
	}

	@Override
	public String manageLeaveDao(int leaveId, int mgrId, boolean isAccepted, String mgrComment) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
        String query = "SELECT * FROM leave_history WHERE leave_id = ?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, leaveId);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            return "Leave request not found.";
        }

        int empId = rs.getInt("emp_id");
        int noOfDays = rs.getInt("leave_no_of_days");
        String leaveStatus = isAccepted ? "APPROVED" : "DENIED";

        if (!isAccepted) {
            EmployDao employDao = new EmployDaoImpl();
            Employ employee = employDao.searchEmployDao(empId);
            employee.setEmpLeaveBal(employee.getEmpLeaveBal() + noOfDays);
            employDao.updateEmployDao(empId, employee.getEmpLeaveBal());
        }

        String updateQuery = "UPDATE leave_history SET LEAVE_STATUS = ?, LEAVE_MNGR_COMMENTS = ? WHERE leave_id = ?";
        ps = connection.prepareStatement(updateQuery);
        ps.setString(1, leaveStatus);
        ps.setString(2, mgrComment);
        ps.setInt(3, leaveId);

        int updatedRows = ps.executeUpdate();

        if (updatedRows > 0) {
            return "Leave request " + (isAccepted ? "approved" : "denied") + " successfully.";
        } else {
            return "Failed to update leave request.";
        }
	}
	
}
