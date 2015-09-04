package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the REGISTRO_LOG database table.
 * 
 */
@Entity
@Table(name="REGISTRO_LOG")
@NamedQuery(name="RegistroLog.findAll", query="SELECT r FROM RegistroLog r")
public class RegistroLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRegistroLog;

	private String accion;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hora")
	private Date fechaHora;

	//bi-directional many-to-one association to Sesion
	@ManyToOne
	@JoinColumn(name="idSesion")
	private Sesion sesion;

	public RegistroLog() {
	}

	public int getIdRegistroLog() {
		return this.idRegistroLog;
	}

	public void setIdRegistroLog(int idRegistroLog) {
		this.idRegistroLog = idRegistroLog;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

}