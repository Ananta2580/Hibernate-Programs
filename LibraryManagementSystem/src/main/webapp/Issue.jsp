<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Books</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f7fa;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 700px;
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

    .message {
        font-size: 16px;
        color: #2e8b57;
        padding: 10px 0;
        border-bottom: 1px solid #ddd;
    }
</style>
</head>
<body>

<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2>Book Issue Status</h2>
    <jsp:useBean id="libraryDao" class="com.java.lib.dao.LibraryDaoImpl"/>
    <%
        String []bookList = request.getParameterValues("bookid");
        String user = (String)session.getAttribute("user");
        if (bookList != null && user != null) {
            for(String s : bookList){
                int bid = Integer.parseInt(s);
    %>
                <div class="message">
                    <%= libraryDao.issueBook(user, bid) %>
                </div>
    <%
            }
        } else {
    %>
            <div class="message" style="color:red;">No books selected or session expired.</div>
    <%
        }
    %>
</div>

</body>
</html>
