<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            padding: 30px;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 410px;
            margin: auto;
        }
        input[type="text"], input[type="number"] {
            width: 90%;
            padding: 8px 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

	<jsp:include page="AdminMenu.jsp"></jsp:include>

    <h2 align="center">Add New Book</h2>

    <form action="AddBook.jsp" method="post">
        Name: <input type="text" name="name" required><br>
        Author: <input type="text" name="author" required><br>
        Edition: <input type="text" name="edition" required><br>
        Department: <input type="text" name="dept" required><br>
        No. of Books: <input type="number" name="noOfBooks" min="1" required><br>
        <input type="submit" value="Add Book">
    </form>
    
    <%
    String name = request.getParameter("name");

    if (name != null && !name.trim().isEmpty()) {
        String author = request.getParameter("author");
        String edition = request.getParameter("edition");
        String dept = request.getParameter("dept");
        String noBookStr = request.getParameter("noOfBooks");

        int noBook = 0;
        try {
            noBook = Integer.parseInt(noBookStr);
        } catch (NumberFormatException e) {
            out.println("<p class='error'>Invalid number format for number of books.</p>");
        }

        if (author != null && edition != null && dept != null && noBook > 0) {
%>
    <jsp:useBean id="book" class="com.java.lib.model.Books"/>
    <jsp:setProperty property="*" name="book"/>
    <jsp:useBean id="libDao" class="com.java.lib.dao.LibraryDaoImpl"/>
    <%=libDao.addBook(book) %>
<%
        } else {
%>
    <p class="error">All fields are required and number of books must be greater than 0.</p>
<%
        }
    }
%>


</body>
</html>
