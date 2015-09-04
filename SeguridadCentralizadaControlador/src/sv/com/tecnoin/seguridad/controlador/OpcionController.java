package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.Opcion;

public class OpcionController extends AbstractController<Opcion> {

	public OpcionController() {
		super(Opcion.class);
		
	}

	@Override
	public String getNamePersistenceUnit() {
		
		return "SeguridadCentralizadaControlador";
	}

}
