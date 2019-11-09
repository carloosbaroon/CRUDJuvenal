<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>users/finConsultaUsuario</title>
</head>

<body>
<h2><p>Consulta general exitosa</p></h2>
<table border = "1">
<tr >
	<th>ID</th>

    <th>Nombre</th>

    <th>Categoria</th>
    <th>Raza</th>

    <th>Edad</th>
     <th>OwnerID</th>
     <th>Cambio</th>

</tr>
<s:iterator value="pacientes" status="i">
<tr>
	
	<td>
<s:property value="id"></s:property>
	</td>

	<td>
<s:property value="name"></s:property>
	</td>
	<td>
<s:property value="categoria"></s:property>
	</td>
	<td>
<s:property value="raza"></s:property>
	</td>
	<td>
<s:property value="edad"></s:property>
   </td>
   <td>
<s:property value="owner.id"></s:property>
   </td>
   <td>
<s:url action="modificarPaciente1" var="modPaciente"> <s:param name="owner.id" value="%{owner.id}" /></s:url>
<p><a href="${modPaciente}">Modificar Paciente</a></p>	
   </td>
<br>
</tr>
</s:iterator>
</table>

</body>
</html>