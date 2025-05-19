<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #006699;
            padding: 10px 20px;
            display: flex;
            align-items: center;
            gap: 20px;
            position: relative;
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
    overflow: hidden; /* Prevents hover background from overflowing */
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
    border-radius: 0; /* Prevents overlapping rounded background */
}

.dropdown-link:hover {
    background-color: #f2f9fc;
    color: #004466;
}



        a {
            text-decoration: none !important;
        }

        .header {
            padding: 60px 20px;
            text-align: center;
            background-color: #e8f4f8;
        }

        .header h1 {
            font-size: 48px;
            margin-bottom: 10px;
            color: #006699;
        }

        .header p {
            font-size: 20px;
            color: #333;
        }

        .section {
            padding: 40px 20px;
            background-color: white;
            margin: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .section h2 {
            color: #006699;
        }

        .footer {
            text-align: center;
            padding: 20px;
            background-color: #006699;
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>

<body>
    <!-- Navigation Bar -->
    <!-- Navigation Bar -->
<div class="navbar">
    <!-- Home Button aligned left -->
    <h:form>
  		<h:commandLink action="Home" styleClass="nav-button">
    		&#x1F3E0; Home
  		</h:commandLink>
	</h:form>


    <!-- Right side wrapper -->
    <div style="margin-left:auto; display:flex; gap:20px; align-items:center;">
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
</div>


    <!-- Header Section -->
    <div class="header">
        <h1>Hospital Management System</h1>
        <p>Empowering Healthcare with Efficiency, Accuracy, and Accessibility</p>
    </div>

    <!-- About Section -->
    <div class="section">
        <h2>About the System</h2>
        <p>
            Our Hospital Management System is a web-based platform designed to streamline operations
            for hospitals and clinics. It simplifies patient registration, appointment booking, doctor
            management, and medical records handling.
        </p>
    </div>

    <!-- Services Section -->
    <div class="section">
        <h2>Key Features</h2>
        <ul>
            <li>Patient Registration & Appointment Scheduling</li>
            <li>Doctor Login & Dashboard</li>
            <li>Admin Control Panel for Managing Doctors, Patients & Appointments</li>
            <li>Medical History & Prescription Records</li>
            <li>Real-Time Notifications & Alerts</li>
            <li>Secure Login System with Role-Based Access</li>
        </ul>
    </div>

    <!-- Contact Section -->
    <div class="section">
        <h2>Contact Us</h2>
        <p>Email: support@hospitalms.com</p>
        <p>Phone: +91-9876543210</p>
        <p>Address: ABC Hospital, Bhubaneswar, Odisha, India</p>
    </div>

    <!-- Footer -->
    <div class="footer">
        <p>&copy; 2025 Hospital Management System. All rights reserved.</p>
    </div>
</body>
</html>
</f:view>
