<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Complaint Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 40px;
            color: #333;
        }

        form {
            background-color: #fff;
            max-width: 500px;
            margin: 30px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #444;
        }

        select, input[type="date"], textarea, input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Complaint Registration Form</h2>
    
    <form action="AddComplaint.jsp" method="post">

        <label>Complaint Type:</label>
        <select name="complaintType" required>
            <option value="">--Select--</option>
            <option value="Technical">Technical</option>
            <option value="Billing">Billing</option>
            <option value="Service">Service</option>
            <option value="Other">Other</option>
        </select>
        
        <label>Complaint Date:</label>
        <input type="date" name="complaintDate" required max="<%= java.time.LocalDate.now() %>" min="<%= java.time.LocalDate.now() %>">

        <label>Severity:</label>
        <select name="severity" required>
            <option value="">--Select--</option>
            <option value="Low">Low</option>
            <option value="Medium">Medium</option>
            <option value="High">High</option>
            <option value="Critical">Critical</option>
        </select>

        <label>Description:</label>
        <textarea name="cDescription" rows="4" required></textarea>

        <input type="submit" value="Submit Complaint">
    </form>
    
    <c:if test="${not empty param.complaintType and 
    				not empty param.complaintDate and 
    				not empty param.severity}">
    				
    	<jsp:useBean id="complaint" class="com.java.cms.model.Complaint"/>
    	<jsp:useBean id="complaintDao" class="com.java.cms.dao.ComplaintDaoImpl"/>
    	<c:set var="date" value="${complaintDao.convertToSqlDate(param.complaintDate) }"/>
    
    	<jsp:setProperty property="complaintType" name="complaint" value="${param.complaintType }"/>
   		<jsp:setProperty property="complaintDate" name="complaint" value="${date }"/>
   		<jsp:setProperty property="severity" name="complaint" value="${param.severity }"/>
   		<jsp:setProperty property="cDescription" name="complaint" value="${param.cDescription }"/>
    
    	<c:out value="${complaintDao.addComplaint(complaint) }"/>
    	<jsp:forward page="Home.jsp"/>
    </c:if>
</body>
</html>
