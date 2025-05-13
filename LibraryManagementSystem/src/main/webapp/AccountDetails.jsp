<%@page import="com.java.lib.model.TranBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issued Books Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f7fa;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 900px;
        margin: auto;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #3498db;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e6f2ff;
    }

</style>

</head>
<body>

<jsp:include page="Menu.jsp"></jsp:include>

<jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl"/>

<%
    String user = (String)session.getAttribute("user");
    List<TranBook> booksIssued = libraryDao.accountDetails(user);
%>

<div class="container">
    <h2>Issued Books Details</h2>
    
    <table>
        <tr>
            <th>Book Id</th>
            <th>User Name</th>
            <th>From Date</th>
        </tr>
        <%
            for(TranBook tbook : booksIssued) {
        %>
        <tr>
            <td><%=tbook.getBookId() %>  </td>
            <td><%=tbook.getUsername() %> </td>
            <td><%=tbook.getDate() %> </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
