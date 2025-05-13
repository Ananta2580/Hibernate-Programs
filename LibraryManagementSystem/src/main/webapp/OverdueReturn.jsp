<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.lib.model.TransReturn"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Overdue Return</title>
<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f2f2f2;
		margin: 0;
		padding: 0;
	}
	h1 {
		text-align: center;
		color: #333;
		margin-top: 20px;
	}
	table {
		border-collapse: collapse;
		width: 80%;
		margin: 30px auto;
		background-color: #fff;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	th, td {
		border: 1px solid #ddd;
		padding: 12px;
		text-align: center;
	}
	th {
		background-color: #4CAF50;
		color: white;
	}
	tr:nth-child(even) {
		background-color: #f9f9f9;
	}
	tr:hover {
		background-color: #f1f1f1;
	}
</style>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"/>
	<h1>Overdue Book Returns</h1>
	<jsp:useBean id="libDao" class="com.java.lib.dao.LibraryDaoImpl"/>
	<%
		List<TransReturn> returnList = libDao.getOverdueReturn();
	%>
	
	<table>
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Username</th>
				<th>From Date</th>
				<th>To Date</th>
				<th>Days Late</th>
				<th>Fine (₹)</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(TransReturn tr : returnList){
				LocalDate fromDate = tr.getFromDate().toLocalDate();
				LocalDate toDate = tr.getToDate().toLocalDate();
				long totalDays = toDate.toEpochDay() - fromDate.toEpochDay();
				long daysLate = totalDays - 21;
				if (daysLate < 0) {
				    daysLate = 0; 
				}
		%>
			<tr>
				<td><%=tr.getBookId() %></td>
				<td><%=tr.getUsername() %></td>
				<td><%=tr.getFromDate() %></td>
				<td><%=tr.getToDate() %></td>
            	<td><%=daysLate %></td>
            	<td><%=daysLate * 5 %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>
