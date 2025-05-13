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
	<form method="get" action="Authenticate.jsp">
		<center>
			User Name : 
			<input type="text" name="userName" /> <br/><br/>
			Passcode : 
			<input type="password" name="passCode" /> <br/><br/>
			<input type="submit" value="Login" />
		</center>
	</form>
	<c:if test="${param.userName !=null && param.passCode !=null}">
		<jsp:useBean id="agentdao" class="com.java.hib.dao.AgentDaoImpl" /> 
		<c:set var="agent" value="${agentdao.authenticate(param.userName,param.passCode)}" />
		
		<c:if test="${agent != null}">
			<jsp:forward page="AgentShow.jsp" />
		</c:if>
		<c:if test="${agent == null}">
			<c:out value="Invalid Credentials..." />
		</c:if>
	</c:if>
</body>
</html>