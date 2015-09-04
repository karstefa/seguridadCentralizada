<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript">
	function asignar(idEtiqueta, nombre, descripcion) {
		$("#idEtiqueta").val(idEtiqueta);
		$("#nombre").val(nombre);
		$("#descripcion").val(descripcion);
	}
	function eliminar(idEtiquetad, nombred) {
		$("#idEtiquetaDelete").val(idEtiquetad);
		$("#nombreDelete").val(nombred);
		document.getElementById('lblEliminando').innerHTML = 'Desea Eliminar '
				+ document.getElementById("nombreDelete").value + '?';
	}
</script>
<jsp:include page="/headerPrimario.jsp"></jsp:include>
<body>
	<div class="container">
		<h3>Mantenimiento Etiquetas</h3>
		<div class="input-group">
			<button type="submit" name="agregar" class="btn btn-success btn-xs"
				data-toggle="modal" data-target="#myModal"
				onclick="asignar('${eti.idEtiqueta}','${eti.nombre}','${eti.descripcion}');">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Nuevo
			</button>
		</div>
		<stripes:form
			beanclass="sv.com.tecnoin.seguridad.accion.EtiquetaAction">
			<div class="input-group">
				<input name="nombreBusqueda" type="text" class="form-control"
					placeholder="Nombre de la Etiqueta..."> <span
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
				</tr>
			</thead>
			<tbody>
				<c:if test="${actionBean.etiquetaList != null}">
					<c:forEach items="${actionBean.etiquetaList}" var="eti">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.EtiquetaAction">
							<tr>
								<td>${eti.nombre}</td>
								<td>${eti.descripcion}</td>
								<td>
									<div class="bbtn-group btn-group-xs" role="group">
										<button id="${eti.idEtiqueta}" type="button"
											class="btn btn-info btn-xs" data-toggle="modal"
											data-target="#myModal" name="agregar"
											onclick="asignar('${eti.idEtiqueta}','${eti.nombre}','${eti.descripcion}');">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											Editar
										</button>
										<button id="${eti.idEtiqueta}" type="button" name="borrar"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#myModalEliminar"
											onclick="eliminar('${eti.idEtiqueta}','${eti.nombre}');">
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
							beanclass="sv.com.tecnoin.seguridad.accion.EtiquetaAction"
							class="formValidacion" id="frmEtiquetaM">
							<div class="form-group">
								<input type="hidden" id="idEtiqueta" name="idEtiqueta">
							</div>
							<div class="form-group">
								<label for="nombre">Nombre :</label> <input type="text"
									id="nombre" class="form-control" name="nombre" maxlength="20"
									placeholder="Nombre" required>
							</div>
							<div class="form-group">
								<label for="descripcion">Descripci&#243;n :</label> <input
									type="text" id="descripcion" class="form-control"
									maxlength="200" name="descripcion"
									placeholder="Descripci&#243;n" required>
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
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="valor">
							<label id="lblEliminando" value=""></label>
						</h4>
					</div>
					<div class="modal-body">
						<stripes:form
							beanclass="sv.com.tecnoin.seguridad.accion.EtiquetaAction"
							class="formValidacion" id="frmEtiquetaD">
							<div class="form-group">
								<input type="hidden" id="idEtiquetaDelete"
									name="idEtiquetaDelete" />
							</div>
							<div class="form-group">
								<input type="hidden" id="nombreDelete" class="form-control"
									name="nombreDelete" />
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