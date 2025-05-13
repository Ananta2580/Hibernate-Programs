<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Show</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        background-color: #fff;
    }

    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ccc;
    }

    thead {
        background-color: #007bff;
        color: white;
    }

    tbody tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tbody tr:hover {
        background-color: #e0f7fa;
    }
</style>

</head>
<body>

    <h2>Employee Details</h2>

	<jsp:useBean id="empdao" class="com.java.pms.dao.EmployeeServices"/>
	<c:set var="empList" value="${empdao.getAllEmployees() }"/>
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>Address</th>
				<th>Position</th>
				<th>Join Date</th>
				<th>Termination Date</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.empId }</td>
				<td>${emp.fName }</td>
				<td>${emp.lName }</td>
				<td>${emp.DOB }</td>
				<td>${emp.gender }</td>
				<td>${emp.email }</td>
				<td>${emp.mobNo }</td>
				<td>${emp.address }</td>
				<td>${emp.position }</td>
				<td>${emp.joinDate }</td>
				<td>${emp.terminationDate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
