<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Login</title>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    /* softer gradient background */
    background: linear-gradient(135deg, #fdfdfd, #f5f7fa);
    margin: 0;
    padding: 0;
    height: 100vh;
  }

  /* Navbar styles */
  .navbar {
      background-color: #006699;
      padding: 10px 20px;
      display: flex;
      align-items: center;
      gap: 20px;
      position: relative;
      color: white;
  }

  .nav-button, .dropdown-btn {
      background-color: transparent;
      border: none;
      color: #ffffff;
      padding: 14px 16px;
      font-weight: bold;
      font-size: 16px;
      cursor: pointer;
      text-decoration: none;
  }

  .nav-button:hover, .dropdown-btn:hover {
      background-color: #0099cc;
  }

  .dropdown {
      position: relative;
  }

  .dropdown-menu {
      display: none;
      position: absolute;
      top: 100%;
      left: 0;
      background-color: #ffffff;
      min-width: 180px;
      border-radius: 8px;
      box-shadow: 0 6px 12px rgba(0,0,0,0.15);
      z-index: 1000;
      padding: 4px 0;
      overflow: hidden;
  }

  .dropdown:hover .dropdown-menu {
      display: block;
  }

  .dropdown-link {
      display: block;
      width: 100%;
      padding: 10px 20px;
      background-color: transparent;
      border: none;
      text-align: left;
      color: #006699;
      font-size: 16px;
      font-weight: normal;
      text-decoration: none;
      cursor: pointer;
      transition: background-color 0.2s ease, color 0.2s ease;
  }

  .dropdown-link:hover {
      background-color: #f2f9fc;
      color: #004466;
  }

  /* Login container styles */
  .login-container {
    background-color: #ffffff;
    padding: 40px 45px;
    border-radius: 12px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.12);
    width: 360px;
    text-align: center;
    margin: 80px auto 0 auto; /* top margin for navbar space, center horizontally */
  }

  h2 {
    color: #006699;
    margin-bottom: 30px;
    font-weight: 700;
    font-size: 28px;
  }

  h:form {
    display: flex;
    flex-direction: column;
    text-align: left;
  }

  h:outputLabel {
    font-weight: 600;
    margin-bottom: 8px;
    color: #004466;
    display: block;
    font-size: 14px;
  }

  input[type="text"], input[type="password"] {
    padding: 12px 14px;
    margin-bottom: 22px;
    border: 2px solid #ccc;
    border-radius: 8px;
    font-size: 16px;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
    width: 100%;
    box-sizing: border-box;
  }

  input[type="text"]:focus, input[type="password"]:focus {
    border-color: #006699;
    box-shadow: 0 0 8px #006699;
    outline: none;
  }

  .login-button {
    background-color: #006699;
    color: white;
    border: none;
    padding: 14px;
    font-size: 18px;
    font-weight: 700;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
  }

  .login-button:hover {
    background-color: #004466;
  }

  .signup-link {
    margin-top: 20px;
    font-size: 14px;
    color: #555;
    text-align: center;
  }

  .signup-link h\\:commandLink {
    color: #006699;
    text-decoration: none;
    font-weight: 600;
    cursor: pointer;
    margin-left: 6px;
    font-size: 14px;
  }

  .signup-link h\\:commandLink:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>

<!-- Navigation Bar -->
<div class="navbar">
    <!-- Home Button -->
    <h:form>
        <h:commandLink action="Home" styleClass="nav-button">
            &#x1F3E0; Home
        </h:commandLink>
    </h:form>

    <div style="flex-grow:1;"></div>

    <!-- User Dropdown -->
    <div class="dropdown">
        <button class="dropdown-btn">User</button>
        <div class="dropdown-menu">
            <h:form styleClass="dropdown-form">
                <h:commandLink action="Doctor" styleClass="dropdown-link" value="Doctor" />
            </h:form>
            <h:form styleClass="dropdown-form">
                <h:commandLink action="Patient" styleClass="dropdown-link" value="Patient" />
            </h:form>
        </div>
    </div>

    <!-- Admin Button -->
    <h:form>
        <h:commandLink value="Admin" action="Admin" styleClass="nav-button" />
    </h:form>
</div>

<!-- Login Form -->
<div class="login-container">
  <h2>Patient Login</h2>
  <h:form>
    <h:outputLabel value="Enter User name:" for="userName"/>
    <h:inputText id="userName" styleClass="input-field"/>

    <h:outputLabel value="Enter Password:" for="password"/>
    <h:inputSecret id="password" styleClass="input-field"/>

    <h:commandButton value="Login" styleClass="login-button"/>

    <div class="signup-link">
      Don't have an account?
      <h:commandLink value="Create here"/>
    </div>
  </h:form>
</div>

</body>
</html>
</f:view>
