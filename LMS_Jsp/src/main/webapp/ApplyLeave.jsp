<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Application</title>
</head>
<body>

<jsp:useBean id="leavedao" class="com.java.lms.dao.LeaveDaoImpl"/>
<c:set var="empId" value="${param.empId}" />
<c:set var="mgrId" value="${param.mgrId }"/>

<form action="ApplyLeave.jsp" method="post">
    <h2>Leave Application Form</h2>

    <label for="empId">Employee ID:</label>
    <input type="number" name="empId" id="empId" value="${empId}" readonly />

    <label for="leaveStDt">Leave Start Date:</label>
    <input type="date" name="leaveStDt" id="leaveStDt" required />

    <label for="leaveEndDt">Leave End Date:</label>
    <input type="date" name="leaveEndDt" id="leaveEndDt" required />

    <label for="leaveType">Leave Type:</label>
    <select name="leaveType" id="leaveType" required>
        <option value="" disabled selected>--Select--</option>
        <option value="EL">Earned Leave</option>
        <option value="SL">Sick Leave</option>
        <option value="PL">Personal Leave</option>
    </select>

    <label for="leaveReason">Reason:</label>
    <textarea name="leaveReason" id="leaveReason" rows="4" required></textarea>

    <input type="submit" value="Apply Leave" />
</form>

<!-- Logic for applying leave -->
<c:if test="${not empty param.empId 
              and not empty param.leaveStDt 
              and not empty param.leaveEndDt 
              and not empty param.leaveType 
              and param.leaveType != ''}">

    <!-- Convert date parameters -->
    <c:set var="date1" value="${leavedao.convertToSqlDate(param.leaveStDt)}" />
    <c:set var="date2" value="${leavedao.convertToSqlDate(param.leaveEndDt)}" />

    <!-- Create Leave object and set its properties -->
    <jsp:useBean id="leave" class="com.java.lms.model.Leave"/>
    <jsp:setProperty property="empId" name="leave" value="${param.empId}"/>
    <jsp:setProperty property="leaveStDt" name="leave" value="${date1}"/>
    <jsp:setProperty property="leaveEndDt" name="leave" value="${date2}"/>
    <jsp:setProperty property="leaveType" name="leave" value="${param.leaveType}"/>
    <jsp:setProperty property="leaveReason" name="leave" value="${param.leaveReason}"/>

    <!-- Apply leave only if all required data is valid -->
    <c:set var="result" value="${leavedao.applyLeave(leave)}"/>
    <c:out value="${result}" />

    <!-- Redirect after applying -->
    <jsp:forward page="DashBoard.jsp"/>
</c:if>


</body>
</html>
