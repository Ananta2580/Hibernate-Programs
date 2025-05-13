<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Complaint Management System</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            text-align: center;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        .nav-links {
            list-style-type: none;
            padding: 0;
        }

        .nav-links li {
            display: inline-block;
            margin-right: 20px;
        }

        .nav-links a {
            text-decoration: none;
            color: #2e7d32;
            font-size: 18px;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 5px;
            border: 2px solid #2e7d32;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .nav-links a:hover {
            background-color: #2e7d32;
            color: white;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Complaint Management System</h1>
        <ul class="nav-links">
            <li><a href="AddComplaint.jsp">Add Complaint</a></li>
            <li><a href="ShowComplaint.jsp">Show Complaint</a></li>
            <li><a href="SearchComplaint.jsp">Search Complaint</a></li>
            <li><a href="ResolveShow.jsp">Resolve Show</a></li>
        </ul>
    </div>

</body>
</html>
