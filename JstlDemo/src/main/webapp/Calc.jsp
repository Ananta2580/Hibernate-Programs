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
	<form action="Calc.jsp" method="get">
		<center>
			First No :
			<input type="number" name="firstno">
			Second No :
			<input type="number" name="secondno">
			<input type="submit" value="Submit" id="button-1"/>
		</center>
	</form>
	
	<c:if test="${param.firstno != null && param.secondno != null }">
		<jsp:useBean id="calcbean" class="com.java.jstl.util.CalcBean"/>
		<jsp:setProperty property="*" name="calcbean"/>
		Sum is : <c:out value="${calcbean.sum() }"/>
		Sub is : <c:out value="${calcbean.sub() }"/>
		mul is : <c:out value="${calcbean.mul() }"/>
	</c:if>
	
</body>
</html>