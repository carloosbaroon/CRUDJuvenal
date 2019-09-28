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
<s:url action="goto_alta_empleado_jsp" var="regresar"/>

<table border="1">
	<tr>
       <td><b>EmpleadoID</b></td>
       <td><b>Nombre</b></td>
       <td><b>Direccion</b></td>
       <td><b>Telefono</b></td>
       <td><b>Puesto</b></td>
       <td><b>Especialidad</b></td>
       <td><b>Turno</b></td>
       <td><b>Estado</b></td>
    </tr>

<s:iterator value="buffer_empleados" status="i">
	<tr>
		<td><s:property value="%{#i.index+1}"></s:property></td>
		<!-- <td><s:property value="no_empleado"/></td> -->
		<td><s:property value="nombre_completo"/></td>
		<td><s:property value="direccion"/></td>
		<td><s:property value="telefono"/></td>
		<td><s:property value="puesto"/></td>
		<td><s:property value="especialidad"/></td>
		<td><s:property value="turno"/></td>
		<td><s:property value="estado"/></td>
	</tr>
</s:iterator>
</table>
<a href="${regresar}">Regresar</a>
</body>
</html>