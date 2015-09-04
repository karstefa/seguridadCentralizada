package sv.com.tecnoin.seguridad.controlador;

import sv.com.tecnoin.seguridad.entidad.Token;

public class TokenController extends AbstractController<Token> {

	public TokenController(Class clase) {
		super(Token.class);
	}

	@Override
	public String getNamePersistenceUnit() {
		return "SeguridadCentralizadaControlador";
	}

}
