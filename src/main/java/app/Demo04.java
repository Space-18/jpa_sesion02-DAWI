package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		//obtener datos de un usuario segun el codigo
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager  em = fabrica .createEntityManager();
		
		//empezar transac
		em.getTransaction().begin();
		
		
		Usuario u = em.find(Usuario.class, 11);
		System.out.println(u);
		
		//process --> record table
		em.getTransaction().commit();
		em.close();
	}
}
