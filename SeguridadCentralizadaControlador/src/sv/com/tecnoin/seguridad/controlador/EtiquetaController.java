package sv.com.tecnoin.seguridad.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import sv.com.tecnoin.seguridad.entidad.Etiqueta;

public class EtiquetaController extends AbstractController<Etiqueta> {

	public EtiquetaController() {
		super(Etiqueta.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

	public List<Etiqueta> findByNameLike(String nombre) {
		List<Etiqueta> etiquetaList = new ArrayList<>();
		try {
			Query q = getEntityManager().createNamedQuery("Etiqueta.findByName", Etiqueta.class);
			q.setParameter("nombre", nombre);
			etiquetaList = q.getResultList(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return etiquetaList;
	}

}
