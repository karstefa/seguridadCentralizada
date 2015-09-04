<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript">
	function asignar(idRol, nombre, descripcion, activo) {
		$("#idRol").val(idRol);
		$("#nombre").val(nombre);
		$("#descripcion").val(descripcion);
		$("#activo").val(activo);
	}
	function eliminar(idRol, nombre) {
		$("#idRolDelete").val(idRol);
		$("#nombreDelete").val(nombre);
		document.getElementById('lblEliminando').innerHTML = 'Desea Eliminar '
				+ document.getElementById("nombreDelete").value + '?';
	}
</script>
<jsp:include page="/headerPrimario.jsp"></jsp:include>
<body>
	<div class="container">
		<div class="row">
			<stripes:link href="/acciones/sistemaOpcion" class="btn btn-info btn-xs">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Regresar a mando sistema
			</stripes:link>
		</div>
		<h3>Mantenimiento Roles</h3>
		<div class="input-group">
			<button type="submit" name="agregar" class="btn btn-success btn-xs"
				data-toggle="modal" data-target="#myModal"
				onclick="asignar('${r.idRol}','${r.nombre}','${r.descripcion}', '${r.activo}');">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Nuevo
			</button>
		</div>
		<stripes:form beanclass="sv.com.tecnoin.seguridad.accion.RolAction">
			<div class="input-group">
				<input name="nombreBusqueda" type="text" class="form-control"
					placeholder="Nombre del Rol..."> <span
					class="input-group-btn"> <stripes:submit name="buscar"
						class="btn btn-default" value="Buscar" />
				</span>
			</div>
		</stripes:form>
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
							beanclass="sv.com.tecnoin.seguridad.accion.RolAction">
							<tr>
								<td>${r.nombre}</td>
								<td>${r.descripcion}</td>
								<td>${r.estado}</td>
								<td>
									<div class="bbtn-group btn-group-xs" role="group">
										<button id="${r.idRol}" type="button"
											class="btn btn-info btn-xs" data-toggle="modal"
											data-target="#myModal" name="agregar"
											onclick="asignar('${r.idRol}','${r.nombre}','${r.descripcion}', '${r.estado}');">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Editar
										</button>
										<button id="${r.idRol}" type="button" name="borrar"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#myModalEliminar"
											onclick="eliminar('${r.idRol}','${r.nombre}');">
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
							beanclass="sv.com.tecnoin.seguridad.accion.RolAction"
							class="formValidacion" id="frmRolM">
							<div class="form-group">
								<input type="hidden" id="idRol" name="idRol"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="nombre">Nombre :</label> <input type="text"
									id="nombre" class="form-control" name="nombre"
									placeholder="Nombre" required />
							</div>
							<div class="form-group">
								<label for="url">Descripci&#243;n :</label> <input type="text"
									id="descripcion" class="form-control" name="descripcion"
									placeholder="Descripci&#243;n" required />
							</div>
							<div class="form-group">
								<label for="activo">Activo :</label>
								<stripes:select id="estado" name="activo">
									<stripes:option value="S">SI</stripes:option>
									<stripes:option value="N">NO</stripes:option>
								</stripes:select>
							</div>
							<div class="form-group" style="display: inline;">
								<button type="submit" name="agregar"
									class="btn btn-primary btn-block" onclick="validar('frmRolM')">
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
						<stripes:form id="frm2"
							beanclass="sv.com.tecnoin.seguridad.accion.RolAction">
							<input type="hidden" id="idRolDelete" name="idRolDelete"
								class="form-control" />
							<input type="hidden" id="nombreDelete" class="form-control"
								name="nombreDelete" />
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