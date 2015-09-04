package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OPCION database table.
 * 
 */
@Entity
@Table(name="OPCION")
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOpcion;

	private String accion;

	private String nombre;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="Parent_idOpcion")
	private Opcion opcion;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="opcion")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to RolSistema
	@ManyToOne
	@JoinColumn(name="idRolSistema")
	private RolSistema rolSistema;

	public Opcion() {
	}

	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setOpcion(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setOpcion(null);

		return opcion;
	}

	public RolSistema getRolSistema() {
		return this.rolSistema;
	}

	public void setRolSistema(RolSistema rolSistema) {
		this.rolSistema = rolSistema;
	}

}