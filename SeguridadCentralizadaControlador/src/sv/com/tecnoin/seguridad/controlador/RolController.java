package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import sv.com.tecnoin.seguridad.entidad.Rol;
import sv.com.tecnoin.seguridad.entidad.RolSistema;

public class RolController extends AbstractController<Rol> {

	public RolController() {
		super(Rol.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

	public List<RolSistema> findByIDSistema(RolSistema r) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Rol> findByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
