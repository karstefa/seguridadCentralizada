package sv.com.tecnoin.seguridad.accion;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import sun.beans.editors.IntEditor;
import sv.com.tecnoin.seguridad.controlador.RolController;
import sv.com.tecnoin.seguridad.controlador.RolSistemaController;
import sv.com.tecnoin.seguridad.controlador.SistemaController;
import sv.com.tecnoin.seguridad.entidad.Opcion;
import sv.com.tecnoin.seguridad.entidad.Rol;
import sv.com.tecnoin.seguridad.entidad.RolSistema;
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
@UrlBinding("/acciones/sistemaOpcion")
public class mandoSistemaAction extends BaseActionBean {

	private List<Opcion> opcionList;
	private List<Rol> rolList;
	private RolSistema rolSistema;
	private List<RolSistema> rolesSistemaList;
	Sistema sistemaSelected = new Sistema();

	public mandoSistemaAction() {
	}

	@DefaultHandler
	public Resolution index() {
		HttpSession session = getContext().getRequest().getSession();
		rolList = new ArrayList<Rol>();
		sistemaSelected = new Sistema();
		try {
			String idSistema = getContext().getRequest().getParameter(
					"idSistema");
			String nombre = getContext().getRequest().getParameter("nombre");
			if (idSistema != null) {
				Sistema sis = new Sistema();
				sis.setIdSistema(Integer.parseInt(idSistema));
				sis.setNombre(nombre);
				session.setAttribute("sistemaSelected", sis);

			}
			RolController nc = new RolController();
			rolList = nc.findAll();
			sistemaSelected = (Sistema) session.getAttribute("sistemaSelected");
			RolSistema r = new RolSistema();
			// r.s(sistemaSelected.getIdSistema());
			// verRolesList = nc.findByIDSistema(r);

		} catch (Exception e) {
			e.printStackTrace();
			mensajeError("Error a realizar la busqueda");
		}

		ForwardResolution f = new ForwardResolution("/app/sistemaOpcion.jsp");
		return f;

	}

	public Resolution buscar() {
		String nombre = getContext().getRequest()
				.getParameter("nombreBusqueda");
		try {
			RolController rController = new RolController();
			rolList = rController.findByName(nombre);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
			;
		}
		ForwardResolution f = new ForwardResolution("/app/sistemaOpcion.jsp");

		return f;
	}

	public Resolution agregar() {
		HttpSession session = getContext().getRequest().getSession();
		sistemaSelected = new Sistema();
		String id = getContext().getRequest().getParameter("idRol");
		sistemaSelected = (Sistema) session.getAttribute("sistemaSelected");

		System.out.println("id - " + id);

		if (id == null || "0".equals(id) || id.isEmpty()) {
			try {
				System.out.println("Agregar Sistema....");
				rolSistema = new RolSistema();
				RolSistemaController rsController = new RolSistemaController();
				rolSistema.setRol(new Rol(Integer.parseInt(id)));
				rolSistema.setSistema(sistemaSelected);
				rsController.insert(rolSistema);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ForwardResolution f = new ForwardResolution("/app/sistemaOpcion.jsp");
		rolSistema = new RolSistema();
		index();
		return f;
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Opcion> getOpcionList() {
		return opcionList;
	}

	public void setOpcionList(List<Opcion> opcionList) {
		this.opcionList = opcionList;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public List<RolSistema> getRolesSistemaList() {
		return rolesSistemaList;
	}

	public void setVerRolesList(List<RolSistema> rolesSistemaList) {
		this.rolesSistemaList = rolesSistemaList;
	}

}
