<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Password</title>
</head>
<body>
	<form action="NewPassword.jsp">
		<center>
			UserName:
			<input type="text" name="userName" value="${sessionScope.user }"><br><br>
			New Password:
			<input type="text" name="passCode"><br><br>
			Cofirm Password:
			<input type="text" name="reEnter"><br><br>
			
			<input type="submit" value="Change Password"/>
		</center>
	</form>
	
	<jsp:useBean id="employeeDao" class="com.java.hib.dao.EmployeeDaoImpl"/>
	
	<c:if test="${param.userName != null && param.passCode != null && param.reEnter != null }">
	
		<c:out value="${employeeDao.updatePassword(param.userName, param.passCode) }"/>
		
	</c:if>
	
	
</body>
</html>