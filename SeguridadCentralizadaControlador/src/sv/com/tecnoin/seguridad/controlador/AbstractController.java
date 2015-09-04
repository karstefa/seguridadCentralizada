package sv.com.tecnoin.seguridad.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class AbstractController <E>{
	
	private Class clase;
	
	
	public AbstractController(Class clase){
		this.clase = clase;
	}
	
	
	public EntityManager getEntityManager(){
		//Iniciamos una nueva conexión con el nombre de la unidad de persistencia de la clase que heredará esta clase abstracta
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(getNamePersistenceUnit());
		//Asignamos el valor hacia nuestro atributo em
		return entityManagerFactory.createEntityManager();
	}
	
	
	public void insert(E entidad){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		//Creamos con persist el insert a la tabla
		em.persist(entidad);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(E entidad){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		//Creamos con merge la actualización de datos
		em.merge(entidad);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(E entidad){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		//Eliminamos con remove la entidad (Registro) de la base de datos
		em.remove(em.merge(entidad));
		em.getTransaction().commit();
		em.close();
	}
	
	
	public E findBy(Object id){
		EntityManager em = getEntityManager();
		try{
			return (E) em.find(clase, id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		
		
	}
	
	public List<E> findAll(){
		EntityManager em = getEntityManager();
		try{
			String jpql = "select a from "+ clase.getName() + " a";
			System.out.println(jpql);
			Query ojpql = em.createQuery(jpql);
			return ojpql.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
		
	}
	
	
	public abstract String getNamePersistenceUnit();

}
