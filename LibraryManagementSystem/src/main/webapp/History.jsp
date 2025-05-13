<%@page import="com.java.lib.model.TransReturn"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f6f8;
        padding: 40px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 30px;
    }

    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #ffffff;
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    thead {
        background-color: #34495e;
        color: #ffffff;
    }

    th, td {
        padding: 14px 18px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tbody tr:hover {
        background-color: #e8f0fe;
    }
</style>
</head>
<body>

<jsp:include page="Menu.jsp"/>
<jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl"/>
<%
    String user = (String)session.getAttribute("user");
    List<TransReturn> histList = libraryDao.showHistory(user);
%>

<h2>Transaction History</h2>
<table>
    <thead>
        <tr>
            <th>Book ID</th>
            <th>User Name</th>
            <th>From Date</th>
            <th>To Date</th>
        </tr>
    </thead>
    <tbody>
        <%
            for(TransReturn tReturn : histList){
        %>
        <tr>
            <td><%=tReturn.getBookId() %></td>
            <td><%=tReturn.getUsername() %></td>
            <td><%=tReturn.getFromDate() %></td>
            <td><%=tReturn.getToDate() %></td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

</body>
</html>
