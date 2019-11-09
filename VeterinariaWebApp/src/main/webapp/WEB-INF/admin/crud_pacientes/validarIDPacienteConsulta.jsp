<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>user/validarIDPaciente.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    
	    function onButtonClick(){       
	        var owner_id = $('#owner_id').val();
	        $('#anchor_id_owner').val();
	        alert("Owner ID "+owner_id);           
	    }

	</script>
</head>

<body>
	<s:form action="buscar_pacientes">
	    <s:textfield name="owner.id" label="ID Dueño" />
	    <s:submit>Buscar Pacientes</s:submit>
	</s:form>
</body>	
</html>