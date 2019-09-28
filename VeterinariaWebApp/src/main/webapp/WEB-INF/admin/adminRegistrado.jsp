<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Empleado Registrado</h1>
	

	<label><b>Username</b></label><br>
	<s:property value="admin.username"/><br>
	<label><b>Password</b></label><br>
	<s:property value="admin.password"/><br>

</body>
</html>