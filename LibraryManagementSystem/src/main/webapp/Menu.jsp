<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Account Page</title>
<style>
    * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(to right, #f5f7fa, #c3cfe2);
    color: #333;
    min-height: 100vh;
}

.container {
    max-width: 800px;
    margin: 60px auto;
    background-color: #ffffff;
    padding: 40px 30px;
    border-radius: 10px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
    text-align: center;
    animation: fadeIn 0.6s ease-in-out;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(30px); }
    to { opacity: 1; transform: translateY(0); }
}

.welcome {
    font-size: 22px;
    font-weight: 600;
    margin-bottom: 30px;
}

.nav-bar {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 15px;
    margin: 30px 0;
}

.nav-bar a {
    text-decoration: none;
    background-color: #ff9800;
    color: white;
    padding: 12px 25px;
    border-radius: 8px;
    font-weight: 600;
    transition: background 0.3s, transform 0.2s;
    box-shadow: 0 3px 6px rgba(0,0,0,0.1);
}

.nav-bar a:hover,
.nav-bar a:focus {
    background-color: #fb8c00;
    transform: scale(1.05);
}

.admin-link {
    margin-top: 20px;
}

.admin-link a {
    font-size: 16px;
    color: #007bff;
    text-decoration: none;
    font-weight: 500;
}

.admin-link a:hover,
.admin-link a:focus {
    text-decoration: underline;
}

.logout-button {
    margin-top: 25px;
}

.logout-button input {
    background-color: #e53935;
    color: white;
    border: none;
    padding: 12px 24px;
    font-size: 15px;
    font-weight: 600;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.logout-button input:hover,
.logout-button input:focus {
    background-color: #c62828;
}
</style>
</head>
<body>

<div class="container">
    <%
        String user = (String) session.getAttribute("user");
        out.println("<div class='welcome'>Welcome <b>" + user + "</b></div>");
    %>

    <div class="admin-link">
        <a href="AdminLogin.jsp">Go to Admin Login</a>
    </div>

    <div class="logout-button">
        <input type="button" name="logout" value="Logout" onclick="window.location='index.html'">
    </div>

    <div class="nav-bar">
        <a href="AccountDetails.jsp">Account Details</a>
        <a href="Search.jsp">Search / Issue</a>
        <a href="Return.jsp">Return</a>
        <a href="History.jsp">History</a>
    </div>
</div>

</body>
</html>
