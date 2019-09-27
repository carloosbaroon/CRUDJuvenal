<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listar Empleados</h1>
<s:iterator value="buffer_empleados" status="i">
	<s:property value="%{#i.index+1}"></s:property>
	<s:property value="no_empleado"></s:property>
	<s:property value="nombre_completo"></s:property>
	<s:property value="direccion"></s:property>
	<s:property value="telefono"></s:property>
	<s:property value="puesto"></s:property>
	<s:property value="especialidad"></s:property>
	<s:property value="turno"></s:property>
	<s:property value="estado"></s:property>
<br>
</s:iterator>
</body>
</html>