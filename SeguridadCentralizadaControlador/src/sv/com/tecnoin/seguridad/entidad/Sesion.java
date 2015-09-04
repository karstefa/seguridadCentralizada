package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SESION database table.
 * 
 */
@Entity
@Table(name="SESION")
@NamedQuery(name="Sesion.findAll", query="SELECT s FROM Sesion s")
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSesion;

	@Temporal(TemporalType.DATE)
	private Date fin;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	//bi-directional many-to-one association to BitacoraProceso
	@OneToMany(mappedBy="sesion")
	private List<BitacoraProceso> bitacoraProcesos;

	//bi-directional many-to-one association to RegistroLog
	@OneToMany(mappedBy="sesion")
	private List<RegistroLog> registroLogs;

	//bi-directional many-to-one association to Sistema
	@ManyToOne
	@JoinColumn(name="idSistema")
	private Sistema sistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Sesion() {
	}

	public int getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public List<BitacoraProceso> getBitacoraProcesos() {
		return this.bitacoraProcesos;
	}

	public void setBitacoraProcesos(List<BitacoraProceso> bitacoraProcesos) {
		this.bitacoraProcesos = bitacoraProcesos;
	}

	public BitacoraProceso addBitacoraProceso(BitacoraProceso bitacoraProceso) {
		getBitacoraProcesos().add(bitacoraProceso);
		bitacoraProceso.setSesion(this);

		return bitacoraProceso;
	}

	public BitacoraProceso removeBitacoraProceso(BitacoraProceso bitacoraProceso) {
		getBitacoraProcesos().remove(bitacoraProceso);
		bitacoraProceso.setSesion(null);

		return bitacoraProceso;
	}

	public List<RegistroLog> getRegistroLogs() {
		return this.registroLogs;
	}

	public void setRegistroLogs(List<RegistroLog> registroLogs) {
		this.registroLogs = registroLogs;
	}

	public RegistroLog addRegistroLog(RegistroLog registroLog) {
		getRegistroLogs().add(registroLog);
		registroLog.setSesion(this);

		return registroLog;
	}

	public RegistroLog removeRegistroLog(RegistroLog registroLog) {
		getRegistroLogs().remove(registroLog);
		registroLog.setSesion(null);

		return registroLog;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}