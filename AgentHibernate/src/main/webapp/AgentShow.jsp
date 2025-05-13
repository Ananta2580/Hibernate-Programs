<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent Show</title>
</head>
<body>
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	<c:set var="agentList" value="${agentdao.showAgent() }"/>
	<table border="3" align="center">
		<thead>
			<tr>
				<th>Agent Id</th>
				<th>Name</th>
				<th>City</th>
				<th>Gender</th>
				<th>Marital Status</th>
				<th>Premium</th>
			</tr>
		</thead>
		<c:forEach var="agent" items="${agentList }">
		<tbody>
			<tr>
				<td>${agent.agentId }</td>
				<td>${agent.name }</td>
				<td>${agent.city }</td>
				<td>${agent.gender }</td>
				<td>${agent.maritalStatus }</td>
				<td>${agent.premium }</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>