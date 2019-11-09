<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarID.jsp</title>
</head>

<body>

<s:url action="goto_admin_usuarios_jsp" var="regresar"/>

<s:form action="modificarEstado">
    <s:textfield name="usuario.usuarioID" label="Id Usuario"><s:param name="id_usuario" value="usuario.usuarioID"/></s:textfield>
    <s:submit value="Enviar" />
</s:form>

<a href="${regresar}">Regresar</a>
</body>
</html>
