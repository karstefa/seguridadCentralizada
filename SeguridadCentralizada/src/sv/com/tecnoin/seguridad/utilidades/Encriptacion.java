package sv.com.tecnoin.seguridad.utilidades;

import java.io.Serializable;
import java.security.MessageDigest;

/**
 * 
 * @author kpalacios
 *
 */
public class Encriptacion implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    public static String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Encriptado de una cadena a MD5
     *
     * @param cadena
     * @return
     * @throws Exception
     */
    public String getMD5(String cadena) throws Exception {
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] b = md.digest(cadena.getBytes());

	    int size = b.length;
	    StringBuilder h = new StringBuilder(size);
	    for (int i = 0; i < size; i++) {

		int u = b[i] & 255;

		if (u < 16) {
		    h.append("0").append(Integer.toHexString(u));
		} else {
		    h.append(Integer.toHexString(u));
		}
	    }
	    return h.toString();
	} catch (Exception e) {
	    e.printStackTrace();
	    return "";
	}
    }

}
