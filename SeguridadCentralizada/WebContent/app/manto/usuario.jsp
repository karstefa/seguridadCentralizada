<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript">
	function asignar(idUsuario, usuario, nombre, apellido, estado) {
		$("#idUsuario").val(idUsuario);
		$("#usuario").val(usuario);
		$("#nombre").val(nombre);
		$("#apellido").val(apellido);
		$("#estado").val(estado);
	}
	function eliminar(idUsuariod, usuariod) {
		$("#idUsuarioDelete").val(idUsuariod);
		$("#usuarioDelete").val(usuariod);
		document.getElementById('lblEliminando').innerHTML = 'Desea Eliminar a '
				+ document.getElementById("usuarioDelete").value + '?';
	}
</script>
<jsp:include page="/headerPrimario.jsp"></jsp:include>
<body>
	<div class="container">
		<h3>Mantenimiento Usuario</h3>
		<div class="input-group">
			<button type="submit" name="agregar" class="btn btn-success btn-xs"
				data-toggle="modal" data-target="#myModal"
				onclick="asignar('${user.idUsuario}','${user.usuario}','${user.nombre}','${user.apellidos}','${user.activo}');">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Nuevo
			</button>
		</div>
		<stripes:form
			beanclass="sv.com.tecnoin.seguridad.accion.UsuarioAction">
			<div class="input-group">
				<input name="nombreBusqueda" type="text" class="form-control"
					placeholder="Nombre del Usuario..."> <span
					class="input-group-btn"> <stripes:submit name="buscar"
						class="btn btn-default" value="Buscar" />
				</span>
			</div>
		</stripes:form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Activo</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${actionBean.usuarioList != null}">
					<c:forEach items="${actionBean.usuarioList}" var="user">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.UsuarioAction">
							<tr>
								<td data-title="Usuario" class="numeric"><stripes:link
										href="/acciones/sistemaRol">
										<stripes:param name="idUsuario" value="${user.idUsuario}" />
										<stripes:param name="nombreUsuario" value="${user.nombre}" />
										<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
										<b>${user.usuario}</b>
									</stripes:link></td>
								<td>${user.nombre}</td>
								<td>${user.apellidos}</td>
								<td>${user.activo}</td>
								<td>
									<div class="bbtn-group btn-group-xs" role="group">
										<button id="${user.idUsuario}" type="button"
											class="btn btn-info btn-xs" data-toggle="modal"
											data-target="#myModal" name="agregar"
											onclick="asignar('${user.idUsuario}','${user.usuario}','${user.nombre}','${user.apellidos}','${user.activo}');">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Editar
										</button>
										<button id="${user.idUsuario}" type="button" name="borrar"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#myModalEliminar"
											onclick="eliminar('${user.idUsuario}','${user.usuario}');">
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

		<!-- Modal agregar-editar -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.UsuarioAction"
							class="formValidacion" id="frmUsuarioM">
							<div class="form-group">
								<input type="hidden" id="idUsuario" name="idUsuario" />
							</div>
							<div class="form-group">
								<label for="url">Usuario :</label> <input type="text"
									id="usuario" class="form-control" name="usuario"
									placeholder="Usuario" required />
							</div>
							<div class="form-group">
								<label for="nombre">Nombres :</label> <input type="text"
									id="nombre" class="form-control" name="nombre"
									placeholder="Nombre" required />
							</div>
							<div class="form-group">
								<label for="url">Apellidos :</label> <input type="text"
									id="apellido" class="form-control" name="apellido"
									placeholder="Apellidos" required />
							</div>
							<div class="form-group">
								<label for="url">Activo :</label>
								<stripes:select id="activo" name="activo">
									<stripes:option value="S">SI</stripes:option>
									<stripes:option value="N">NO</stripes:option>
								</stripes:select>
							</div>
							<div class="form-group" style="display: inline;">
								<button type="submit" name="agregar"
									class="btn btn-primary btn-block"
									onclick="validar('frmSistemaM')">
									<span class="glyphicon glyphicon-floppy-disk"
										aria-hidden="true"></span> Guardar
								</button>
							</div>
						</stripes:form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal eliminar -->
		<div id="myModalEliminar" class="modal fade" role="dialog">
			<div class="modal-dialog modal-md">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="valor">
							<label id="lblEliminando" value=""></label>
						</h4>
					</div>
					<div class="modal-body">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.UsuarioAction"
							class="formValidacion" id="frmUsuarioD">
							<div class="form-group">
								<input type="hidden" id="idUsuarioDelete" name="idUsuarioDelete" />
							</div>
							<div class="form-group">
								<input type="hidden" id="usuarioDelete" class="form-control"
									name="usuarioDelete" />
							</div>
							<div class="form-group" id="eliminar" style="display: inline;">
								<button id="accion3" type="submit" name="borrar"
									class="btn btn-danger btn-block">
									<span class="glyphicon glyphicon-erase" aria-hidden="true"></span>
									Eliminar
								</button>
							</div>
						</stripes:form>
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