<%@ page import="sv.com.tecnoin.seguridad.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="/headerPrimario.jsp"></jsp:include>

<body>
	<%
		Sistema sis = (Sistema) session.getAttribute("sistemaSelected");
		String sistema = sis.getNombre();
	%>
	<div class="container">
		<div class="row">
			<stripes:link href="/acciones/sistemas" class="btn btn-info btn-xs">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Regresar a Sistema
			</stripes:link>
		</div>
		<div class="row">
			<h4>
				Control de mando del sistema
				<%=sistema%></h4>
			<stripes:link href="/acciones/roles" class="btn btn-primary btn-xs">
				<span class="glyphicon glyphicon-tags" aria-hidden="true"></span> Mantenimiento Roles
	   		</stripes:link>
			<button type="submit" name="verRoles" class="btn btn-success btn-xs"
				data-toggle="modal" data-target="#myModal"
				onclick="validar('frmRoles')">
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
				Ver Roles Asignados al sistema
			</button>
			<br> <br>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripci&#243;n</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${actionBean.rolList != null}">
					<c:forEach items="${actionBean.rolList}" var="r">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.mandoSistemaAction">
							<tr>
								<td>${r.nombre}</td>
								<td>${r.descripcion}</td>
								<td>${r.estado}</td>
								<td>
									<div class="bbtn-group btn-group-xs" role="group">
										<button id="${r.idRol}" type="submit"
											class="btn btn-info btn-xs" name="agregar">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Asignar Rol al Sistema
										</button>
										<input type="hidden" id="idRol" name="idRol"
											value="${r.idRol}" />
									</div>
								</td>
							</tr>
						</stripes:form>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Nombre</th>
									<th>Descripci&#243;n</th>
									<th>Estado</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${actionBean.verRolesList != null}">
									<c:forEach items="${actionBean.verRolesList}" var="ver">
										<stripes:form
											beanclass="sv.com.tecnoin.seguridad.accion.mandoSistemaAction"
											class="formValidacion" id="frmRoles">
											<tr>
												<td>${ver.nombre}</td>
												<td>${ver.descripcion}</td>
												<td>${ver.estado}</td>
											</tr>
										</stripes:form>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>