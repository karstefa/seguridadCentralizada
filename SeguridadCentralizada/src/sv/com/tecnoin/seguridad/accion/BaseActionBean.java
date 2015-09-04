package sv.com.tecnoin.seguridad.accion;

import java.util.ArrayList;
import java.util.List;

import sv.com.tecnoin.seguridad.utilidades.Mensaje;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 * 
 * @author kpalacios
 *
 */
public abstract class BaseActionBean implements ActionBean {
	private ActionBeanContext context;
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();

	public void setContext(ActionBeanContext context) {
		this.context = context;
	}

	public ActionBeanContext getContext() {
		return context;
	}

	public void mensajeError(String mensaje) {
		Mensaje m = new Mensaje();
		m.setMensaje(mensaje);
		m.setSeverity(3);
		mensajes.add(m);
	}

	public void mensajeInfo(String mensaje) {
		Mensaje m = new Mensaje();
		m.setMensaje(mensaje);
		m.setSeverity(1);
		mensajes.add(m);
	}

	public void mensajeWarn(String mensaje) {
		Mensaje m = new Mensaje();
		m.setMensaje(mensaje);
		m.setSeverity(2);
		mensajes.add(m);
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
