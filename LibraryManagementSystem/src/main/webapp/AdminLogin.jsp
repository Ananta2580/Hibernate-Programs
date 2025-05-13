<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .login-container {
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
        background-color: #4285F4;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
    }

    input[type="submit"]:hover {
        background-color: #357ae8;
    }

    .link {
        text-align: center;
        margin-top: 15px;
    }

    .link a {
        text-decoration: none;
        color: #4285F4;
    }

    .link a:hover {
        text-decoration: underline;
    }

    .error {
        color: red;
        text-align: center;
    }
</style>
</head>
<body>

<div class="login-container">
    <form action="AdminLogin.jsp" method="post">
        <h2>Admin Login</h2>
        <label>User Name :</label>
        <input type="text" name="adminName" required>

        <label>Password :</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login">

        <div class="link">
            Do you want more Admins? <a href="AddAdmin.jsp">Add here</a>
        </div>
    </form>

    <%
        if(request.getParameter("adminName") != null && request.getParameter("password") != null){
            String user = request.getParameter("adminName");
            String pwd = request.getParameter("password");
    %>
    <jsp:useBean id="admin" class="com.java.lib.model.Admin"/>
    <jsp:setProperty property="*" name="admin"/>
    <jsp:useBean id="librarydao" class="com.java.lib.dao.LibraryDaoImpl"/>
    <%
        int count = librarydao.adminLogin(admin);
        if(count == 1){
            session.setAttribute("admin", request.getParameter("adminName"));
    %>
    <jsp:forward page="AdminMenu.jsp"/>
    <%
        } else {
    %>
    <p class="error">Invalid Credentials...</p>
    <%
        }
    }
    %>
</div>

</body>
</html>
