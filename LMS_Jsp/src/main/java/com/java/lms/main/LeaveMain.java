package com.java.lms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.lms.dao.EmployDao;
import com.java.lms.dao.EmployDaoImpl;
import com.java.lms.dao.LeaveDao;
import com.java.lms.dao.LeaveDaoImpl;
import com.java.lms.model.Employ;
import com.java.lms.model.Leave;

public class LeaveMain {
	
	public static void showEmployMain() {
		EmployDao dao = new EmployDaoImpl();
		
		try {
			List<Employ> employ = dao.showEmploydao();
			employ.forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchEmployMain() {
		EmployDao dao = new EmployDaoImpl();
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employ no");
		empno = sc.nextInt();
		
		try {
			Employ employ = dao.searchEmployDao(empno);
			System.out.println(employ);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void applyLeaveMain() {
		LeaveDao dao = new LeaveDaoImpl();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee ID: ");
		int empId = sc.nextInt();

		sc.nextLine(); // Consume newline

		System.out.print("Enter Leave Start Date (yyyy-mm-dd): ");
		String startDateStr = sc.nextLine();
		java.sql.Date startDate = java.sql.Date.valueOf(startDateStr);

		System.out.print("Enter Leave End Date (yyyy-mm-dd): ");
		String endDateStr = sc.nextLine();
		java.sql.Date endDate = java.sql.Date.valueOf(endDateStr);

		System.out.print("Enter Leave Type (e.g. EL): ");
		String leaveType = sc.nextLine();

		System.out.print("Enter Leave Reason: ");
		String leaveReason = sc.nextLine();

		Leave leave = new Leave();
		leave.setEmpId(empId);
		leave.setLeaveStDt(startDate);
		leave.setLeaveEndDt(endDate);
		leave.setLeaveType(leaveType);
		leave.setLeaveReason(leaveReason);

		try {
			System.out.println(dao.applyLeave(leave));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showLeaveHistoryMain() {
		LeaveDao leaveDao = new LeaveDaoImpl();
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employ no");
		empno = sc.nextInt();
		
		try {
			List<Leave> leaveList = leaveDao.showLeaveHistory(empno);
			leaveList.forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void pendingRequestMain() {
		LeaveDao leaveDao = new LeaveDaoImpl();
		int mgrNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Manager id");
		mgrNo = sc.nextInt();
		
		try {
			List<Leave> leaveList = leaveDao.pendingLeaveList(mgrNo);
			leaveList.forEach(System.out::println);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void manageLeaveMain() {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Manager ID: ");
        int managerId = sc.nextInt();

        System.out.print("Enter Leave ID: ");
        int leaveId = sc.nextInt();

        System.out.print("Do you want to accept the leave request? (true/false): ");
        boolean isAccept = sc.nextBoolean();

        sc.nextLine();  
        System.out.print("Enter your comments: ");
        String managerComments = sc.nextLine();
        

        LeaveDao dao = new LeaveDaoImpl();
        
        try {
			String result = dao.manageLeaveDao(leaveId, managerId, isAccept, managerComments);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int choice;

	    
	    while (true) {
	        System.out.println("\n--- Leave Management System ---");
	        System.out.println("1. Show All Employees");
	        System.out.println("2. Search Employee");
	        System.out.println("3. Apply Leave");
	        System.out.println("4. Show Leave History");
	        System.out.println("5. View Pending Leave Requests");
	        System.out.println("6. Manage Leave Request");
	        System.out.println("7. Exit");
	        System.out.print("Enter your choice : ");
	        choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                showEmployMain();
	                break;
	            case 2:
	                searchEmployMain();
	                break;
	            case 3:
	                applyLeaveMain();
	                break;
	            case 4:
	                showLeaveHistoryMain();
	                break;
	            case 5:
	                pendingRequestMain();
	                break;
	            case 6:
	                manageLeaveMain();
	                break;
	            case 7:
	                System.out.println("Exiting the system.");
	                return;  
	            default:
	                System.out.println("Invalid choice, please try again.");
	        }
	    }
	}
}
