package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sv.com.tecnoin.seguridad.entidad.Sistema;
import sv.com.tecnoin.seguridad.entidad.Usuario;

public class SistemaController extends AbstractController <Sistema>{

	public SistemaController() {
		super(Sistema.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

	

	public List<Sistema> findByName(String nombre) {
		EntityManager em = getEntityManager();
		try{
			Query q = em.createNativeQuery("Sistema.findByName",Sistema.class);
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
