package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.Sesion;

public class SesionController extends AbstractController<Sesion> {

	public SesionController(Class clase) {
		super(Sesion.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
