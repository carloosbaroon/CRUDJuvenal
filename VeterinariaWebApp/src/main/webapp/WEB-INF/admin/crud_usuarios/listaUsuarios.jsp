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

<table border="1">
	<tr>
       <!-- <td><b>Auto ID</b></td> -->
       <td><b>UsuarioID</b></td>
       <td><b>Password</b></td>
       <td><b>Confirmar Password</b></td>
       <td><b>FK empleado</b></td>
       <td><b>Grupo</b></td>
       <td><b>Estado</b></td>
    </tr>
	<s:iterator value="buffer_usuarios" status="i">
		<!-- <s:property value="%{#i.index+1}"></s:property> -->
		<tr>
			<td><s:property value="usuarioID"/></td>
			<td><s:property value="password"/></td>
			<td><s:property value="confirmar_password"/></td>
			<td><s:property value="id_empleado_FK"/></td>
			<td><s:property value="grupo"/></td>
			<td><s:property value="estado"/></td>
		</tr>
	</s:iterator>
</table>

</body>
</html>