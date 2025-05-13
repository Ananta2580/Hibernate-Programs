<%@page import="com.java.lib.model.TranBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f7fa;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 800px;
        margin: auto;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #f4f4f4;
        color: #333;
    }

    td input[type="checkbox"] {
        width: 20px;
        height: 20px;
    }

    input[type="submit"] {
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #2980b9;
    }

    .message {
        font-size: 16px;
        color: #2e8b57;
        padding: 10px 0;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }
</style>
</head>
<body>

<jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl"/>
<%
    String user = (String)session.getAttribute("user");
    List<TranBook> bookList = libraryDao.accountDetails(user);
%>

<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2>Account Details - Books Issued</h2>
    <form action="ReturnNext.jsp">
        <table>
            <thead>
                <tr>
                    <th>Book Id</th>
                    <th>User Name</th>
                    <th>Issued On</th>
                    <th>Return</th>
                </tr>
            </thead>
            <%
                for(TranBook tranBook : bookList){
            %>
            <tbody>
                <tr>
                    <td><%=tranBook.getBookId() %></td>
                    <td><%=tranBook.getUsername() %></td>
                    <td><%=tranBook.getDate() %></td>
                    <td>
                        <input type="checkbox" name="bookId" value="<%=tranBook.getBookId() %>">
                    </td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <div style="text-align: center;">
            <input type="submit" value="Return Book(s)" />
        </div>
    </form>
</div>

</body>
</html>
