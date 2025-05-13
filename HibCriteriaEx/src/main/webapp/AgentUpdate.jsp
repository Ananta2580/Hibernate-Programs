<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AgentUpdate.jsp">
		<center>
			AgentId:
			<input type="text" name="agentId"><br><br>
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
			
			<input type="submit" value="Update" />
		</center>
	</form>
	<jsp:useBean id="agent" class="com.java.hib.Agent"/>
	<jsp:setProperty property="*" name="agent"/>
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	
	<c:if test="${param.agentId != null && param.premium != null && param.maritalStatus != null}">
	
		<c:out value="${agentdao.updateAgent(agent) }"/>
	
	</c:if>
</body>
</html>