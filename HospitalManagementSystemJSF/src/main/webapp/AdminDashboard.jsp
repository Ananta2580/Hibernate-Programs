<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    padding: 0;
    background: #f5f7fa;
  }

  .navbar {
    background-color: #004466;
    color: white;
    padding: 16px 32px;
    font-size: 20px;
    font-weight: bold;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .home-icon {
    display: flex;
    align-items: center;
    gap: 8px;
    color: white;
    text-decoration: none; /* Removes underline */
    font-size: 18px;
    transition: opacity 0.3s;
    border: none;
    background: none;
    font-weight: normal;
  }

  .home-icon:hover {
    opacity: 0.8;
    cursor: pointer;
  }

  .home-icon img {
    width: 24px;
    height: 24px;
    filter: invert(1); /* make icon white */
  }

  .dashboard-container {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 30px;
    padding: 60px;
    flex-wrap: wrap;
  }

  .dashboard-box {
    background-color: #ffffff;
    border: 2px solid #006699;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    width: 240px;
    height: 150px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 18px;
    font-weight: 600;
    color: #004466;
    text-align: center;
    transition: all 0.3s ease;
    text-decoration: none;
  }

  .dashboard-box:hover {
    background-color: #e6f2f8;
    transform: translateY(-5px);
    cursor: pointer;
  }

  .dashboard-link {
    text-decoration: none;
  }
</style>
</head>
<body>

<div class="navbar">
  <h:form>
    <h:commandLink action="Home" styleClass="home-icon">
      <img src="https://cdn-icons-png.flaticon.com/512/25/25694.png" alt="Home Icon" />
      Home
    </h:commandLink>
  </h:form>
  <span>Admin Dashboard</span>
</div>

<div class="dashboard-container">
  <h:form>
    <h:commandLink action="AddDoctor" styleClass="dashboard-link">
      <div class="dashboard-box">Add Doctor</div>
    </h:commandLink>
  </h:form>

  <h:form>
    <h:commandLink action="ViewDoctor" styleClass="dashboard-link">
      <div class="dashboard-box">View Doctors</div>
    </h:commandLink>
  </h:form>

  <h:form>
    <h:commandLink action="viewAppointments" styleClass="dashboard-link">
      <div class="dashboard-box">View Appointments</div>
    </h:commandLink>
  </h:form>
</div>

</body>
</html>
</f:view>
