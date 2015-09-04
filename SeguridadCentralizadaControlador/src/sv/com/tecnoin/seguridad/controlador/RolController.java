package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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


	public List<Rol> findByName(String nombre) {
		EntityManager em = getEntityManager();
		try{
			Query q = em.createNamedQuery("Rol.findByName",Rol.class);
			q.setParameter("nombre", nombre);
			return q.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}

}
