package sv.com.tecnoin.seguridad.accion;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import sv.com.tecnoin.seguridad.controlador.UsuarioController;
import sv.com.tecnoin.seguridad.entidad.Usuario;
import sv.com.tecnoin.seguridad.utilidades.Constantes;
import sv.com.tecnoin.seguridad.utilidades.Encriptacion;

/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/usuario")
public class UsuarioAction extends BaseActionBean {
	private List<Usuario> usuarioList;
	private Usuario usu;

	public UsuarioAction() {

	}

	@DefaultHandler
	public Resolution index() {

		try {
			UsuarioController nc = new UsuarioController();
			usuarioList = nc.findAll();

		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
			;
		}

		ForwardResolution f = new ForwardResolution("/app/manto/usuario.jsp");
		return f;

	}

	public Resolution consultarr() {
		System.err.println("Logueando Usuario....");
		return new ForwardResolution("/app/manto/usuario.jsp");
	}

	public Resolution buscar() {
		String nombre = getContext().getRequest().getParameter("nombreBusqueda");
		try {
			UsuarioController nc = new UsuarioController();
			usuarioList = nc.findByName(nombre);
		} catch (Exception e) {
			mensajeError("Error a realizar la busqueda");
		}
		ForwardResolution f = new ForwardResolution("/app/manto/usuario.jsp");

		return f;
	}

	public Resolution agregar() throws Exception {
		UsuarioController nc = new UsuarioController();
		Encriptacion encriptacion = new Encriptacion();

		String id = getContext().getRequest().getParameter("idUsuario");
		String user = getContext().getRequest().getParameter("usuario");
		String nombres = getContext().getRequest().getParameter("nombre");
		String apellidos = getContext().getRequest().getParameter("apellido");
		String activo = getContext().getRequest().getParameter("activo");

		System.out.println("id - " + id);

		if (id == null || "0".equals(id) || id.isEmpty()) {
			try {
				// Clave por default
				String claveEncrip = encriptacion.getMD5(Constantes.CLAVE_DEFAULT);
				System.err.println("Agregar Usuario....");
				nc = new UsuarioController();
				usu = new Usuario();
				usu.setUsuario(user);
				usu.setClave(claveEncrip);
				usu.setNombre(nombres);
				usu.setApellidos(apellidos);
				usu.setActivo(activo);
				nc.insert(usu);

			} catch (Exception e) {
				if (e.getCause().toString().contains("Duplicate entry")) {
					mensajeError("Usuario " + usu.getUsuario() + ", ya existe!");
				} else {
					mensajeError("Error al guardar usuario " + usu.getUsuario());
				}
				e.printStackTrace();
			}
		} else {
			try {
				System.err.println("Modificar Usuario....");
				nc = new UsuarioController();
				Usuario u = new Usuario();
				u = new Usuario();
				u.setUsuario(user);
				u.setNombre(nombres);
				u.setApellidos(apellidos);
				u.setActivo(activo);
				u.setIdUsuario(Integer.parseInt(id));
				nc.update(u);

			} catch (Exception e) {
				e.printStackTrace();
				mensajeError("Error al actualizar usuario " + usu.getUsuario());
			}
		}

		ForwardResolution f = new ForwardResolution("/app/manto/usuario.jsp");
		usu = new Usuario();
		index();
		return f;
	}

	public Resolution borrar() {
		System.out.println("Borrar usuario...");
		int idUsuario = Integer.parseInt(getContext().getRequest().getParameter("idUsuarioDelete"));
		UsuarioController nc3 = new UsuarioController();
		Usuario u = nc3.findBy(idUsuario);
		try {
			nc3.delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ForwardResolution f = new ForwardResolution("/app/manto/usuario.jsp");
		usu = new Usuario();
		index();
		return f;
	}

	@Override
	public String toString() {
		return "UsuarioAction [usuList=" + usuarioList + "]";
	}

	// /////////////////////// Getters and Setters ////////////////////////////

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

}
