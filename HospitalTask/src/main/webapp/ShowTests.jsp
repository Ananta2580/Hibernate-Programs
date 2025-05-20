<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Tests</title>

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
            <a class="nav-link d-inline" href="AddMedicalHistory.jsf">Add MedicalHistory</a>
            <a class="nav-link d-inline" href="ShowTests.jsf">Search</a>
            <a class="nav-link d-inline" href="MedicationHistory.jsf">Medication History</a>
        </div>
    </div>

    <div class="container">
        <h:form>
            <div class="form-group row">
                <label for="patientId" class="col-sm-2 col-form-label">Patient Id:</label>
                <div class="col-sm-6">
                    <h:inputText id="patientId" value="#{medHistory.patientId}" styleClass="form-control"/>
                </div>
                <div class="col-sm-2">
                    <h:commandButton value="Show" action="#{hospitalController.showTests(medHistory.patientId)}" styleClass="btn btn-custom"/>
                </div>
            </div>

<c:if test="${not empty medHistory.patientId}">
	<c:forEach items="#{hospitalController.showTests(medHistory.patientId) }" var="med">
	
		<div class="doctor-card">
        <p><strong>Medicine ID:</strong> <h:outputText value="#{med.medId}" /></p>
        <p><strong>Patient Id:</strong> <h:outputText value="#{med.patientId}" /></p>
        <p><strong>Medicines:</strong> <h:outputText value="#{med.medicines}" /></p>
        <p><strong>Tests:</strong> <h:outputText value="#{med.tests}" /></p>

        <div class="d-flex justify-content-between">
            <h:outputLink value="UpdateDoctor.jsf" styleClass="btn btn-custom">
                <f:param name="doctorId" value="#{doc.doctorId}" />
                Edit
            </h:outputLink>

            <h:form>
                <h:commandLink action="#{hospitalController.deleteDoctorAction}" onclick="return confirm('Are you sure you want to delete?')" styleClass="btn btn-delete">
                    <f:param name="doctorId" value="#{doc.doctorId}" />
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
