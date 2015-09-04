package sv.com.tecnoin.seguridad.accion;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import sv.com.tecnoin.seguridad.controlador.RolController;
import sv.com.tecnoin.seguridad.controlador.SistemaController;
import sv.com.tecnoin.seguridad.entidad.Rol;
import sv.com.tecnoin.seguridad.entidad.RolSistema;
import sv.com.tecnoin.seguridad.entidad.Sistema;
import sv.com.tecnoin.seguridad.entidad.Usuario;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/sistemaRol")
public class mandoUsuarioAction extends BaseActionBean {

	private List<Sistema> sistemaList;
	private List<Rol> rolList;
	private List<Sistema> sistemaByOpcList;
	private SistemaController sc;
	private RolController rc;
	private Usuario usuario;

	public mandoUsuarioAction() {
		usuario = new Usuario();
	}

	@DefaultHandler
	public Resolution index() {
		sc = new SistemaController();
		rc = new RolController();
		sistemaList = new ArrayList<Sistema>();
		rolList = new ArrayList<Rol>();
		HttpSession session = getContext().getRequest().getSession();
		try {
			String idUsuario = getContext().getRequest().getParameter("idUsuario");
			String nombreUsuario = getContext().getRequest().getParameter("nombreUsuario");
			if (!idUsuario.isEmpty() || idUsuario != null) {
				usuario.setIdUsuario(Integer.parseInt(idUsuario));
				usuario.setNombre(nombreUsuario);
				session.setAttribute("usuarioSelected", usuario);
			}
			Usuario u = (Usuario) session.getAttribute("usuarioSelected");
			sistemaList = sc.findAll();
			rolList = rc.findAll();
			sistemaByOpcList = sc.findAllByOpcionRol(u);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
		}

		ForwardResolution f = new ForwardResolution("/app/sistemaRol.jsp");
		return f;

	}

	public Resolution guardar() {
		try {
			String idSistema = getContext().getRequest().getParameter("idSistema");
			String idRol = getContext().getRequest().getParameter("idRol");

			if (!idSistema.isEmpty() || idSistema != null) {
				if (!idRol.isEmpty() || idRol != null) {
					RolSistema rolSistema = new RolSistema();
					//rolSistema.setIdRol(Integer.parseInt(idRol));
					//rolSistema.setIdSistema(Integer.parseInt(idSistema));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ForwardResolution f = new ForwardResolution("/app/sistemaRol.jsp");
		index();
		return f;
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Sistema> getSistemaList() {
		return sistemaList;
	}

	public void setSistemaList(List<Sistema> sistemaList) {
		this.sistemaList = sistemaList;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Sistema> getSistemaByOpcList() {
		return sistemaByOpcList;
	}

	public void setSistemaByOpcList(List<Sistema> sistemaByOpcList) {
		this.sistemaByOpcList = sistemaByOpcList;
	}

}
