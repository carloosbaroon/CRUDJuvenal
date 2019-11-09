<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salas disponibles</title>
</head>
<body>
<h1>Salas disponibles</h1>
<s:url action="goto_programar_consulta" var="regresar"/>
 
<s:form action="goto_reservar_sala">
		<s:textfield name="consulta.id_sala" label="ID de la sala" />
		<s:submit value="Seleccionar"/>
	</s:form>

<table border="1">
	<tr>
       <td><b>ID Sala</b></td>
       <td><b>Nombre de la sala</b></td>
    </tr>

<s:iterator value="buffer_salas_disponibles" status="i">
	<tr>
		<td><s:property value="sala.id_sala"/></td>
		<td><s:property value="sala.nombre_sala"/></td>
	</tr>
</s:iterator>
</table>
<a href="${regresar}">Regresar</a>
</body>
</html>