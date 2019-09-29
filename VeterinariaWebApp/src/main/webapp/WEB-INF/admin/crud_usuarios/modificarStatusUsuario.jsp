<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarID.jsp</title>
</head>

<body>
<s:form action="finalMoficarStatus">
   <s:select label="Estado"
	headerValue="Elige un estado" 
	headerKey="-1"
	list="list_estado"
	name="usuario.estado"
	/>
    <s:submit value="Enviar" />
</s:form>
</body>
</html>
