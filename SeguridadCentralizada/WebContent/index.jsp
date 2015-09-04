<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seguridad Centralizada</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/bootstrap-theme.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/funciones.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.5/js/validator.min.js"></script>
<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/login-styles.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap-3.3.5/css/font-awesome.css"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="headerMensajes.jsp"></jsp:include>
	<div id="login">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-md-offset-4">
					<h1 class="text-center login-title">Seguridad Centralizada</h1>
					<div class="account-wall text-center">
						<img class=""
							src="${pageContext.request.contextPath}/imgs/tecnoinlogo_transparent.png"
							alt="">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.LoginAction"
							class="form-signin">
							<stripes:errors />
							<input type="text" class="form-control" placeholder="Usuario"
								name="usuario" required
								title="El usuario tiene que ser ingresado" autofocus>
							<input type="password" class="form-control"
								placeholder="Password" name="clave" required
								title="La clave tiene que ser ingresada">
							<input type="text" class="form-control"
								placeholder="Ingrese el Texto de Abajo" name="captcha"
								autocomplete="off" required
								title="El Captcha tiene que ser completado">
							<div class="text-justify form-signin-heading" id="imgCaptcha">
								<img src="${pageContext.request.contextPath}/simpleCaptcha.png"
									class="img-responsive" />
							</div>

							<button class="btn btn-lg btn-primary btn-block" type="submit"
								name="validar">Iniciar Sesion</button>
							<button type="button" class="btn btn-link" data-toggle="modal"
								data-target="#myModal">Resetear contraseña?</button>
						</stripes:form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Resetear contrase&ntilde;a</h4>
				</div>
				<div class="modal-body">
					<stripes:form id="frm"
						beanclass="sv.com.tecnoin.seguridad.accion.LoginAction">
						<h4 class="modal-title">¿ Desea efectuar el reseteo de clave
							?</h4>
						<div class="form-group">
							<input id="usuario" name="usuario" class="form-control" required
								placeholder="usuario" />
						</div>
						<div class="form-group" id="resetear" style="display: inline;">
							<button type="submit" id="accion2" name="resetearPassword"
								class="btn btn-primary btn-block">Procesar</button>
						</div>
					</stripes:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>