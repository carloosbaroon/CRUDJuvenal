<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<s:form action="validar_usuario">
	    <s:textfield key="username"/>
	    <s:password key="password" />
    	<s:submit/>
	</s:form>
</body>
</html>