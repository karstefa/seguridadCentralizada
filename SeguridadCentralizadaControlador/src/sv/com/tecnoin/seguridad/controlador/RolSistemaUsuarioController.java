package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.RolSistemaUsuario;

public class RolSistemaUsuarioController extends AbstractController<RolSistemaUsuario> {

	public RolSistemaUsuarioController(Class clase) {
		super(RolSistemaUsuario.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
