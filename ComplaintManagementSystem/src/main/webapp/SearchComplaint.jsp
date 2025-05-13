<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Complaint</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        .container {
            width: 50%;
            background-color: #ffffff;
            margin: 50px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .form-field {
            margin-bottom: 15px;
        }

        .form-field label {
            font-size: 16px;
            color: #333;
        }

        .form-field input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .form-field input[type="submit"] {
            background-color: #2e7d32;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .form-field input[type="submit"]:hover {
            background-color: #1b5e20;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f4f4f4;
        }

        .error-message {
            color: red;
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Search Complaint</h2>
        <form action="SearchComplaint.jsp" method="get">
            <div class="form-field">
                <label for="complaintId">Enter Complaint ID:</label><br>
                <input type="text" name="complaintId" id="complaintId" required/><br><br>
            </div>
            <div class="form-field">
                <input type="submit" value="Search" />
            </div>
        </form>

        <jsp:useBean id="complaintDao" class="com.java.cms.dao.ComplaintDaoImpl"/>

        <c:set var="compId" value="${param.complaintId }"/>
        <c:set var="complaint" value="${complaintDao.searchComplaint(compId) }"/>

        <c:if test="${complaint == null && compId != null}">
            <p class="error-message">Complaint Does not Exist</p>
        </c:if>

        <c:if test="${complaint != null }">
            <table>
                <thead>
                    <tr>
                        <th>Complaint ID</th>
                        <th>Complaint Type</th>
                        <th>Description</th>
                        <th>Complaint Date</th>
                        <th>Severity</th>
                        <th>Status</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr onclick="window.location.href='ResolveComplaint.jsp?complaintId=${complaint.complaintId}'" style="cursor: pointer;">
                        <td>${complaint.complaintId }</td>
                        <td>${complaint.complaintType }</td>
                        <td>${complaint.cDescription }</td>
                        <td>${complaint.complaintDate }</td>
                        <td>${complaint.severity }</td>
                        <td>${complaint.status }</td>
                        
                    </tr>
                </tbody>
            </table>
        </c:if>
    </div><br><br>
    
    <div style="text-align: center; margin-bottom: 20px;">
    <form action="Home.jsp" method="get">
        <button type="submit" style="
            background-color: #2e7d32;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        ">
            ← Back to Home
        </button>
    </form>
</div>
</body>
</html>
