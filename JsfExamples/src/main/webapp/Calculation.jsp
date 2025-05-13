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
		Calculation Form <br>
		First No:
		<h:inputText id="firstNo" value="#{calc.firstNo }"/><br><br>
		Second No:
		<h:inputText id="secondNo" value="#{calc.secondNo }"/><br><br>
		Result is:
		<h:outputText value="#{calc.result }"/><br><br>
		<h:commandButton actionListener="#{calc.addition }" value="Add"/>
	</h:form>
</body>
</f:view>
</html>