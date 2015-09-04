package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ETIQUETA database table.
 * 
 */
@Entity
@Table(name = "ETIQUETA")
@NamedQueries({
@NamedQuery(name = "Etiqueta.findAll", query = "SELECT e FROM Etiqueta e"),
@NamedQuery(name = "Etiqueta.findByName", query = "SELECT e FROM Etiqueta e WHERE e.nombre LIKE '%:nombre%'")})
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEtiqueta;

	private String descripcion;

	private String nombre;

	// bi-directional many-to-one association to RolSistemaUsuarioEtiqueta
	@OneToMany(mappedBy = "etiqueta")
	private List<RolSistemaUsuarioEtiqueta> rolSistemaUsuarioEtiquetas;

	public Etiqueta() {
	}

	public int getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolSistemaUsuarioEtiqueta> getRolSistemaUsuarioEtiquetas() {
		return this.rolSistemaUsuarioEtiquetas;
	}

	public void setRolSistemaUsuarioEtiquetas(
			List<RolSistemaUsuarioEtiqueta> rolSistemaUsuarioEtiquetas) {
		this.rolSistemaUsuarioEtiquetas = rolSistemaUsuarioEtiquetas;
	}

	public RolSistemaUsuarioEtiqueta addRolSistemaUsuarioEtiqueta(
			RolSistemaUsuarioEtiqueta rolSistemaUsuarioEtiqueta) {
		getRolSistemaUsuarioEtiquetas().add(rolSistemaUsuarioEtiqueta);
		rolSistemaUsuarioEtiqueta.setEtiqueta(this);

		return rolSistemaUsuarioEtiqueta;
	}

	public RolSistemaUsuarioEtiqueta removeRolSistemaUsuarioEtiqueta(
			RolSistemaUsuarioEtiqueta rolSistemaUsuarioEtiqueta) {
		getRolSistemaUsuarioEtiquetas().remove(rolSistemaUsuarioEtiqueta);
		rolSistemaUsuarioEtiqueta.setEtiqueta(null);

		return rolSistemaUsuarioEtiqueta;
	}

}