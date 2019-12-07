<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
<head>
		<title>Lista Citas</title>
		<link href="styles/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery.min.js"></script>
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="styles/style.css" rel="stylesheet" type="text/css" media="all" />	
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Fidele Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!---->
		<script src="js/menu_jquery.js"></script>
		<script src="js/moment.js"></script>
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
			<h1>Lista Pacientes</h1>	
		</div>
</div>
<!--content-->
<div class="about">
	
	<!---->
	<div class="why">
		<div class="container">
			<div class="why-top-top">
			
				<div class="col-sm-4 top-content">
					
<table border="1">
	<tr>
       <td><b>ID Cita</b></td>
       <td><b>Fecha</b></td>
       <td><b>Hora Inicial</b></td>
       <td><b>Hora Final</b></td>
       <td><b>Id Empleado</b></td>
       <td><b>ID Sala</b></td>	
       <td><b>ID Paciente</b></td>
       <td><b>Correo</b></td>
       <td><b>Observaciones</b></td>
       <td><b>Estado</b></td>       
       <td><b>Tomar Cita</b></td>
       <td><b>Salida Cita</b></td>
    </tr>

<s:iterator value="buffer_citas" status="i">
	<tr>
		<td><s:property value="id_consulta"/></td>
		<td><s:property value="fecha_consulta"/></td>
		<td id="hora-inicial_${i.index}"><s:property value="hora_inicial"/></td>
		<td id="hora-final_${i.index}"><s:property value="hora_final"/></td>
		<td><s:property value="id_empleado"/></td>
		<td><s:property value="id_sala"/></td>
		<td><s:property value="id_paciente"/></td>
		<td><s:property value="correo"/></td>
		<td><s:property value="observaciones"/></td>
		<td><s:property value="estado_consulta"/></td>
		<td>
			<s:url action="tomar_cita" var="tomar_cita">
       			<s:param name = "qs_paciente_id">${id}</s:param>
			</s:url>
			<a class="more" href="${tomar_cita}" id="entrar_${i.index}" onClick="return false;">Tomar Cita</a>
		</td>
		
		<td>
			<s:url action="salida_cita" var="salida_cita">
       			
			</s:url>
			<a class="" href="${salida_cita}" id="salir_${i.index}" onclick="foo(this);">Salida Cita</a>
		</td>
	</tr>
</s:iterator>
</table>
<h4><a href="${regresar}">Regresar</a></h4>
				
				</div>
				<div class="clearfix"> </div>
			</div>
			
		</div>
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
		  
		   <div class="footer-bottom">
		<p> © 2015 Fidele. All rights reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
    </div>
	 </div>
</div>
 	<!--//footer-->
 	
 	<script type="text/javascript">
 	
 		function foo(e) {			
 			return false; 			
 		}
 		//alert("Hola:" + moment().format('MMMM Do YYYY, h:mm:ss a'));
 		//var salida_cita = document.getElementById("salida_cita");
 		//salida_cita.setAttribute("onclick", "")
 		
 	</script>
</body>
</html>