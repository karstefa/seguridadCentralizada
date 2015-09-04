<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/funciones.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.min.js"></script>

</head>
<body>


	<c:forEach items="${actionBean.mensajes}" var="mensaje">
		<c:choose>
			<c:when test="${mensaje.severity == 3}">
				<div class="alert alert-danger">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Error! </strong> ${mensaje.mensaje}
				</div>
				<br />
			</c:when>
			<c:otherwise>
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Exito! </strong> ${mensaje.mensaje}
				</div>
				<br />
			</c:otherwise>
		</c:choose>
	</c:forEach>

</body>
</html>