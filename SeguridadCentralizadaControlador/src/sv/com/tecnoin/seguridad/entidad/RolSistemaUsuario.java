package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL_SISTEMA_USUARIO database table.
 * 
 */
@Entity
@Table(name="ROL_SISTEMA_USUARIO")
@NamedQuery(name="RolSistemaUsuario.findAll", query="SELECT r FROM RolSistemaUsuario r")
public class RolSistemaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdRolSistemaUsuario")
	private int idRolSistemaUsuario;

	//bi-directional many-to-one association to RolSistema
	@ManyToOne
	@JoinColumn(name="idRolSistema")
	private RolSistema rolSistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to RolSistemaUsuarioEtiqueta
	@OneToMany(mappedBy="rolSistemaUsuario")
	private List<RolSistemaUsuarioEtiqueta> rolSistemaUsuarioEtiquetas;

	public RolSistemaUsuario() {
	}

	public int getIdRolSistemaUsuario() {
		return this.idRolSistemaUsuario;
	}

	public void setIdRolSistemaUsuario(int idRolSistemaUsuario) {
		this.idRolSistemaUsuario = idRolSistemaUsuario;
	}

	public RolSistema getRolSistema() {
		return this.rolSistema;
	}

	public void setRolSistema(RolSistema rolSistema) {
		this.rolSistema = rolSistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<RolSistemaUsuarioEtiqueta> getRolSistemaUsuarioEtiquetas() {
		return this.rolSistemaUsuarioEtiquetas;
	}

	public void setRolSistemaUsuarioEtiquetas(List<RolSistemaUsuarioEtiqueta> rolSistemaUsuarioEtiquetas) {
		this.rolSistemaUsuarioEtiquetas = rolSistemaUsuarioEtiquetas;
	}

	public RolSistemaUsuarioEtiqueta addRolSistemaUsuarioEtiqueta(RolSistemaUsuarioEtiqueta rolSistemaUsuarioEtiqueta) {
		getRolSistemaUsuarioEtiquetas().add(rolSistemaUsuarioEtiqueta);
		rolSistemaUsuarioEtiqueta.setRolSistemaUsuario(this);

		return rolSistemaUsuarioEtiqueta;
	}

	public RolSistemaUsuarioEtiqueta removeRolSistemaUsuarioEtiqueta(RolSistemaUsuarioEtiqueta rolSistemaUsuarioEtiqueta) {
		getRolSistemaUsuarioEtiquetas().remove(rolSistemaUsuarioEtiqueta);
		rolSistemaUsuarioEtiqueta.setRolSistemaUsuario(null);

		return rolSistemaUsuarioEtiqueta;
	}

}