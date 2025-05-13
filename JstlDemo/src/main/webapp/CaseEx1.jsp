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
	<form action="CaseEx1.jsp" method="get">
		<center>
			Student no:
			<input type="number" name="sno">
			<input type="submit" value="Submit" id="button-1"/>
		</center>
	</form>
	
	<c:if test="${param.sno != null }">
		<c:set var="sno" value="${param.sno }"/>
		<c:choose>
			<c:when test="${sno == 1 }">
				<c:out value="Hii I am Ananta"/>
			</c:when>
			<c:when test="${sno == 2 }">
				<c:out value="Hii I am Avanthika"/>
			</c:when>
			<c:when test="${sno == 3 }">
				<c:out value="Hii I am Murli"/>
			</c:when>
			<c:otherwise>
				<c:out value="Invalid Value"/>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>