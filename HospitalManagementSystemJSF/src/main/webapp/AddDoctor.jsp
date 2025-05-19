<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
<meta charset="UTF-8">
<title>Add Doctor</title>
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
    justify-content: space-between;
    align-items: center;
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

  .form-container {
    max-width: 500px;
    margin: 60px auto;
    padding: 40px;
    background-color: white;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
  }

  .form-container h:outputLabel {
    display: block;
    margin-top: 20px;
    margin-bottom: 6px;
    font-weight: bold;
    color: #004466;
  }

  .form-container input[type="text"] {
    width: 100%;
    padding: 12px;
    border-radius: 8px;
    border: 1px solid #ccc;
    font-size: 16px;
    box-sizing: border-box;
  }

  .form-container input[type="text"]:focus {
    border-color: #006699;
    outline: none;
    box-shadow: 0 0 5px rgba(0,102,153,0.5);
  }

  .form-container .submit-button {
    margin-top: 30px;
    padding: 14px;
    width: 100%;
    background-color: #006699;
    color: white;
    font-weight: bold;
    font-size: 16px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

  .form-container .submit-button:hover {
    background-color: #004466;
  }
</style>
</head>
<body>

<div class="navbar">
  <span>Add Doctor</span>
  <h:form>
    <h:commandLink action="AdminDashboard" styleClass="nav-link">Admin Dashboard</h:commandLink>
  </h:form>
</div>

<div class="form-container">
  <h:form>
    <h:outputLabel for="doctorName" value="Doctor Name" />
    <h:inputText id="doctorName" value="#{doctor.doctorName}" />

    <h:outputLabel for="specialization" value="Specialization" />
    <h:inputText id="specialization" value="#{doctor.specialization}" />

    <h:outputLabel for="doctorPhone" value="Phone No" />
    <h:inputText id="doctorPhone" value="#{doctor.doctorPhone}" />

    <h:commandButton value="Add Doctor" action="#{hospitalController.addDoctor(doctor)}"
                     styleClass="submit-button" />
  </h:form>
</div>

</body>
</html>
</f:view>
