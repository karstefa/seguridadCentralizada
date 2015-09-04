package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRol;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to RolSistema
	@OneToMany(mappedBy="rol")
	private List<RolSistema> rolSistemas;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolSistema> getRolSistemas() {
		return this.rolSistemas;
	}

	public void setRolSistemas(List<RolSistema> rolSistemas) {
		this.rolSistemas = rolSistemas;
	}

	public RolSistema addRolSistema(RolSistema rolSistema) {
		getRolSistemas().add(rolSistema);
		rolSistema.setRol(this);

		return rolSistema;
	}

	public RolSistema removeRolSistema(RolSistema rolSistema) {
		getRolSistemas().remove(rolSistema);
		rolSistema.setRol(null);

		return rolSistema;
	}

}