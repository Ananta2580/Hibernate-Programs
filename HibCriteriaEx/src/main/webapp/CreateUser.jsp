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
	<form method="get" action="CreateUser.jsp">
		<center>
			User Name : 
			<input type="text" name="userName" /> <br/><br/>
			Passcode : 
			<input type="password" name="passCode" /> <br/><br/>
			<input type="submit" value="Create User" />
		</center>
	</form>
	<jsp:useBean id="login" class="com.java.hib.Login"/>
	<jsp:setProperty property="*" name="login"/>
	<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl"/>
	
	<c:if test="${login.userName != null && login.passCode != null }">
		<c:out value="${agentdao.createUser(login) }"/>
	</c:if>
	
</body>
</html>