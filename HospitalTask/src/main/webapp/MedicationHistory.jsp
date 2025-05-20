<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
        }

        .navbar {
            background-color: #1e1e2f;
            padding: 15px 30px;
            display: flex;
            justify-content: flex-end;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
        }

        .nav-button {
            background-color: #007bff;
            color: white;
            padding: 10px 24px;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            border: none;
            cursor: pointer;
            transition: 0.3s;
        }

        .nav-button:hover {
            background-color: #0056b3;
        }

        .dashboard {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 30px;
            padding: 40px;
            max-width: 1000px;
            margin: auto;
        }

        .box-button {
            background-color: #ffffff;
            border: 2px solid #4CAF50;
            color: #4CAF50;
            padding: 30px 20px;
            text-align: center;
            font-size: 18px;
            border-radius: 12px;
            transition: all 0.3s ease;
            cursor: pointer;
            font-weight: bold;
        }

        .box-button:hover {
            background-color: #4CAF50;
            color: white;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            transform: translateY(-3px);
        }

        .title {
            text-align: center;
            padding-top: 30px;
            font-size: 28px;
            color: #333;
        }
    </style>
</head>
<body>
    <h:form>
        <!-- Navbar with Home Button -->
        <div class="navbar">
            <h:commandLink action="Home" styleClass="nav-button" value="Home" />
        </div>

        <!-- Page Title -->
        <div class="title">Medication History</div>

        <!-- Box Buttons Area -->
        <div class="dashboard">
            <h:commandLink action="ShowMedicalHistory" styleClass="box-button" value="Medical History" />
            <h:commandLink action="AddMedicalHistory" styleClass="box-button" value="Add Medical History" />
            <h:commandLink action="ShowTests" styleClass="box-button" value="Show Tests" />
        </div>
    </h:form>
</body>
</html>
</f:view>
