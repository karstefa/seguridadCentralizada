package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import sv.com.tecnoin.seguridad.entidad.Sistema;
import sv.com.tecnoin.seguridad.entidad.Usuario;

public class SistemaController extends AbstractController <Sistema>{

	public SistemaController() {
		super(Sistema.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Sistema> findAllByOpcionRol(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Sistema> findByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
