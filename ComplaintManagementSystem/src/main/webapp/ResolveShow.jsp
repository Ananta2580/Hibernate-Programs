<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resolve Show</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        table {
            border-collapse: collapse;
            width: 95%;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 14px;
            text-align: center;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        thead {
            background-color: #2e7d32;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #eef2f3;
        }

        .tat-pink {
            background-color: pink !important;
        }

        .tat-red {
            background-color: red !important;
            color: white;
        }
    </style>
</head>
<body>

    <h2>Resolved Complaints</h2>

    <jsp:useBean id="resolveDao" class="com.java.cms.dao.ResolveDaoImpl"/>
    <c:set var="resolveList" value="${resolveDao.showResolve()}" />

    <table>
        <thead>
            <tr>
                <th>Resolve ID</th>
                <th>Complaint ID</th>
                <th>Complaint Date</th>
                <th>Resolve Date</th>
                <th>Resolved By</th>
                <th>Comments</th>
                <th>TAT</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resolve" items="${resolveList}">
                <c:choose>
                    <c:when test="${resolve.tat >= 7 && resolve.tat < 10}">
                        <tr class="tat-pink">
                    </c:when>
                    <c:when test="${resolve.tat >= 10}">
                        <tr class="tat-red">
                    </c:when>
                    <c:otherwise>
                        <tr>
                    </c:otherwise>
                </c:choose>
                        <td>${resolve.resolveId}</td>
                        <td>${resolve.complaintId}</td>
                        <td>${resolve.complaintDate}</td>
                        <td>${resolve.resolveDate}</td>
                        <td>${resolve.resolvedBy}</td>
                        <td>${resolve.comments}</td>
                        <td>${resolve.tat}</td>
                    </tr>
            </c:forEach>
        </tbody>
    </table><br><br>
    
    <div style="text-align: center; margin-bottom: 20px;">
    <form action="Home.jsp" method="get">
        <button type="submit" style="
            background-color: #2e7d32;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        ">
            ← Back to Home
        </button>
    </form>
</div>

</body>
</html>
