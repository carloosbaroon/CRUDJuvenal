<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
<head>
		<title>Seleccionar Atenciones</title>
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
			<h1>Atenciones de hoy</h1>	
		</div>
</div>
<!--content-->
<div class="about">
	
	<!---->
	<div class="why">
		<div class="container">
			<div class="why-top-top">
			
				<div class="col-sm-4 top-content">
					
	<s:url action="goto_admin_atenciones_jsp" var="regresar"/>
 


<table border="1">
	<tr>
       <td><b>ID Atencion</b></td>
       <td><b>ID Sala</b></td>
       <td><b>ID Paciente</b></td>
       <td><b>Hora entrada</b></td>
       <td><b>Seleccionar</b></td>
    </tr>

<s:iterator value="buffer_atenciones_today" status="i">
	<tr>
		<td><s:property value="id_atencion"/></td>
		<td><s:property value="id_sala"/></td>
		<td><s:property value="id_paciente"/></td>
		<td><s:property value="hora_entrada"/></td>
		<td>
			<s:url action="goto_pre_terminar_atencion" var="url_registrar_atencion">
       			<s:param name = "atencion.id_atencion">${id_atencion}</s:param>
       			<s:param name = "atencion.id_consulta">${id_consulta}</s:param>
       			<s:param name = "atencion.id_sala">${id_sala}</s:param>
       			<s:param name = "atencion.id_paciente">${id_paciente}</s:param>
			</s:url>
			<a class="more" href="${url_registrar_atencion}">Seleccionar</a>
		</td>
	</tr>
</s:iterator>
</table>
<h4> <a href="${regresar}">Regresar</a></h4>
				
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
				<h4>Navegaci�n</h4>
				  <ul class="list1">
				  	  <li class="active"><a href="${goto_welcome}">Inicio</a></li>
					   	 <li><a href="${goto_crear_admin}">Crear Administrador</a></li>
					   	 <li><a href="${goto_login}">Login</a></li>
				  </ul>
			</div>
		  	
		
			<div class="col-md-3 footer-head1">
			  	<h4>Ubicaci�n</h4>
             	<p>Avenida Eduardo Monroy C�rdenas 2000 San Antonio Buenavista, 50110 Toluca de Lerdo, M�x</p>
              	
			</div>
			<div class="clearfix"> </div>
		  
		   <div class="footer-bottom">
		<p> � 2015 Fidele. All rights reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
    </div>
	 </div>
</div>
 	<!--//footer-->
</body>
</html>