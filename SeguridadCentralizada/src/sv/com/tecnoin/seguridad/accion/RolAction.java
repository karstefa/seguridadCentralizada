package sv.com.tecnoin.seguridad.accion;

import java.util.List;

import sv.com.tecnoin.seguridad.controlador.RolController;
import sv.com.tecnoin.seguridad.entidad.Rol;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/roles")
public class RolAction extends BaseActionBean {
	private List<Rol> rolList;
	private Rol rol;

	public RolAction() {

	}

	@DefaultHandler
	public Resolution index() {

		try {
			RolController nc = new RolController();
			rolList = nc.findAll();

		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
		}

		ForwardResolution f = new ForwardResolution("/app/manto/roles.jsp");
		return f;

	}

	public Resolution consultarr() {
		System.err.println("Logueando Rol....");
		return new ForwardResolution("/app/manto/roles.jsp");
	}

	public Resolution buscar() {
		String nombre = getContext().getRequest().getParameter("nombreBusqueda");
		try {
			RolController nc = new RolController();
			
			rolList = nc.findByName(nombre);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
			;
		}
		ForwardResolution f = new ForwardResolution("/app/manto/roles.jsp");

		return f;
	}

	public Resolution agregar() {
		RolController nc = new RolController();

		String id = getContext().getRequest().getParameter("idRol");
		String nombre = getContext().getRequest().getParameter("nombre");
		String descripcion = getContext().getRequest().getParameter("descripcion");
		String activo = getContext().getRequest().getParameter("activo");

		System.out.println("id - " + id);

		if (id == null || "0".equals(id) || id.isEmpty()) {
			try {
				System.err.println("Agregar Rol....");
				nc = new RolController();
				rol = new Rol();
				rol.setNombre(nombre);
				rol.setDescripcion(descripcion);
				rol.setEstado(activo);
				nc.insert(rol);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.err.println("Modificar Rol....");
				nc = new RolController();
				Rol s = new Rol();
				s.setNombre(nombre);
				s.setDescripcion(descripcion);
				s.setEstado(activo);
				s.setIdRol(Integer.parseInt(id));				
				nc.update(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ForwardResolution f = new ForwardResolution("/app/manto/roles.jsp");
		rol = new Rol();
		index();
		return f;
	}

	public Resolution borrar() {
		System.err.println("Borrar rol...");
		rol = new Rol();
		int idRol = Integer.parseInt(getContext().getRequest().getParameter("idRolDelete"));
		rol.setIdRol(idRol);
		RolController nc3 = new RolController();
		try {
			nc3.delete(rol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ForwardResolution f = new ForwardResolution("/app/manto/roles.jsp");
		rol = new Rol();
		index();
		return f;
	}

	@Override
	public String toString() {
		return "RolAction [rolList=" + rolList + "]";
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
