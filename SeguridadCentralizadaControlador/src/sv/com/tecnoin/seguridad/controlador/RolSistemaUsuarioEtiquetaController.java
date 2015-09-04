package sv.com.tecnoin.seguridad.controlador;

public class RolSistemaUsuarioEtiquetaController extends AbstractController{

	public RolSistemaUsuarioEtiquetaController(Class clase) {
		super(clase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
