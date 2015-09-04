package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.RegistroLog;

public class RegistroLogController extends AbstractController<RegistroLog> {

	public RegistroLogController(Class clase) {
		super(RegistroLog.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
