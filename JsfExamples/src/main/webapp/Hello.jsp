<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<html>
<f:view>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
	<h:form>
	<h:outputText value="Hello Everyone!"/><br><br>
	Program code result is:
	<h:outputText value="#{demo.sayHello() }"/>
	</h:form>
</body>
</f:view>
</html>