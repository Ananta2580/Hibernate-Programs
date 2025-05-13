<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resolve Complaint</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .container {
            width: 50%;
            background-color: #ffffff;
            margin: 50px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .container input[type="text"], 
        .container input[type="date"], 
        .container textarea {
            width: 100%;
            padding: 12px;
            margin: 8px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

        .container input[type="submit"] {
            background-color: #2e7d32;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .container input[type="submit"]:hover {
            background-color: #1b5e20;
        }

        .container input[readonly] {
            background-color: #f4f4f4;
        }

        .container label {
            font-size: 16px;
            color: #333;
        }

        .form-header {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="form-header">
            <h2>Resolve Complaint</h2>
        </div>

        <jsp:useBean id="complaintDao" class="com.java.cms.dao.ComplaintDaoImpl"/>
        <c:set var="complaint" value="${complaintDao.searchComplaint(param.complaintId)}"/>

        <form action="ResolveComplaint.jsp" method="post">
            <label for="complaintId">Complaint ID:</label>
            <input type="text" name="complaintId" value="${param.complaintId}" readonly="readonly" /><br>

            <label for="complaintDate">Complaint Date:</label>
            <input type="date" name="complaintDate" value="${complaint.complaintDate}" readonly="readonly" /><br>

            <label for="resolveDate">Resolve Date:</label>
            <input type="date" name="resolveDate" required min="<%= java.time.LocalDate.now() %>"/><br>

            <label for="resolvedBy">Resolved By:</label>
            <input type="text" name="resolvedBy" required /><br>

            <label for="comments">Comments:</label><br>
            <textarea name="comments" rows="4" cols="40"></textarea><br>

            <input type="submit" value="Submit" />
        </form>

        <c:if test="${not empty param.complaintId and
                    not empty param.complaintDate and
                    not empty param.resolveDate and
                    not empty param.resolvedBy}">
            <jsp:useBean id="resolveDao" class="com.java.cms.dao.ResolveDaoImpl"/>
            <jsp:useBean id="resolve" class="com.java.cms.model.Resolve"/>

            <c:set var="date1" value="${resolveDao.convertToSqlDate(param.complaintDate)}"/>
            <c:set var="date2" value="${resolveDao.convertToSqlDate(param.resolveDate)}"/>

            <jsp:setProperty property="complaintId" name="resolve" value="${param.complaintId}"/>
            <jsp:setProperty property="complaintDate" name="resolve" value="${date1}"/>
            <jsp:setProperty property="resolveDate" name="resolve" value="${date2}"/>
            <jsp:setProperty property="resolvedBy" name="resolve" value="${param.resolvedBy}"/>
            <jsp:setProperty property="comments" name="resolve" value="${param.comments}"/>

            <c:out value="${resolveDao.resolveComplaint(resolve)}"/>
            <jsp:forward page="Home.jsp"/>
        </c:if>
    </div>

</body>
</html>
