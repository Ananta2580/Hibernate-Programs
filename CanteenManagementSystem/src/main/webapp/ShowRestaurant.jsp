<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<f:view>
<html>
<head>
<meta charset="UTF-8">
<title>Show Restaurants</title>
</head>
<body>
<h:form>
	<h:dataTable value="#{canteenController.showRestaurant() }" var="rest" border="3">
		
		<h:column>
			<f:facet name="header">
				<h:commandLink value="RestaurantId" action="#{canteenController.sortBy('restaurantId') }"/>
			</f:facet>
			<h:outputText value="#{rest.restaurantId }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:commandLink value="Restaurant Name" action="#{canteenController.sortBy('restaurantName') }"/>
			</f:facet>
			<h:outputText value="#{rest.restaurantName }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:commandLink value="City" action="#{canteenController.sortBy('city') }"/>
			</f:facet>
			<h:outputText value="#{rest.city }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:commandLink value="Rating" action="#{canteenController.sortBy('rating') }"/>
			</f:facet>
			<h:outputText value="#{rest.rating }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:commandLink value="Flag" action="#{canteenController.sortBy('flag') }"/>
			</f:facet>
			<h:outputText value="#{rest.flag }"/>
		</h:column>
		
		<h:column>
			<f:facet name="header">
				<h:outputLabel value="Menu"/>
			</f:facet>
			<h:outputLink value="Menu.jsf">
				<f:param name="restaurantid" value="#{rest.restaurantId}" />
				Show Menu
			</h:outputLink>
		</h:column>
		
	</h:dataTable>
	
</h:form>

</body>
</html>
</f:view>