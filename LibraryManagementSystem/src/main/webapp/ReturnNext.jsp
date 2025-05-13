<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return Book</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f7fa;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 800px;
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
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #f4f4f4;
        color: #333;
    }

    .message {
        font-size: 16px;
        color: #2e8b57;
        padding: 10px 0;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }

    .btn {
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        display: block;
        margin: 20px auto;
    }

    .btn:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

<jsp:include page="Menu.jsp"/>

<jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl" />

<div class="container">
    <h2>Return Book(s)</h2>

    <%
        String user = (String)session.getAttribute("user");
        String[] bookList = request.getParameterValues("bookId");

        for(String str : bookList) {
            int id = Integer.parseInt(str);
            String message = libraryDao.returnBook(user, id);
    %>
        <div class="message"><%= message %></div>
    <%
        }
    %>

    <div style="text-align: center;">
        <a href="AccountDetails.jsp" class="btn">Go Back to Account Details</a>
    </div>
</div>

</body>
</html>
