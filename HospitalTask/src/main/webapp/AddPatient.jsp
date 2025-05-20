<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Patient</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
        }

        .navbar {
            background-color: #2c3e50;
            padding: 15px 30px;
            display: flex;
            gap: 20px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
        }

        .nav-button {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            text-decoration: none;
            font-size: 16px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .nav-button:hover {
            background-color: #1d6fa5;
        }

        .form-container {
            max-width: 600px;
            margin: 40px auto;
            padding: 30px;
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #2c3e50;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus {
            border-color: #3498db;
            outline: none;
        }

        .submit-button {
            display: block;
            width: 100%;
            background-color: #27ae60;
            color: white;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-button:hover {
            background-color: #1e8449;
        }
    </style>
</head>
<body>
    <h:form>
        <!-- Navbar -->
        <div class="navbar">
            <h:commandLink action="Home" styleClass="nav-button" value="Home" />
            <h:commandLink action="PatientDashboard" styleClass="nav-button" value="Patient Dashboard" />
        </div>

        <!-- Form Content -->
        <div class="form-container">
            <h2>Add Patient</h2>

            <div class="form-group">
                <h:outputLabel for="patientName" value="Patient Name" />
                <h:inputText id="patientName" value="#{patient.patientName }" />
            </div>

            <div class="form-group">
                <h:outputLabel for="doctorId" value="Doctor Id" />
                <h:inputText id="doctorId" value="#{patient.doctorId }" />
            </div>

            <div class="form-group">
    			<h:outputLabel for="dateOfBirth" value="DOB" />
    			<h:inputText id="dateOfBirth" value="#{patient.dateOfBirth}">
    				<f:converter converterId="sqlDateConverter" />
				</h:inputText>

			</div>

            <h:commandButton value="Add Doctor"
                             action="#{hospitalController.addPatient(patient)}"
                             styleClass="submit-button" />
        </div>
    </h:form>
</body>
</html>
</f:view>
