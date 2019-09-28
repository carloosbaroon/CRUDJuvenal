<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Login</title>
</head>
<body>
	<s:url action="goto_login_jsp" var="regresar"/>
	<h1><s:property value="mensajeError"/></h1>
	<a href="${regresar}">Regresar</a>
	
</body>
</html>