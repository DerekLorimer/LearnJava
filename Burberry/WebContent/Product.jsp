<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Testing</title>
</head>
<body>

Testing Dynamic
<h:form>

</h:form>


<f:view>

MyBean and SecondBean added....

<br>

<h:outputText value = "#{LibraryBusiness.myBean}" />

<br>

<h:outputText value = "#{LibraryBusiness.secondBean}" />

<br>



<h:dataTable value="#{LibraryBusiness.library}" var="book">
 <h:column>
    					<f:facet name="header">Book</f:facet>
    					<h:outputText value="#{book}"/>
    				
    			</h:column>

</h:dataTable>

<h:dataTable value="#{LibraryBusiness.person}" var="p">
 <h:column>
    					<f:facet name="header">Name</f:facet>
    					<h:outputText value="#{p.name}"/>
    				
    			</h:column>

</h:dataTable>


</f:view>
</body>
</html>