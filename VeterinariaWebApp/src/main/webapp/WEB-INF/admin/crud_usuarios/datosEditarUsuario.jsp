<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Datos del empleado editar</title>
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
			<br>
			<h1>Administraci�n Usuarios</h1>	
		</div>
</div>
<!--content-->
<div class="about">
	
	<!---->
	<div class="why">
		<div class="container">
			<div class="why-top-top">
			
				<div class="col-sm-4 top-content">
					<s:form action="actualizar_usuario">		
						<s:textfield name="usuario.usuarioID" label="Usuario" value="%{usuario.usuarioID}" readonly="true"/>
						<s:textfield name="empleado.id_empleado" label="ID Empleado" value="%{empleado.id_empleado}" readonly="true"/>
						<s:textfield name="usuario.password" label="Password" value="%{usuario.password}"/>
						<s:textfield name="usuario.confirmar_password" label="Confirmar Password" value="%{usuario.confirmar_password}"/>
						<s:textfield name="empleado.nombre_completo" label="Nombre Completo" value="%{empleado.nombre_completo}"/>
						<s:textfield name="empleado.direccion" label="Direcci�n" value="%{empleado.direccion}"/>
						<s:textfield name="empleado.telefono" label="Tel�fono" value="%{empleado.telefono}"/>
						<s:textfield name="empleado.puesto" label="Puesto" value="%{empleado.puesto}"/>
						<s:textfield name="empleado.especialidad" label="Especialidad M�dica" value="%{empleado.especialidad}"/>
						<s:textfield name="empleado.turno" label="Turno" value="%{empleado.turno}"/>
						<s:submit value="Enviar"/>
					</s:form>

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
	 	</div>
		</div>
</div>
		
	</body>
</html>
<!-- <h1>Datos del empleado</h1>

	
	<s:form action="actualizar_usuario">		
		<s:textfield name="usuario.usuarioID" label="Usuario" value="%{usuario.usuarioID}" readonly="true"/>
		<s:textfield name="empleado.id_empleado" label="ID Empleado" value="%{empleado.id_empleado}" readonly="true"/>
		<s:textfield name="usuario.password" label="Password" value="%{usuario.password}"/>
		<s:textfield name="usuario.confirmar_password" label="Confirmar Password" value="%{usuario.confirmar_password}"/>
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo" value="%{empleado.nombre_completo}"/>
		<s:textfield name="empleado.direccion" label="Direcci�n" value="%{empleado.direccion}"/>
		<s:textfield name="empleado.telefono" label="Tel�fono" value="%{empleado.telefono}"/>
		<s:textfield name="empleado.puesto" label="Puesto" value="%{empleado.puesto}"/>
		<s:textfield name="empleado.especialidad" label="Especialidad M�dica" value="%{empleado.especialidad}"/>
		<s:textfield name="empleado.turno" label="Turno" value="%{empleado.turno}"/>
		<s:submit value="Enviar"/>
	</s:form>
 -->