package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({ 
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
@NamedQuery(name = "Usuario.findUserPass", query = "SELECT u FROM Usuario u WHERE u.clave = :clave and u.usuario = :usuario"),
@NamedQuery(name = "Usuario.findByName", query = "SELECT u FROM Usuario u WHERE u.nombre like '%:nombre%'"),
@NamedQuery(name = "Usuario.findByUser", query = "SELECT u FROM Usuario u WHERE u.usuario like :usuario")})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	private String activo;

	private String apellidos;

	private String clave;

	private String nombre;

	private String usuario;

	// bi-directional many-to-one association to RolSistemaUsuario
	@OneToMany(mappedBy = "usuario")
	private List<RolSistemaUsuario> rolSistemaUsuarios;

	// bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy = "usuario")
	private List<Sesion> sesions;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<RolSistemaUsuario> getRolSistemaUsuarios() {
		return this.rolSistemaUsuarios;
	}

	public void setRolSistemaUsuarios(List<RolSistemaUsuario> rolSistemaUsuarios) {
		this.rolSistemaUsuarios = rolSistemaUsuarios;
	}

	public RolSistemaUsuario addRolSistemaUsuario(
			RolSistemaUsuario rolSistemaUsuario) {
		getRolSistemaUsuarios().add(rolSistemaUsuario);
		rolSistemaUsuario.setUsuario(this);

		return rolSistemaUsuario;
	}

	public RolSistemaUsuario removeRolSistemaUsuario(
			RolSistemaUsuario rolSistemaUsuario) {
		getRolSistemaUsuarios().remove(rolSistemaUsuario);
		rolSistemaUsuario.setUsuario(null);

		return rolSistemaUsuario;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setUsuario(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setUsuario(null);

		return sesion;
	}

}