<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Complaint Show</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 40px auto;
            background-color: #fff;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
            font-size: 14px;
        }

        thead {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #fff;
            background-color: #2196F3;
            padding: 6px 12px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0b7dda;
        }

        h2 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }
    </style>
</head>
<body>

    <h2>Complaint Records</h2>

    <jsp:useBean id="complaintDao" class="com.java.cms.dao.ComplaintDaoImpl"/>

    <table>
        <thead>
            <tr>
                <th>ComplaintId</th>
                <th>Complaint Type</th>
                <th>Description</th>
                <th>Complaint Date</th>
                <th>Severity</th>
                <th>Status</th>
                
            </tr>
        </thead>
        
        
            <tbody>
            	<c:forEach var="complaint" items="${complaintDao.showComplaint()}">
                <tr onclick="window.location.href='ResolveComplaint.jsp?complaintId=${complaint.complaintId}'" style="cursor: pointer;">
                    <td>${complaint.complaintId}</td>
                    <td>${complaint.complaintType}</td>
                    <td>${complaint.cDescription}</td>
                    <td>${complaint.complaintDate}</td>
                    <td>${complaint.severity}</td>
                    <td>${complaint.status}</td>
                </tr>
                </c:forEach>
            </tbody>
    </table><br><br>
    
    
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
