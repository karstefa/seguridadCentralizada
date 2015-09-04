package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL_SISTEMA database table.
 * 
 */
@Entity
@Table(name="ROL_SISTEMA")
@NamedQuery(name="RolSistema.findAll", query="SELECT r FROM RolSistema r")
public class RolSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRolSistema;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="rolSistema")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	//bi-directional many-to-one association to Sistema
	@ManyToOne
	@JoinColumn(name="idSistema")
	private Sistema sistema;

	//bi-directional many-to-one association to RolSistemaUsuario
	@OneToMany(mappedBy="rolSistema")
	private List<RolSistemaUsuario> rolSistemaUsuarios;

	public RolSistema() {
	}

	public int getIdRolSistema() {
		return this.idRolSistema;
	}

	public void setIdRolSistema(int idRolSistema) {
		this.idRolSistema = idRolSistema;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setRolSistema(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setRolSistema(null);

		return opcion;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<RolSistemaUsuario> getRolSistemaUsuarios() {
		return this.rolSistemaUsuarios;
	}

	public void setRolSistemaUsuarios(List<RolSistemaUsuario> rolSistemaUsuarios) {
		this.rolSistemaUsuarios = rolSistemaUsuarios;
	}

	public RolSistemaUsuario addRolSistemaUsuario(RolSistemaUsuario rolSistemaUsuario) {
		getRolSistemaUsuarios().add(rolSistemaUsuario);
		rolSistemaUsuario.setRolSistema(this);

		return rolSistemaUsuario;
	}

	public RolSistemaUsuario removeRolSistemaUsuario(RolSistemaUsuario rolSistemaUsuario) {
		getRolSistemaUsuarios().remove(rolSistemaUsuario);
		rolSistemaUsuario.setRolSistema(null);

		return rolSistemaUsuario;
	}

}