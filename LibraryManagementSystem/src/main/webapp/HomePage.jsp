<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Choice</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        text-align: center;
        padding: 40px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
    }

    .container h2 {
        margin-bottom: 20px;
        color: #333;
        font-size: 24px;
    }

    .links a {
        display: inline-block;
        text-decoration: none;
        margin: 15px;
        padding: 12px 30px;
        background-color: #007bff;
        color: #fff;
        border-radius: 4px;
        font-size: 16px;
        font-weight: bold;
        transition: background-color 0.3s;
    }

    .links a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <h2>Select Login Type</h2>
    <div class="links">
        <a href="login.jsp">User Login</a>
        <a href="AdminLogin.jsp">Admin Login</a>
    </div>
</div>

</body>
</html>
