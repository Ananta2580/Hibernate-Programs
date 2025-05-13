<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Admin</title>
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
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }

    .message {
        text-align: center;
        margin-top: 15px;
    }

    .error {
        color: red;
    }

    .success {
        color: green;
    }
</style>
</head>
<body>

<div class="form-container">
    <form action="AddAdmin.jsp" method="post">
        <h2>Create Admin</h2>

        <label>User Name :</label>
        <input type="text" name="adminName" required>

        <label>Password :</label>
        <input type="password" name="password" required>

        <label>Re-Type Password :</label>
        <input type="password" name="retypePassword" required>

        <input type="submit" value="Create Account">
    </form>

    <div class="message">
    <%
        String userName = request.getParameter("adminName");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");

        if(userName != null && password != null && retypePassword != null){
            if(password.equals(retypePassword)){
    %>
        <jsp:useBean id="admin" class="com.java.lib.model.Admin"/>
        <jsp:setProperty property="*" name="admin"/>
        <jsp:useBean id="librarydao" class="com.java.lib.dao.LibraryDaoImpl"/>
        <p class="success"><%=librarydao.createAdmin(admin) %></p>
    <%
            } else {
    %>
        <p class="error">Passwords do not match. Please try again.</p>
    <%
            }
        }
    %>
    </div>
</div>

</body>
</html>
