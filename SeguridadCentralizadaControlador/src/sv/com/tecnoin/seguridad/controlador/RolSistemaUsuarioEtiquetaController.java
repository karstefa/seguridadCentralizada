package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.RolSistemaUsuarioEtiqueta;

public class RolSistemaUsuarioEtiquetaController extends AbstractController<RolSistemaUsuarioEtiqueta>{

	public RolSistemaUsuarioEtiquetaController() {
		super(RolSistemaUsuarioEtiqueta.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
