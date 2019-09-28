<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/editarUsuario.jsp</title>
</head>

<body>
<s:form action="finalOwner">
	<s:textfield name="owner.id" label="ID" />
    <s:textfield name="owner.nombre" label="Nombre" />
    <s:textfield name="owner.direccion" label="Direccion" />
    <s:textfield name="owner.telefono" label="Telefono" /> 
	<s:textfield name="owner.rfc" label="RFC" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>
