<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
    }

    .navbar {
        background-color: #343a40;
        overflow: hidden;
        display: flex;
        justify-content: center;
        padding: 14px 0;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    .navbar a {
        color: #fff;
        padding: 14px 20px;
        text-decoration: none;
        text-align: center;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    .navbar a:hover {
        background-color: #495057;
    }
</style>
</head>
<body>
    <div class="navbar">
        <a href="AddBook.jsp">Add Book</a>
        <a href="OverdueReturn.jsp">Overdue Return</a>
    </div>
</body>
</html>
