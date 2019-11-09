<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
<head>
		<title>Reservar sala</title>
		<link href="styles/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="styles/style.css" rel="stylesheet" type="text/css" media="all" />	
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!---->
		<script src="js/menu_jquery.js"></script>
	</head>
<body> 
<!--header-->	
<div class="header">
	<div class="container">
		 <div class="logo">
		  	<a href="index.html"><img src="images/logof.jpeg" alt="" ></a>
	  	 </div>
	   <div class="head-right">
	   	<div class="head-grid">
	</div> 	
	   <div class="top-nav">
			  <span class="menu"><img src="images/menu.png" alt=""> </span>
					<ul>
						<s:url action="goto_crear_admin_jsp" var="goto_crear_admin"/>
						<s:url action="goto_login_jsp" var="goto_login"/>
						<s:url action="welcome" var="goto_welcome"/>
						 <li class="active"><a href="${goto_welcome}">Inicio</a></li>
					   	 <li><a href="${goto_crear_admin}">Crear Administrador</a></li>
					   	 <li><a href="${goto_login}">Login</a></li>
					   	<!--   <li><a href="blog.html">Blog</a></li>
					   	 <li><a href="codes.html">Short Codes</a></li>
					   	 <li><a href="contact.html">Contact</a></li>-->
					</ul>

					<!--script-->
				<script>
					$("span.menu").click(function(){
						$(".top-nav ul").slideToggle(500, function(){
						});
					});
			</script>
		</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<div class="banner-head">
	<div class="banner-1"> </div>
		<div class="container">
			<h1>Reservar Sala</h1>	
		</div>
</div>
<!--content-->
<div class="about">
	
	<!---->
	<div class="why">
		<div class="container">
			<div class="why-top-top">
			
				<div class="col-sm-4 top-content">
					<s:url action="goto_admin_salas_jsp" var="regresar"/>
	
	<s:form action="terminar_reservacion">
		<s:textfield name="consulta.fecha_consulta" label="Fecha (YYYY/MM/DD)" value="%{consulta.fecha_consulta}"/>
		<s:textfield name="consulta.hora_inicial" label="Hora inicial (hh:mm)" value="%{consulta.hora_inicial}"/>
		<s:textfield name="consulta.hora_final" label="Hora final (hh:mm)" value="%{consulta.hora_final}"/>
		<s:textfield name="consulta.id_empleado" label="Id del empleado" />
		<s:textfield name="consulta.id_sala" label="Id de la sala"/>
		<s:textfield name="consulta.id_paciente" label="Id del paciente" />
		<s:textfield name="consulta.observaciones" label="Observaciones" />
		<s:textfield name="consulta.estado_consulta" label="Estado" value="Programado"/>

		<a class="more"><s:submit value="Reservar"/></a>
	</s:form>
	<h4><a href="${regresar}">Regresar</a></h4>
				</div>
				<div class="clearfix"> </div>
			</div>
			
		</div>
	</div>
	<!---->
	
</div>
<!--footer-->
 	<div class="footer ">
 		<div class="footer-1"> </div>
		<div class="container">
		  <div class="footer_top">
		  	<div class="col-md-3 footer-head">
				<h4>Navegación</h4>
				  <ul class="list1">
				  	  <li class="active"><a href="${goto_welcome}">Inicio</a></li>
					   	 <li><a href="${goto_crear_admin}">Crear Administrador</a></li>
					   	 <li><a href="${goto_login}">Login</a></li>
				  </ul>
			</div>
		  	
		
			<div class="col-md-3 footer-head1">
			  	<h4>Ubicación</h4>
             	<p>Avenida Eduardo Monroy Cárdenas 2000 San Antonio Buenavista, 50110 Toluca de Lerdo, Méx</p>
              	
			</div>
			<div class="clearfix"> </div>
	 </div>
</div>
</div>
 	<!--//footer-->
</body>
</html>