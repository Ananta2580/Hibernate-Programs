<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
        }

        .navbar {
            background-color: #1e1e2f;
            padding: 20px;
            display: flex;
            justify-content: center;
            gap: 20px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        }

        .nav-button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border: none;
            border-radius: 10px;
            transition: all 0.3s ease;
            cursor: pointer;
            min-width: 180px;
        }

        .nav-button:hover {
            background-color: #45a049;
            transform: translateY(-2px);
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        .content {
            padding: 40px;
            text-align: center;
        }

        .content h2 {
            color: #333;
        }

        .content p {
            color: #666;
        }
    </style>
</head>
<body>
    <h:form>
        <div class="navbar">
            <h:commandLink action="DoctorDashBoard" styleClass="nav-button" value="Doctor Dashboard" />
            <h:commandLink action="PatientDashboard" styleClass="nav-button" value="Patient Dashboard" />
            <h:commandLink action="MedicationHistory" styleClass="nav-button" value="Medication History" />
        </div>
    </h:form>

    <div class="content">
        <h2>Welcome to the Hospital Management System</h2>
        <p>Use the above dashboard to navigate through the system.</p>
    </div>
</body>
</html>
</f:view>
