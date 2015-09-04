package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import sv.com.tecnoin.seguridad.entidad.Usuario;

public class UsuarioController extends AbstractController<Usuario> {

	public UsuarioController() {
		super(Usuario.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}


	public Usuario autenticarUsuario(Usuario usuario) {
		Usuario u = new Usuario();
		try {
			Query q = getEntityManager().createNamedQuery("Usuario", Usuario.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Usuario validaUsuarioExiste(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Usuario> findByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateByClave(Usuario usu) {
		// TODO Auto-generated method stub
		
	}

}
