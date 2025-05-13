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
	<form action="name.jsp">
		Student Name:
		<input type="text" name="name"><br><br>
			<input type="submit" value="Submit" id="button-1"/>
	</form>
	<c:if test="${param.name != null }">
		<c:set var="name" value="${param.name }"/>
		Student Name is:<c:out value="${name }"></c:out>
	</c:if>
</body>
</html>