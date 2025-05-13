<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent Insert</title>
</head>
<body>
	<form action="AgentInsert.jsp">
		<center>
			AgentId:
			<input type="text" name="id"><br><br>
			Agent Name:
			<input type="text" name="name"><br><br>
			City:
			<input type="text" name="city"><br><br>
			Gender:
			<input type="text" name="gender"><br><br>
			Marital Status:
			<input type="text" name="maritalStatus"><br><br>
			Premium:
			<input type="text" name="premium"><br><br>
			
			<input type="submit" value="Submit" />
		</center>
	</form>
	<jsp:useBean id="agent" class="com.java.hib.Agent"/>
	<jsp:setProperty property="*" name="agent"/>
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	
	<c:if test="${param.id != null && param.premium != null && param.maritalStatus != null}">
	
		<c:out value="${agentdao.addAgent(agent) }"/>
	
	</c:if>
	
</body>
</html>