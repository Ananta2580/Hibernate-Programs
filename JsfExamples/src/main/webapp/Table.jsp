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

	<h:dataTable value="#{empDao.showEmploy() }" var="e" border="3">
		<h:column>
		<f:facet name="header">
			<h:outputText value="Employ No"/>
		</f:facet>
		<h:outputText value="#{e.empno }"/>
		</h:column>
		
		<h:column>
		<f:facet name="header">
			<h:outputText value="Name"/>
		</f:facet>
		<h:outputText value="#{e.name }"/>
		</h:column>
		
		<h:column>
		<f:facet name="header">
			<h:outputText value="Department"/>
		</f:facet>
		<h:outputText value="#{e.dept }"/>
		</h:column>
		
		<h:column>
		<f:facet name="header">
			<h:outputText value="Designation"/>
		</f:facet>
		<h:outputText value="#{e.desig }"/>
		</h:column>
		
		<h:column>
		<f:facet name="header">
			<h:outputText value="Basic"/>
		</f:facet>
		<h:outputText value="#{e.basic }"/>
		</h:column>
		
		
	</h:dataTable>

</body>
</f:view>
</html>