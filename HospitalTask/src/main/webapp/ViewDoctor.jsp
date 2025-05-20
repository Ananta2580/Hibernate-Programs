<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
<meta charset="UTF-8">
<title>View Doctor</title>
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

    .doctor-table {
        margin: 40px auto;
        border-collapse: collapse;
        width: 95%;
        background-color: white;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    .doctor-table th,
    .doctor-table td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    .doctor-table th {
        background-color: #3498db;
        color: white;
        font-size: 16px;
    }

    .doctor-table tr:hover {
        background-color: #f2f2f2;
    }

    .edit-link-button,
    .delete-link-button {
        display: inline-block;
        padding: 6px 12px;
        color: white;
        border-radius: 6px;
        text-decoration: none;
        font-size: 14px;
        font-weight: bold;
    }

    .edit-link-button {
        background-color: #f39c12;
    }

    .edit-link-button:hover {
        background-color: #d68910;
    }

    .delete-link-button {
        background-color: #e74c3c;
    }

    .delete-link-button:hover {
        background-color: #c0392b;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <h:form>
        <div class="navbar">
            <h:commandLink action="HomePage" styleClass="nav-button" value="Home" />
            <h:commandLink action="DoctorDashBoard" styleClass="nav-button" value="Doctor Dashboard" />
        </div>
    </h:form>

    <!-- Table -->
    <h:form>
        <h:dataTable value="#{hospitalController.showDoctor()}" var="doc" styleClass="doctor-table" border="0">

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Doctor ID" />
                </f:facet>
                <h:outputText value="#{doc.doctorId}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Doctor Name" />
                </f:facet>
                <h:outputText value="#{doc.doctorName}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Specialization" />
                </f:facet>
                <h:outputText value="#{doc.specialization}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Location" />
                </f:facet>
                <h:outputText value="#{doc.location}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Phone Number" />
                </f:facet>
                <h:outputText value="#{doc.mobileNo}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Status" />
                </f:facet>
                <h:outputText value="#{doc.isStatus}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Edit Doctor" />
                </f:facet>
                <h:outputLink value="UpdateDoctor.jsf" styleClass="edit-link-button">
                    <f:param name="doctorId" value="#{doc.doctorId}" />
                    Edit
                </h:outputLink>
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Delete Doctor" />
                </f:facet>
                <h:form>
                    <h:commandLink action="#{hospitalController.deleteDoctorAction}"
                                   styleClass="delete-link-button"
                                   onclick="return confirm('Are you sure?')">
                        <f:param name="doctorId" value="#{doc.doctorId}" />
                        Delete
                    </h:commandLink>
                </h:form>
            </h:column>

        </h:dataTable>
    </h:form>
</body>
</html>
</f:view>
