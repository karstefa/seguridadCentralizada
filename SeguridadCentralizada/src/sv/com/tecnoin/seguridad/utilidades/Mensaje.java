package sv.com.tecnoin.seguridad.utilidades;

/**
 * 
 * @author kpalacios
 *
 */
public class Mensaje {
	private String mensaje = "";
	private int severity = 0;
	private String detalleMensaje = "";

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getDetalleMensaje() {
		return detalleMensaje;
	}

	public void setDetalleMensaje(String detalleMensaje) {
		this.detalleMensaje = detalleMensaje;
	}
}
