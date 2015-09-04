package sv.com.tecnoin.seguridad.accion;

import java.util.List;

import sv.com.tecnoin.seguridad.controlador.SistemaController;
import sv.com.tecnoin.seguridad.entidad.Sistema;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/sistemas")
public class SistemaAction extends BaseActionBean {
	private List<Sistema> sistemasList;
	private Sistema sistema;

	public SistemaAction() {

	}

	@DefaultHandler
	public Resolution index() {

		try {
			SistemaController nc = new SistemaController();
			sistemasList = nc.findAll();

		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
		}

		ForwardResolution f = new ForwardResolution("/app/manto/sistemas.jsp");
		return f;

	}

	public Resolution consultarr() {
		System.err.println("Logueando Sistema....");
		return new ForwardResolution("/app/manto/sistemas.jsp");
	}

	public Resolution buscar() {
		String nombre = getContext().getRequest().getParameter("nombreBusqueda");
		try {
			SistemaController nc = new SistemaController();
			sistemasList = nc.findByName(nombre);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
			;
		}
		ForwardResolution f = new ForwardResolution("/app/manto/sistemas.jsp");

		return f;
	}

	public Resolution agregar() {
		SistemaController nc = new SistemaController();

		String id = getContext().getRequest().getParameter("idSistema");
		String nombre = getContext().getRequest().getParameter("nombre");
		String url = getContext().getRequest().getParameter("url");

		System.out.println("id - " + id);

		if (id == null || "0".equals(id) || id.isEmpty()) {
			try {
				System.err.println("Agregar Sistema....");
				nc = new SistemaController();
				sistema = new Sistema();
				sistema.setNombre(nombre);
				sistema.setUrl(url);
				nc.insert(sistema);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				sistema = new Sistema();
				nc = new SistemaController();
				Sistema sistemaUpdated = new Sistema();
				System.err.println("Modificar Sistema....");
				sistemaUpdated.setNombre(nombre);
				sistemaUpdated.setUrl(url);
				sistemaUpdated.setIdSistema(Integer.parseInt(id));
				nc.update(sistemaUpdated);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ForwardResolution f = new ForwardResolution("/app/manto/sistemas.jsp");
		sistema = new Sistema();
		index();
		return f;
	}

	public Resolution borrar() {
		System.out.println("Borrar sistema...");
		int idSistema = Integer.parseInt(getContext().getRequest().getParameter("idSistemaDelete"));
		SistemaController nc3 = new SistemaController();
		try {
			Sistema s = nc3.findBy(idSistema);
			nc3.delete(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ForwardResolution f = new ForwardResolution("/app/manto/sistemas.jsp");
		sistema = new Sistema();
		index();
		return f;
	}

	@Override
	public String toString() {
		return "SistemaAction [sistemasList=" + sistemasList + "]";
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Sistema> getSistemasList() {
		return sistemasList;
	}

	public void setSistemasList(List<Sistema> sistemasList) {
		this.sistemasList = sistemasList;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

}
