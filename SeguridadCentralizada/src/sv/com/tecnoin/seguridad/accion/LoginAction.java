package sv.com.tecnoin.seguridad.accion;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import nl.captcha.Captcha;
import sv.com.tecnoin.seguridad.controlador.UsuarioController;
import sv.com.tecnoin.seguridad.entidad.Usuario;
import sv.com.tecnoin.seguridad.utilidades.Constantes;
import sv.com.tecnoin.seguridad.utilidades.Encriptacion;

/**
 * 
 * @author kpalacios
 *
 */
@UrlBinding("/acciones/index")
public class LoginAction extends BaseActionBean {

	private Usuario usuario;
	String password = "";

	@DefaultHandler
	public Resolution index() {

		return new ForwardResolution("/index.jsp");
	}

	public Resolution validar() {
		System.err.println("Loguenado Sistema....");
		Encriptacion encriptacion = new Encriptacion();
		Boolean validarCaptcha = Boolean.FALSE;
		String url = "";
		try {
			HttpSession session = getContext().getRequest().getSession();
			Captcha captchaSesion = (Captcha) session.getAttribute(Captcha.NAME);
			String captcha = getContext().getRequest().getParameter("captcha");
			if (captchaSesion.isCorrect(captcha)) {
				validarCaptcha = true;
			}

			if (!validarCaptcha) {
				mensajeError("El Captcha es incorrecto");
				url = "/index.jsp";
			} else {
				// Captcha si coincide
				String user = getContext().getRequest().getParameter("usuario");
				String pass = getContext().getRequest().getParameter("clave");
				UsuarioController unc = new UsuarioController();
				usuario = new Usuario();
				usuario.setUsuario(user);
				// Encrriptar clave
				password = encriptacion.getMD5(pass);
				usuario.setClave(password);
				Usuario userSession = new Usuario();
				userSession = unc.autenticarUsuario(usuario);
				if (userSession != null) {
					String passDefault = encriptacion.getMD5(Constantes.CLAVE_DEFAULT);
					if (password.trim().equals(passDefault.trim())) {
						url = "/acciones/generarClave";
						session.setAttribute("USUARIO", userSession);
						mensajeInfo("Este es su primer ingreso, Debe cambiar su clave");
					} else {
						System.out.println("creedenciales correctas");
						url = "/acciones/sistemas";
						session.setAttribute("USUARIO", userSession);
					}
				} else {
					mensajeError("El usuario o clave son incorrectos");
					System.out.println("creedenciales incorrectas");
					url = "/index.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ForwardResolution(url);

	}

	public Resolution logOut() {
		HttpSession session = getContext().getRequest().getSession();
		session.invalidate();
		System.out.println("Cerrando  sesi�n....");
		return new ForwardResolution("/index.jsp");
	}

	public Resolution resetearPassword() {
		UsuarioController unc = new UsuarioController();
		Encriptacion encriptacion = new Encriptacion();
		try {
			String user = getContext().getRequest().getParameter("usuario");
			Usuario usu = unc.validaUsuarioExiste(user);

			if (usu != null) {
				if (usu.getUsuario().equals(user)) {
					String passDefault = encriptacion.getMD5(Constantes.CLAVE_DEFAULT);
					usu.setClave(passDefault);
					unc.updateByClave(usu);
					mensajeInfo("Su nueva clave es: " + Constantes.CLAVE_DEFAULT);
				} else {
					mensajeError("El usuario no esta registrado");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ForwardResolution("/index.jsp");
	}
}
