<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<!-- Inline CSS -->
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px 15px;
        text-align: center;
        border: 1px solid #ddd;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }
    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<h1>Employee Information</h1>

<jsp:useBean id="employdao" class="com.java.lms.dao.EmployDaoImpl"/>
<c:set var="employList" value="${employdao.showEmploydao() }"/>

<table>
    <thead>
        <tr>
            <th>Employ Id</th>
            <th>Employee Name</th>
            <th>Employee Email</th>
            <th>Mobile No</th>
            <th>Date of Join</th>
            <th>Department</th>
            <th>Manager Id</th>
            <th>Leave Balance</th>
            <th>Show Info</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${employList}">
            <tr>
                <td>${emp.empId}</td>
                <td>${emp.empName}</td>
                <td>${emp.empMail}</td>
                <td>${emp.empMobno}</td>
                <td>${emp.empJoinDate}</td>
                <td>${emp.empDept}</td>
                <td>${emp.empMgrId}</td>
                <td>${emp.empLeaveBal}</td>
                <td>
                    <a href="DashBoard.jsp?empId=${emp.empId}&mgrId=${emp.empMgrId}">Show Info</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
