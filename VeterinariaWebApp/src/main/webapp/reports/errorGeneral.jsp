<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>ErrorGeneral</title>
</head>

<body>

  <h3>Ocurrió un problema</h3>
	<p><s:property value="message"/></p>
	<s:property value="exceptionStack"/> 
</div> 
</body>
</html>