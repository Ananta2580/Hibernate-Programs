<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent Search</title>
</head>
<body>

	<form action="AgentSearch.jsp">
		<center>
			Enter agentId:
			<input type="number" name="id">
			
			<input type="submit" value="Search"/>
		</center>
	</form>
	
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	
	<c:set var="agentId" value="${param.id }"/>
	
	<c:set var="agent" value="${agentdao.searchAgent(agentId) }"/>
	<c:if test="${agent != null }">
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
			
		</table>
	</c:if>
	
</body>
</html>