package sv.com.tecnoin.seguridad.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SISTEMA database table.
 * 
 */
@Entity
@Table(name="SISTEMA")
@NamedQueries({@NamedQuery(name="Sistema.findAll", query="SELECT s FROM Sistema s"),
	@NamedQuery(name="Sistema.findByName", query="SELECT s FROM Sistema s where s.nombre like '%:nombre%'")})

public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSistema;

	private String nombre;

	private String url;

	//bi-directional many-to-one association to RolSistema
	@OneToMany(mappedBy="sistema")
	private List<RolSistema> rolSistemas;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="sistema")
	private List<Sesion> sesions;

	//bi-directional many-to-one association to Token
	@OneToMany(mappedBy="sistema")
	private List<Token> tokens;

	public Sistema() {
	}

	public int getIdSistema() {
		return this.idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RolSistema> getRolSistemas() {
		return this.rolSistemas;
	}

	public void setRolSistemas(List<RolSistema> rolSistemas) {
		this.rolSistemas = rolSistemas;
	}

	public RolSistema addRolSistema(RolSistema rolSistema) {
		getRolSistemas().add(rolSistema);
		rolSistema.setSistema(this);

		return rolSistema;
	}

	public RolSistema removeRolSistema(RolSistema rolSistema) {
		getRolSistemas().remove(rolSistema);
		rolSistema.setSistema(null);

		return rolSistema;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setSistema(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setSistema(null);

		return sesion;
	}

	public List<Token> getTokens() {
		return this.tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Token addToken(Token token) {
		getTokens().add(token);
		token.setSistema(this);

		return token;
	}

	public Token removeToken(Token token) {
		getTokens().remove(token);
		token.setSistema(null);

		return token;
	}

}