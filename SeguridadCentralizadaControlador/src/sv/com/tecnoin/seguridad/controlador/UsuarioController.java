package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNamedQuery("Usuario.findUserPass", Usuario.class);
			q.setParameter("usuario", usuario.getUsuario());
			q.setParameter("clave", usuario.getClave());
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}


	public List<Usuario> findByName(String nombre) {
		Usuario u = new Usuario();
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNamedQuery("Usuario.findUserPass", Usuario.class);
			q.setParameter("nombre", nombre);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

	public Usuario validaUsuarioExiste(String user) {
		Usuario u = new Usuario();
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNamedQuery("Usuario.findByUser", Usuario.class);
			q.setParameter("usuario", user);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}


}
