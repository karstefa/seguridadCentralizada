<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript">
	function asignar(idSistema, nombre, url) {
		$("#idSistema").val(idSistema);
		$("#nombre").val(nombre);
		$("#url").val(url);
	}
	function eliminarPremio(idSistema, nombre, url) {
		$("#idSistemaDelete").val(idSistema);
		$("#nombreDelete").val(nombre);
		document.getElementById('lblEliminando').innerHTML = 'Desea Eliminar '
				+ document.getElementById("nombreDelete").value + '?';
	}
</script>
<jsp:include page="/headerPrimario.jsp"></jsp:include>
<body>
	<div class="container">
		<h3>Mantenimiento Sistemas</h3>
		<div class="input-group">
			<button type="submit" name="agregar" class="btn btn-success btn-xs"
				data-toggle="modal" data-target="#myModal"
				onclick="asignar('${sis.idSistema}','${sis.nombre}','${sis.url}');">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Nuevo
			</button>
		</div>
		<stripes:form
			beanclass="sv.com.tecnoin.seguridad.accion.SistemaAction">
			<div class="input-group">
				<input name="nombreBusqueda" type="text" class="form-control"
					placeholder="Nombre del Sistema..."> <span
					class="input-group-btn"> <stripes:submit name="buscar"
						class="btn btn-default" value="Buscar" />
				</span>
			</div>
		</stripes:form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>URL</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${actionBean.sistemasList != null}">
					<c:forEach items="${actionBean.sistemasList}" var="sis">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.SistemaAction">
							<tr>
								<td data-title="Usuario" class="numeric"><stripes:link
										href="/acciones/sistemaOpcion">
										<stripes:param name="idSistema" value="${sis.idSistema}" />
										<stripes:param name="nombre" value="${sis.nombre}" />
										<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
										<b>${sis.nombre}</b>
									</stripes:link></td>
								<td>${sis.nombre}</td>
								<td>${sis.url}</td>
								<td>
									<div class="bbtn-group btn-group-xs" role="group">
										<button id="${sis.idSistema}" type="button"
											class="btn btn-info btn-xs" data-toggle="modal"
											data-target="#myModal" name="agregar"
											onclick="asignar('${sis.idSistema}','${sis.nombre}','${sis.url}');">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Editar
										</button>
										<button id="${sis.idSistema}" type="button" name="borrar"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#myModalEliminar"
											onclick="eliminarPremio('${sis.idSistema}','${sis.nombre}','${sis.url}');">
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
							beanclass="sv.com.tecnoin.seguridad.accion.SistemaAction"
							class="formValidacion" id="frmSistemaM">
							<div class="form-group">
								<input type="hidden" id="idSistema" name="idSistema"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="nombre">Nombre :</label> <input type="text"
									id="nombre" class="form-control" name="nombre"
									placeholder="Nombre" required />
							</div>
							<div class="form-group">
								<label for="url">URL :</label> <input type="text" id="url"
									class="form-control" name="url" placeholder="Url" required />
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
						<stripes:form id="frm2"
							beanclass="sv.com.tecnoin.seguridad.accion.SistemaAction">
							<input type="hidden" id="idSistemaDelete" name="idSistemaDelete"
								class="form-control" />
							<input type="hidden" id="nombreDelete" class="form-control"
								name="nombreDelete" />
							<div class="form-group" id="eliminarPremio"
								style="display: inline;">
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