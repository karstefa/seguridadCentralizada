package sv.com.tecnoin.seguridad.accion;

import java.util.List;

import sv.com.tecnoin.seguridad.controlador.EtiquetaController;
import sv.com.tecnoin.seguridad.entidad.Etiqueta;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/etiquetas")
public class EtiquetaAction extends BaseActionBean {
	private List<Etiqueta> etiquetaList;
	private Etiqueta etiqueta;

	public EtiquetaAction() {

	}

	@DefaultHandler
	public Resolution index() {

		try {
			EtiquetaController nc = new EtiquetaController();
			etiquetaList = nc.findAll();

		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
		}

		ForwardResolution f = new ForwardResolution("/app/manto/etiquetas.jsp");
		return f;

	}

	public Resolution buscar() {
		String nombre = getContext().getRequest().getParameter("nombreBusqueda");
		try {
			EtiquetaController nc = new EtiquetaController();
			etiquetaList = nc.findByNameLike(nombre);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
			;
		}
		ForwardResolution f = new ForwardResolution("/app/manto/etiquetas.jsp");

		return f;
	}

	public Resolution agregar() {
		EtiquetaController nc = new EtiquetaController();

		String id = getContext().getRequest().getParameter("idEtiqueta");
		String nombre = getContext().getRequest().getParameter("nombre");
		String descripcion = getContext().getRequest().getParameter("descripcion");

		System.out.println("id - " + id);

		if (id == null || "0".equals(id) || id.isEmpty()) {
			try {
				System.err.println("Agregar Etiqueta....");
				nc = new EtiquetaController();
				etiqueta = new Etiqueta();
				etiqueta.setNombre(nombre);
				etiqueta.setDescripcion(descripcion);
				nc.insert(etiqueta);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.err.println("Modificar Etiqueta....");
				nc = new EtiquetaController();
				Etiqueta s = new Etiqueta();
				s.setNombre(nombre);
				s.setDescripcion(descripcion);
				s.setIdEtiqueta(Integer.parseInt(id));
				nc.update(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ForwardResolution f = new ForwardResolution("/app/manto/etiquetas.jsp");
		etiqueta = new Etiqueta();
		index();
		return f;
	}

	public Resolution borrar() {
		System.out.println("Borrar etiqueta...");
		int idEtiqueta = Integer.parseInt(getContext().getRequest().getParameter("idEtiquetaDelete"));
		EtiquetaController nc3 = new EtiquetaController();
		Etiqueta et = nc3.findBy(idEtiqueta);
		try {
			nc3.delete(et);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ForwardResolution f = new ForwardResolution("/app/manto/etiquetas.jsp");
		etiqueta = new Etiqueta();
		index();
		return f;
	}

	@Override
	public String toString() {
		return "EtiquetaAction [etiquetaList=" + etiquetaList + "]";
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Etiqueta> getEtiquetaList() {
		return etiquetaList;
	}

	public void setEtiquetaList(List<Etiqueta> etiquetaList) {
		this.etiquetaList = etiquetaList;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

}
