<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="conn"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/infinitepractice"
		user="root"
		password="Ananta"
	/>
	
	<sql:query var="query" dataSource="${conn }">
		select * from employ
	</sql:query>
	
	<c:forEach var="employ" items="${query.rows }">
	
		Employ no: <c:out value="${employ.empno }"/><br>
		Employ name: <c:out value="${employ.name }"/><br>
		Gender: <c:out value="${employ.gender }"/><br>
		Department: <c:out value="${employ.dept }"/><br>
		Designation: <c:out value="${employ.desig }"/><br>
		Basic: <c:out value="${employ.basic }"/><br><hr>
	
	</c:forEach>
</body>
</html>