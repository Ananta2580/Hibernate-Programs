<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AgentUpdate.jsp">
		<center>
			Enter agentId:
			<input type="number" name="id">
			
			<input type="submit" value="Delete"/>
		</center>
	</form>
	
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	<c:set var="agentId" value="${param.agentId }"/>
	<c:out value="${agentdao.deleteAgent(agentId) }"/>
</body>
</html>