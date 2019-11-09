<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarIDPaciente.jsp</title>
</head>

<body>


<s:url action="consultaGeneral2" var="consulta2"> <s:param name="owner.id" value="%{owner.id}" /></s:url>


	
	<p><a href="${consulta2}">Consulta General</a></p>
	
	
</body>
</html>