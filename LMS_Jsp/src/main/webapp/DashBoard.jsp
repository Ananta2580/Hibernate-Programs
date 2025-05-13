<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Info</title>

<!-- CSS Styling -->
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #eef1f5;
        margin: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    table {
        width: 90%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: center;
    }

    th {
        background-color: #007bff;
        color: white;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    p {
    	margin: 6px 0;
    	color: #000000; 
	}


    b {
        color: white;
    }

    .info-table th {
        vertical-align: top;
        text-align: left;
    }

</style>
</head>
<body>

    <jsp:useBean id="employDao" class="com.java.lms.dao.EmployDaoImpl" />

    <c:set var="empId" value="${param.empId}" />
    <c:set var="mgrId" value="${param.mgrId}" />

    <c:set var="myInfo" value="${employDao.searchEmployDao(param.empId)}" />
    <c:set var="myManagerInfo" value="${employDao.searchEmployDao(param.mgrId)}" />

    <h2>Employee & Manager Details</h2>
	<a href="ApplyLeave.jsp?empId=${empId }&mgrId=${mgrId}">Apply Leave</a>
    <table class="info-table">
        <tr>
            <th>
                <p>Employee Id: <b>${myInfo.empId}</b></p>
                <p>Employee Name: <b>${myInfo.empName}</b></p>
                <p>Email: <b>${myInfo.empMail}</b></p>
                <p>Mobile No: <b>${myInfo.empMobno}</b></p>
                <p>Department: <b>${myInfo.empDept}</b></p>
                <p>Date Of Join: <b>${myInfo.empJoinDate}</b></p>
                <p>Manager Id: <b>${myInfo.empMgrId}</b></p>
                <p>Leave Available Balance: <b>${myInfo.empLeaveBal}</b></p>
            </th>
            <th>
                <p>Manager Id: <b>${myManagerInfo.empId}</b></p>
                <p>Manager Name: <b>${myManagerInfo.empName}</b></p>
                <p>Manager Email: <b>${myManagerInfo.empMail}</b></p>
                <p>Manager Mobile No: <b>${myManagerInfo.empMobno}</b></p>
                <p>Manager Department: <b>${myManagerInfo.empDept}</b></p>
                <p>Manager Date Of Join: <b>${myManagerInfo.empJoinDate}</b></p>
                <p>Manager Id: <b>${myManagerInfo.empMgrId}</b></p>
                <p>Manager Leave Available Balance: <b>${myManagerInfo.empLeaveBal}</b></p>
            </th>
        </tr>
    </table>

    <jsp:useBean id="leavedao" class="com.java.lms.dao.LeaveDaoImpl" />
    <c:set var="leaveList" value="${leavedao.showLeaveHistory(empId)}" />

    <h2>Leave History</h2>
    <table>
        <thead>
            <tr>
                <th>Leave Id</th>
                <th>No of Days</th>
                <th>Manager Comments</th>
                <th>Employee Id</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Leave Type</th>
                <th>Status</th>
                <th>Reason</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="leave" items="${leaveList}">
                <tr>
                    <td>${leave.leaveId}</td>
                    <td>${leave.noOfDays}</td>
                    <td>${leave.leaveMgrCmts}</td>
                    <td>${leave.empId}</td>
                    <td>${leave.leaveStDt}</td>
                    <td>${leave.leaveEndDt}</td>
                    <td>${leave.leaveType}</td>
                    <td>${leave.leaveStatus}</td>
                    <td>${leave.leaveReason}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <c:set var="pendingList" value="${leavedao.pendingLeaveList(empId)}" />
<c:set var="lastEmpId" value="0" />

<h2>Leave Pending History</h2>
<table>
    <tbody>
        <c:forEach var="pending" items="${pendingList}">
            <c:if test="${pending.empId != lastEmpId}">
                <c:set var="lastEmpId" value="${pending.empId}" />
                <c:set var="empInfo" value="${employDao.searchEmployDao(pending.empId)}" />
                <!-- Heading row per unique empId -->
                <th>Employee Id</th>
                <th>${empInfo.empId }</th>
                <th>Employee name</th>
                <th>${empInfo.empName }</th>
                <th>Employee Mobile</th>
                <th colspan="2">${empInfo.empMobno }</th>
        
                <!-- Table Headers -->
                <tr style="background-color: #f2f2f2;">
                    <th>Leave ID</th>
                    <th>No of Days</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Leave Type</th>
                    <th>Status</th>
                    <th>Reason</th>
                </tr>
            </c:if>

            <!-- Leave row -->
            <tr>
                <td>${pending.leaveId}</td>
                <td>${pending.noOfDays}</td>
                <td>${pending.leaveStDt}</td>
                <td>${pending.leaveEndDt}</td>
                <td>${pending.leaveType}</td>
                <td>${pending.leaveStatus}</td>
                <td>${pending.leaveReason}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>
