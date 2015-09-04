package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROL_SISTEMA_USUARIO_ETIQUETA database table.
 * 
 */
@Entity
@Table(name="ROL_SISTEMA_USUARIO_ETIQUETA")
@NamedQuery(name="RolSistemaUsuarioEtiqueta.findAll", query="SELECT r FROM RolSistemaUsuarioEtiqueta r")
public class RolSistemaUsuarioEtiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdRolSistemaUsuarioEtiqueta")
	private int idRolSistemaUsuarioEtiqueta;

	//bi-directional many-to-one association to RolSistemaUsuario
	@ManyToOne
	@JoinColumn(name="IdRolSistemaUsuario")
	private RolSistemaUsuario rolSistemaUsuario;

	//bi-directional many-to-one association to Etiqueta
	@ManyToOne
	@JoinColumn(name="idEtiqueta")
	private Etiqueta etiqueta;

	public RolSistemaUsuarioEtiqueta() {
	}

	public int getIdRolSistemaUsuarioEtiqueta() {
		return this.idRolSistemaUsuarioEtiqueta;
	}

	public void setIdRolSistemaUsuarioEtiqueta(int idRolSistemaUsuarioEtiqueta) {
		this.idRolSistemaUsuarioEtiqueta = idRolSistemaUsuarioEtiqueta;
	}

	public RolSistemaUsuario getRolSistemaUsuario() {
		return this.rolSistemaUsuario;
	}

	public void setRolSistemaUsuario(RolSistemaUsuario rolSistemaUsuario) {
		this.rolSistemaUsuario = rolSistemaUsuario;
	}

	public Etiqueta getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

}