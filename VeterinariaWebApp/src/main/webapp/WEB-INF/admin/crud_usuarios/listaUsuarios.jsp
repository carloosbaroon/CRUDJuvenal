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
<s:url action="goto_alta_usuario_jsp" var="regresar"/>

<table border="1">
	<tr>
       <!-- <td><b>Auto ID</b></td> -->
       <td><b>UsuarioID</b></td>
       <td><b>Password</b></td>
       <td><b>FK empleado</b></td>
       <td><b>Grupo</b></td>
       <td><b>Estado</b></td>
    </tr>
	<s:iterator value="buffer_usuarios" status="i">
		<tr>
			<td><s:property value="usuarioID"/></td>
			<td><s:property value="password"/></td>
			<td><s:property value="id_empleado_FK"/></td>
			<td><s:property value="grupo"/></td>
			<td><s:property value="estado"/></td>
		</tr>
	</s:iterator>
</table>
<a href="${regresar}">Regresar</a>
</body>
</html>