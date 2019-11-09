<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de salas</title>
</head>
<body>
<h1>Lista de salas</h1>
<s:url action="goto_admin_salas_jsp" var="regresar"/>
 
<s:form action="goto_detalles_sala">
		<s:textfield name="sala.id_sala" label="ID de la sala" />
		<s:submit value="Buscar"/>
	</s:form>

<table border="1">
	<tr>
       <td><b>ID Sala</b></td>
       <td><b>Nombre de la sala</b></td>
       <td><b>Estado de la sala</b></td>
    </tr>

<s:iterator value="buffer_salas" status="i">
	<tr>
		<td><s:property value="id_sala"/></td>
		<td><s:property value="nombre_sala"/></td>
		<td><s:property value="estado_sala"/></td>
	</tr>
</s:iterator>
</table>
<a href="${regresar}">Regresar</a>
</body>
</html>