package sv.com.tecnoin.seguridad.accion;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import nl.captcha.Captcha;
import sv.com.tecnoin.seguridad.controlador.UsuarioController;
import sv.com.tecnoin.seguridad.entidad.Usuario;
import sv.com.tecnoin.seguridad.utilidades.Encriptacion;

/**
 * 
 * @author kpalacios
 * 
 */
@UrlBinding("/acciones/generarClave")
public class GenerarClaveAction extends BaseActionBean {

	private Usuario usuario;
	String password = null;

	@DefaultHandler
	public Resolution index() {

		return new ForwardResolution("/generarClave.jsp");
	}

	public Resolution generar() {
		Encriptacion encriptacion = new Encriptacion();
		Boolean validarCaptcha = Boolean.FALSE;
		String url = "";
		try {
			HttpSession session = getContext().getRequest().getSession();
			Captcha captchaSesion = (Captcha) session
					.getAttribute(Captcha.NAME);
			String captcha = getContext().getRequest().getParameter("captcha");
			if (captchaSesion.isCorrect(captcha)) {
				validarCaptcha = true;
			}

			if (!validarCaptcha) {
				mensajeError("El Captcha es incorrecto");
				url = "/generarClave.jsp";
			} else {
				// Captcha si coincide
				String clave = getContext().getRequest().getParameter("clave");
				String cclave = getContext().getRequest()
						.getParameter("cclave");
				String claveEncrip = encriptacion.getMD5(clave);

				usuario = new Usuario();
				usuario = (Usuario) session.getAttribute("USUARIO");
				if (clave.equals(cclave)) {
					if (usuario != null
							&& usuario.getClave().equals(claveEncrip)) {
						mensajeError("La clave debe ser distinta a la actual");
						url = "/generarClave.jsp";
					} else {
						UsuarioController unc = new UsuarioController();
						usuario.setClave(claveEncrip);
						unc.update(usuario);
						url = "/acciones/sistemas";
					}
				} else {
					mensajeError("Claves no coinciden");
					url = "/generarClave.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ForwardResolution(url);

	}

}
