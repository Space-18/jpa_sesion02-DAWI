package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		//eliminar v2
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager  em = fabrica .createEntityManager();
		
		//empezar transac
		em.getTransaction().begin();
		
		
		Usuario u = em.find(Usuario.class, 10);
		if (u==null) {
			System.out.println("Lo lamento, no encontramos el codigo ingresado");
		}else {
			em.remove(u);
			System.out.println("Eliminado codigo: " + u.getCodigo());
		}
		
		//process --> record table
		em.getTransaction().commit();
		em.close();
	}
}
