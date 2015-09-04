package sv.com.tecnoin.seguridad.utilidades;

public class Test {

	public static void main(String[] args) {
		try {
			encriptarPass();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void encriptarPass() {
		String resp = "";
		try {
			Encriptacion encriptacion = new Encriptacion();
			String cadena = "123";

			resp = encriptacion.getMD5(cadena);
			System.out.println("resp " + resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
