<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:url action="welcome" var="ir_login"/>
	<h1>Login</h1>
	<s:form action="validar_usuario">
	    <s:textfield label="username" name="usuario.usuarioID"/>
	    <s:password label="password" name="usuario.password" />
    	<s:submit/>
	</s:form>
	<a href="${ir_login}">Regresar</a>
</body>
</html>