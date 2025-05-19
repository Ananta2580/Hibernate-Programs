<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
  <meta charset="UTF-8">
  <title>View Doctors</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f7fa;
    }

    .navbar {
      background-color: #004466;
      color: white;
      padding: 16px 32px;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    .nav-link {
      color: white;
      font-size: 18px;
      text-decoration: none;
      transition: opacity 0.3s;
    }

    .nav-link:hover {
      opacity: 0.8;
      cursor: pointer;
    }

    .content {
      padding: 40px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
      background-color: white;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
      border-radius: 8px;
      overflow: hidden;
    }

    th, td {
      padding: 14px 20px;
      text-align: left;
      border-bottom: 1px solid #ddd;
      color: #333;
    }

    th {
      background-color: #006699;
      color: white;
      font-weight: bold;
    }

    tr:hover {
      background-color: #e6f2f8;
    }

    .edit-link-button, .delete-link-button {
      text-decoration: none;
      padding: 8px 14px;
      border-radius: 6px;
      font-size: 14px;
      font-weight: 500;
      display: inline-block;
      text-align: center;
    }

    .edit-link-button {
      background-color: #28a745;
      color: white;
    }

    .delete-link-button {
      background-color: #dc3545;
      color: white;
    }

    .edit-link-button:hover {
      background-color: #218838;
    }

    .delete-link-button:hover {
      background-color: #c82333;
    }
  </style>
</head>
<body>

<div class="navbar">
  <span>Doctor List</span>
  <h:form>
    <h:commandLink action="AdminDashboard" styleClass="nav-link">
      Admin Dashboard
    </h:commandLink>
  </h:form>
</div>

<div class="content">
  <h:form>
    <h:dataTable value="#{hospitalController.viewDoctor()}" var="doc" styleClass="doctor-table">
      
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
          <h:outputText value="Phone Number" />
        </f:facet>
        <h:outputText value="#{doc.doctorPhone}" />
      </h:column>
      
      <h:column>
        <f:facet name="header">
          <h:outputText value="Edit Doctor" />
        </f:facet>
        <h:outputLink value="UpdateDoctor.jsf" styleClass="edit-link-button" >
          <f:param name="doctorId" value="#{doc.doctorId}" />
          Edit
        </h:outputLink>
      </h:column>
      
      <h:column>
  <f:facet name="header">
    <h:outputText value="Delete Doctor" />
  </f:facet>
  <h:form>
    <h:commandLink action="#{hospitalController.deleteDoctorAction}" styleClass="delete-link-button" onclick="return confirm('Are you sure?')">
      <f:param name="doctorId" value="#{doc.doctorId}" />
      Delete
    </h:commandLink>
  </h:form>
</h:column>

    
    </h:dataTable>
  </h:form>
</div>

</body>
</html>
</f:view>
