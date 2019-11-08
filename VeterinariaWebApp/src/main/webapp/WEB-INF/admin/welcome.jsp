<%@ page language = "java" contentType = "text/html; charset = UTF-8"
   pageEncoding = "UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Bienvenida</title>
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
<div class="banner">
	<div class="banner-1"> </div>
		<div class="container">
			<div class="banner-top">
				<div class="col-sm-6 head-banner">
					<h1>Fidele <span>Veterinaria </span></h1>
					<h4>Con más de 20 años de experiencia</h4>
					
					<p>Estamos especializados en especies pequeñas. Contamos con los mejores especialistas y equipo de última generación.</p>
				 </div>
				
				<div class="clearfix"> </div>
			</div>
	</div>
</div>
<!--content-->
<div class="content">

	<!---->
	
		<div class="clearfix"> </div>
	</div>
	<!---->
	<div class="events">
		<div class="container">
			<h2>Servicios</h2>
			<div class="events-top">
				<div class="col-sm-4 top-event">
					<a href="single.html"><img src="images/ev.jpg" class="img-responsive" alt=""></a>
					<h4><a href="single.html">Cirugía General</a></h4>
					
					<p>Manejamos técnicas de anestesia para un adecuado y mejor control del dolor, apoyándonos de personal capacitado y actualizado, con equipo de vanguardia y quirófanos equipados. </p>
				</div>
					<div class="col-sm-4 top-event">
					<a href="single.html"><img src="images/ev1.jpg" class="img-responsive" alt=""></a>
					<h4><a href="single.html">Consulta General</a></h4>
				
					<p>Contamos con personal médico comprometido en solucionar los problemas de tus mascotas. Siempre en continua capacitación para ofrecerles los más novedosos tratamientos y métodos de diagnóstico. </p>
				</div>
					<div class="col-sm-4 top-event">
					<a href="single.html"><img src="images/ev2.jpg" class="img-responsive" alt=""></a>
					<h4><a href="single.html">Laboratorio</a></h4>
					
					<p>Realizamos estudios de laboratorio como hemogramas, bioquímicas sanguíneas, urianalisis entre otros, con entregas de resultados en tiempos cortos, para mejorar la aproximación diagnostica de nuestros pacientes. </p>
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
		  
		   <div class="footer-bottom">
		<p> © 2015 Fidele. All rights reserved | Design by  <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
    </div>
	 </div>
</div>
 	<!--//footer-->
</body>
	
</html>