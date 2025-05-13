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
	
	<table border="3">
		<thead>
			<tr>
				<th>Employ No</th>
				<th>Employ Name</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Designation</th>
				<th>Basic</th>
			</tr>
		</thead>
		<c:forEach var="employ" items="${query.rows }">
		<tbody>
			<tr>
				<td><c:out value="${employ.empno }"/></td>
				<td><c:out value="${employ.name }"/></td>
				<td><c:out value="${employ.gender }"/></td>
				<td><c:out value="${employ.dept }"/></td>
				<td><c:out value="${employ.desig }"/></td>
				<td><c:out value="${employ.basic }"/></td>
			</tr>
		</tbody>
		</c:forEach>
		
	</table>

</body>
</html>