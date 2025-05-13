<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Account</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .form-container {
        width: 400px;
        margin: 100px auto;
        background-color: #fff;
        padding: 30px;
        box-shadow: 0 0 10px rgba(0,0,0,0.2);
        border-radius: 10px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .message {
        text-align: center;
        margin-top: 15px;
        color: red;
    }

    .create-account {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
    }

    .create-account a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    .create-account a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="form-container">
    <form action="login.jsp" method="post">
        <h2>Login Account</h2>

        <label>User Name :</label>
        <input type="text" name="username" required>

        <label>Password :</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login">

        <div class="create-account">
            Don't have an account? <a href="AddUser.jsp">Create Here</a>
        </div>
    </form>

    <div class="message">
    <%
    if (request.getParameter("username")!=null && 
        request.getParameter("password")!=null) {
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
    %>
        <jsp:useBean id="libUsers" class="com.java.lib.model.LibUsers" />
        <jsp:setProperty property="*" name="libUsers"/>
        <jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl" />

    <%
        int count = libraryDao.login(libUsers);
        if (count==1) {
            session.setAttribute("user", request.getParameter("username"));
    %>
        <jsp:forward page="Menu.jsp" />
    <%
        } else {
            out.println("Invalid Credentials...");
        }
    }
    %>
    </div>
</div>

</body>
</html>
