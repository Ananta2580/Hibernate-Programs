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
		First Name:
		<h:inputText id="firstName" value="#{name.firstName }"/><br><br>
		Last Name:
		<h:inputText id="lastName" value="#{name.lastName }"/><br><br>
		Result is:
		<h:outputText value="#{name.fullName }"/><br><br>
		<h:commandButton actionListener="#{name.result }" value="Show"/>
	</h:form>
</body>
</f:view>
</html>