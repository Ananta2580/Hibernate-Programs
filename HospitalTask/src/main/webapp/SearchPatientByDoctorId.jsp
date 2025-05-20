<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search By Doctor Id</title>

    <!-- Optional Bootstrap Reset for Layout -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>

    <style>
        body {
            background-color: #f2f2f2;
            padding: 20px;
            font-family: Arial, sans-serif;
        }

        .navbar-custom {
            background-color: #343a40;
            padding: 10px 20px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .navbar-custom .navbar-brand,
        .navbar-custom .nav-link {
            color: #ffffff;
            margin-right: 15px;
            text-decoration: none;
        }

        .navbar-custom .nav-link:hover {
            color: #ffc107;
        }

        .doctor-card {
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
            background-color: #ffffff;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.05);
        }

        .btn-custom {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 5px;
        }

        .btn-custom:hover {
            background-color: #218838;
        }

        .btn-delete {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 5px;
        }

        .btn-delete:hover {
            background-color: #c82333;
        }

        label {
            font-weight: bold;
        }
    </style>
</head>
<body>

    <!-- Custom Navbar -->
    <div class="navbar-custom d-flex align-items-center justify-content-between">
        <div>
            <a class="navbar-brand" href="#">Hospital System</a>
        </div>
        <div>
            <a class="nav-link d-inline" href="Home.jsf">Home</a>
            <a class="nav-link d-inline" href="AddPatient.jsf">Add Patient</a>
            <a class="nav-link d-inline" href="SearchById.jsf">Search</a>
            <a class="nav-link d-inline" href="PatientDashboard.jsf">Patient Dashboard</a>
        </div>
    </div>

    <div class="container">
        <h:form>
            <div class="form-group row">
                <label for="doctorId" class="col-sm-2 col-form-label">Doctor Id:</label>
                <div class="col-sm-6">
                    <h:inputText id="doctorId" value="#{patient.doctorId}" styleClass="form-control"/>
                </div>
                <div class="col-sm-2">
                    <h:commandButton value="Show" styleClass="btn btn-custom"/>
                </div>
            </div>

<c:if test="${not empty patient.doctorId}">
    <c:forEach items="#{hospitalController.searchByDocId(patient.doctorId) }" var="p">
    	<div class="doctor-card">
        <p><strong>Patient ID:</strong> <h:outputText value="#{p.patientId}" /></p>
        <p><strong>Name:</strong> <h:outputText value="#{p.patientName}" /></p>
        <p><strong>DoctorId:</strong> <h:outputText value="#{p.doctorId}" /></p>
        <p><strong>DOB:</strong> <h:outputText value="#{p.dateOfBirth}" /></p>

        <div class="d-flex justify-content-between">
            <h:outputLink value="UpdateDoctor.jsf" styleClass="btn btn-custom">
                <f:param name="doctorId" value="#{patient.patientId}" />
                Edit
            </h:outputLink>

            <h:form>
                <h:commandLink action="#{hospitalController.deleteDoctorAction}" onclick="return confirm('Are you sure you want to delete?')" styleClass="btn btn-delete">
                    <f:param name="doctorId" value="#{patient.patientId}" />
                    Delete
                </h:commandLink>
            </h:form>
        </div>
    </div>
    </c:forEach>
</c:if>

        </h:form>
    </div>

</body>
</html>
</f:view>
