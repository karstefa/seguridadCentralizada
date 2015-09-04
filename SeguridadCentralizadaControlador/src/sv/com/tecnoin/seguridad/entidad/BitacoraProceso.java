package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BITACORA_PROCESO database table.
 * 
 */
@Entity
@Table(name="BITACORA_PROCESO")
@NamedQuery(name="BitacoraProceso.findAll", query="SELECT b FROM BitacoraProceso b")
public class BitacoraProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBitacoraProceso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hora")
	private Date fechaHora;

	@Lob
	private String proceso;

	//bi-directional many-to-one association to Sesion
	@ManyToOne
	@JoinColumn(name="idSesion")
	private Sesion sesion;

	public BitacoraProceso() {
	}

	public int getIdBitacoraProceso() {
		return this.idBitacoraProceso;
	}

	public void setIdBitacoraProceso(int idBitacoraProceso) {
		this.idBitacoraProceso = idBitacoraProceso;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

}