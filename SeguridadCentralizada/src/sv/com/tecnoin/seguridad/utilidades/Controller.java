package sv.com.tecnoin.seguridad.utilidades;

import java.util.List;

/**
 * 
 * @author kpalacios
 *
 * @param <T>
 */
public interface Controller<T> {

	public List<T> findAll() throws Exception;

	public List<T> findBy(T value) throws Exception;

	public T insert(T value) throws Exception;

	public T update(T value) throws Exception;

	public boolean delete(T value) throws Exception;

}
