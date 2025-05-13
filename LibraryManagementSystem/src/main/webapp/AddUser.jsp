<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f4f8;
        margin: 0;
        padding: 0;
    }

    .form-container {
        background-color: white;
        width: 400px;
        margin: 80px auto;
        padding: 30px 40px;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
        border-radius: 8px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #28a745;
        color: white;
        border: none;
        padding: 12px;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        transition: 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }

    .message {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
    }

    .message.success {
        color: green;
    }

    .message.error {
        color: red;
    }
</style>
</head>
<body>
    <div class="form-container">
        <form action="AddUser.jsp" method="post">
            <h2>Create Account</h2>
            <label>User Name:</label>
            <input type="text" name="username" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Re-Type Password:</label>
            <input type="password" name="retypePassword" required>

            <input type="submit" value="Create Account">
        </form>

        <%
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String retypePassword = request.getParameter("retypePassword");

            if(userName != null && password != null && retypePassword != null){
                if(password.equals(retypePassword)){
        %>
            <jsp:useBean id="libuserBean" class="com.java.lib.model.LibUsers" />
            <jsp:setProperty property="*" name="libuserBean"/>
            <jsp:useBean id="libuserDao" class="com.java.lib.dao.LibraryDaoImpl" />
            <p class="message success">
                <%= libuserDao.createUser(libuserBean) %>
            </p>
        <%
                } else {
        %>
            <p class="message error">Passwords do not match. Please try again.</p>
        <%
                }
            }
        %>
    </div>
</body>
</html>
