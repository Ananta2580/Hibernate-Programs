<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approve/Deny Leave</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #eef1f5;
        padding: 40px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    form {
        max-width: 500px;
        margin: auto;
        background: #fff;
        padding: 20px;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #333;
    }

    input[type="text"],
    input[type="number"],
    select,
    textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 12px 20px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<h2>Approve or Deny Leave Request</h2>

<form action="ApproveLeaveAction.jsp" method="post">
    <label for="managerId">Manager ID:</label>
    <input type="number" id="managerId" name="managerId" required value="${param.empId}">

    <label for="leaveId">Leave ID:</label>
    <input type="number" id="leaveId" name="leaveId" required value="${param.leaveId}">

    <label for="isAccept">Do you want to accept the leave request?</label>
    <select id="isAccept" name="isAccept" required>
        <option value="true">Accept</option>
        <option value="false">Reject</option>
    </select>

    <label for="managerComments">Manager Comments:</label>
    <textarea id="managerComments" name="managerComments" rows="4" required></textarea>

    <button type="submit">Submit</button>
</form>

</body>
</html>
