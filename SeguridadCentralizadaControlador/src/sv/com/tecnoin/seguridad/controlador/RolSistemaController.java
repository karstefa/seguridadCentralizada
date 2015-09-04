package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.RolSistema;

public class RolSistemaController extends AbstractController<RolSistema> {

	public RolSistemaController() {
		super(RolSistema.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
