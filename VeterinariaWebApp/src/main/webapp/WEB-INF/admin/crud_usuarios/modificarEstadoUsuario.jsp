<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarID.jsp</title>
</head>

<body>
<s:form action="finalMoficarStatus">
	<s:textfield name="usuario.usuarioID" value="%{usuario.usuarioID}" readonly="true" label="ID Usuario"/>
   <s:select label="Estado"
	headerValue="Elige un estado" 
	headerKey="-1"
	list="list_estado_frontend"
	name="usuario.estado"
	/>
    <s:submit value="Actualizar Estado" />
</s:form>
</body>
</html>
