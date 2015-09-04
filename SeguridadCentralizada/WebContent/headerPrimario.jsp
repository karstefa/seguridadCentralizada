<%@ page import="sv.com.tecnoin.seguridad.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seguridad Centralizada</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/funciones.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/validator.min.js"></script>
<!-- Bootstrap theme -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/font-awesome.css" rel="stylesheet">

<style type="text/css">
a.disabled {
	pointer-events: none;
	cursor: default;
}
</style>
</head>
<body>
	<%
		Usuario user = (Usuario) session.getAttribute("USUARIO");
		String nombre = user.getNombre();
	%>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><s:link href="/acciones/sistemas">Matenimieto Sistema</s:link></li>
						<li role="separator" class="divider"></li>
						<li><s:link href="/acciones/usuario">Matenimieto Usuario</s:link></li>
						<li role="separator" class="divider"></li>
						<li><s:link href="/acciones/etiquetas">Matenimieto Etiqueta</s:link></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=nombre%> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><s:link beanclass="sv.com.tecnoin.seguridad.accion.LoginAction" event="logOut">
								<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
							Cerrar Sesión</s:link></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>

	<c:forEach items="${actionBean.mensajes}" var="mensaje">
		<c:choose>
			<c:when test="${mensaje.severity == 3}">
				<div class="alert alert-danger">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Error! </strong> ${mensaje.mensaje}
				</div>
				<br />
			</c:when>
			<c:when test="${mensaje.severity == 2}">
				<div class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Advertencia! </strong> ${mensaje.mensaje}
				</div>
				<br />
			</c:when>
			<c:otherwise>
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Exito! </strong> ${mensaje.mensaje}
				</div>
				<br />
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>
