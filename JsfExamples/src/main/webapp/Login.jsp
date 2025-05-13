<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<f:view>
<body>
	<h:form>
		<h:outputLabel value="User Name"/>
		<h:inputText id="userName" value="#{login.userName }"/>
		<h:outputLabel value="Password"/>
		<h:inputSecret id="passCode" value="#{login.passCode }"/>
		<h:commandButton action="#{loginDao.validateMe(login.userName, login.passCode) }" value="Login"/>
	</h:form>
</body>
</f:view>
</html>