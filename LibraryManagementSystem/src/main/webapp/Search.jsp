<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Books</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f7fa;
        margin: 0;
        padding: 40px;
    }

    .container {
        max-width: 600px;
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

    form {
        margin-top: 20px;
    }

    label {
        font-size: 16px;
        color: #333;
    }

    input[type="radio"] {
        margin: 10px 0;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-top: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    input[type="submit"] {
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
        margin-top: 20px;
    }

    input[type="submit"]:hover {
        background-color: #2980b9;
    }

    .radio-group {
        margin-top: 15px;
    }

    .radio-group input {
        margin-right: 10px;
    }

    .message {
        font-size: 16px;
        color: #e74c3c;
        padding: 10px 0;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }
</style>
</head>
<body>

<jsp:include page="Menu.jsp"/>

<div class="container">
    <h2>Search for Books</h2>

    <form action="SearchPrint.jsp">
        <label>Select Search Criteria:</label>
        <div class="radio-group">
            <input type="radio" name="searchtype" value="id"> By Book Id <br>
            <input type="radio" name="searchtype" value="dept"> By Department <br>
            <input type="radio" name="searchtype" value="bookname"> By Book Name <br>
            <input type="radio" name="searchtype" value="authorname"> By Author Name <br>
            <input type="radio" name="searchtype" value="all"> All Books <br>
        </div>

        <label>Insert Search Value:</label>
        <input type="text" name="searchvalue" size="10"><br><br>

        <input type="submit" value="Search" id="button-1"/>
    </form>
</div>

</body>
</html>
