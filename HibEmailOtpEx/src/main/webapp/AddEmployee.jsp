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
	<form action="AddEmployee.jsp" method="get">
		<center>
			First Name:
			<input type="text" name="firstName"><br><br>
			
			Last Name:
			<input type="text" name="lastName"><br><br>
			
			UserName:
			<input type="text" name="userName"><br><br>
			
			email:
			<input type="text" name="email"><br><br>
			
			<input type="submit" value="Submit"/>
		</center>
	</form>
	
	<jsp:useBean id="beanEmployeeDao" class="com.java.hib.dao.EmployeeDaoImpl" />
	<jsp:useBean id="beanEmployee" class="com.java.hib.model.Employee" />
	<jsp:setProperty property="*" name="beanEmployee"/>
	<c:if test="${param.firstName !=null && param.lastName !=null && 
		param.userName !=null && param.email !=null
	 }">
	 	<c:out value="${beanEmployeeDao.addEmployee(beanEmployee)}" />
	 	<jsp:forward page="GeneratePassword.jsp"/>
	 </c:if>
</body>
</html>