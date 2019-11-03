<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Empleado</title>
</head>
<body>
	<h1>Alta empleado</h1>
	<s:url action="goto_consulta_empleado_jsp" var="consultar_empleados"/>
	<s:url action="goto_admin_usuarios_jsp" var="regresar"/>
	
	<a href="${consultar_empleados}">Consultar Empleados</a>
	<s:form action="validar_campos_empleado">
		<s:textfield name="empleado.id_empleado" label="No. Empleado" />
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo" />
		<s:textfield name="empleado.direccion" label="Dirección"/>
		<s:textfield name="empleado.telefono" label="Teléfono"/>
		<s:textfield name="empleado.puesto" label="Puesto"/>
		<s:textfield name="empleado.especialidad" label="Especialidad Médica"/>
		<s:textfield name="empleado.turno" label="Turno"/>
       <s:select label="Estado del Empleado" 
		headerKey="-1" headerValue="Selecciona un estado"
		list="estado"
		name="empleado.estado"/>

		<s:submit value="Enviar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>