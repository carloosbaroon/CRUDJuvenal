<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarIDPaciente.jsp</title>
</head>

<body>

<table border="1">
	<tr>
       <td><b>ID</b></td>
       <td><b>Nombre</b></td>
       <td><b>Categoria</b></td>
       <td><b>Raza</b></td>
       <td><b>Edad</b></td>
       <td><b>ID Dueño</b></td>
       <td><b>Modificar</b></td>
       <td><b>Baja</b></td>
    </tr>

<s:iterator value="buffer_pacientes" status="i">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="categoria"/></td>
		<td><s:property value="raza"/></td>
		<td><s:property value="edad"/></td>
		<td><s:property value="idOwner"/></td>
		<td>
			<s:url action="mostrar_detalle_editar_paciente" var="url_modificar_paciente">
       			<s:param name = "qs_paciente_id">${id}</s:param>
			</s:url>
			<a href="${url_modificar_paciente}">Editar</a>
		</td>
		<td>
			<s:url action="dar_baja_paciente" var="url_baja_paciente">
       			<s:param name = "qs_paciente_id">${id}</s:param>
			</s:url>		
			<a href="${url_baja_paciente}">Baja</a>
		</td>
	</tr>
</s:iterator>
</table>
<a href="${regresar}">Regresar</a>

</body>
</html>












</body>
</html>