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
	<s:form action="capurar_datos_empleado">
		<s:textfield name="empleado.no_empleado" label="No de Empleado" />
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo" />
		<s:textfield name="empleado.direccion" label="Direcci�n"/>
		<s:textfield name="empleado.telefono" label="Tel�fono"/>
		<s:textfield name="empleado.puesto" label="Puesto"/>
		<s:textfield name="empleado.especialidad" label="Especialidad M�dica"/>
		<s:textfield name="empleado.turno" label="Turno"/>
       <s:select label="Estado del Empleado" 
		headerKey="-1" headerValue="Selecciona un estado"
		list="estado" 
		name="itemFruta" />

		<s:submit value="Enviar"/>
	</s:form>
	
</body>
</html>