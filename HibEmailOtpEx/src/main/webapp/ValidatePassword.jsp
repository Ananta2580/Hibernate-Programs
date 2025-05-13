<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate Password</title>
</head>
<body>
	<form action="ValidatePassword.jsp">
		<center>
			UserName:
			<input type="text" name="userName" value="${sessionScope.user }"><br><br>
			Password:
			<input type="text" name="nPassword"><br><br>
			Re-Enter Password:
			<input type="text" name="reEnter"><br><br>
			
			<input type="submit" value="Validate"/>
		</center>
	</form>
	
	<jsp:useBean id="employeeDao" class="com.java.hib.dao.EmployeeDaoImpl"/>
	<c:if test="${param.userName != null && param.nPassword != null && param.reEnter != null }">
		<c:out value="${employeeDao.validatePassword(param.userName, param.nPassword) }"/>
		<jsp:forward page="NewPassword.jsp"/>
	</c:if>
	
</body>
</html>