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
		Usuario user = (Usuario) session.getAttribute("usuarioSelected");
		String usuario = user.getUsuario();
	%>
	<div class="container">
		<div class="row">
			<stripes:link href="/acciones/usuario" class="btn btn-info btn-xs">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Regresar a Usuario
			</stripes:link>
		</div>
		<div class="row">
			<h4>Control de mando Usuario</h4>
			<stripes:link href="/acciones/sistemaRol"
				class="btn btn-success btn-xs">
				<span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Sistema
			</stripes:link>
			<stripes:link href="/acciones/sistemaRol"
				class="btn btn-primary btn-xs">
				<span class="glyphicon glyphicon-tags" aria-hidden="true"></span> Etiqueta
	   		</stripes:link>
			<stripes:link href="/acciones/sistemaRol" class="btn btn-info btn-xs">
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Track
	   		</stripes:link>
			<br> <br>
		</div>
		<stripes:form
			beanclass="sv.com.tecnoin.seguridad.accion.mandoUsuarioAction">
			<div class="row">
				<div class="form-group">
					<label for="nombre">Sistema :</label>
					<stripes:select name="idSistema" class="form-control">
						<stripes:options-collection collection="${actionBean.sistemaList}"
							label="nombre" value="idSistema" />
					</stripes:select>
				</div>
				<div class="form-group">
					<label for="nombre">Rol :</label>
					<stripes:select name="idRol" class="form-control">
						<stripes:options-collection collection="${actionBean.rolList}"
							label="nombre" value="idRol" />
					</stripes:select>
				</div>
				<div class="form-group" style="display: inline;">
					<button type="submit" name="guardar"
						class="btn btn-primary btn-block">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Agregar
					</button>
				</div>

				<h4>El Usuario ${usuario} está asociado a los
					siguientes sistemas con el respectivo rol</h4>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nombre Sistema</th>
							<th>Nombre Rol</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${actionBean.rolSistemaDTOList != null}">
							<c:forEach items="${actionBean.rolSistemaDTOList}" var="rols">
								<stripes:form
									beanclass="sv.com.tecnoin.seguridad.accion.mandoUsuarioAction">
									<tr>
										<td>${rols.nombre}</td>
										<td>${rols.nombreRol}</td>
										<td>
											<div class="bbtn-group btn-group-xs" role="group">
												<button type="submit" name="limpiar"
													class="btn btn-danger btn-xs">
													<span class="glyphicon glyphicon-erase" aria-hidden="true"></span>
													Eliminar
												</button>
											</div>
										</td>
									</tr>
								</stripes:form>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</stripes:form>
	</div>
</body>
</html>