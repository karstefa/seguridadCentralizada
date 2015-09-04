package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.BitacoraProceso;

public class BitacoraProcesoController extends AbstractController<BitacoraProceso> {

	public BitacoraProcesoController() {
		super(BitacoraProceso.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
