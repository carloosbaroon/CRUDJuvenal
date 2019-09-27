<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listar Usuarios</h1>
<s:iterator value="buffer_usuarios" status="i">
	<s:property value="%{#i.index+1}"></s:property>
	<s:property value="usuarioID"></s:property>
	<s:property value="password"></s:property>
	<s:property value="confirmar_password"></s:property>
	<s:property value="id_empleado_FK"></s:property>
	<s:property value="grupo"></s:property>
	<s:property value="estado"></s:property>
	<br>
</s:iterator>
</body>
</html>