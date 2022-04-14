package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//eliminar usuario
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager  em = fabrica .createEntityManager();
		
		//empezar transac
		em.getTransaction().begin();
		
		//borrado logico, red flag
		//merge
		
		//borrado fisico, borra
		Usuario u = new Usuario(11, "Sujeto", "Dos", "SujetoDos@demo.com", "345", "2000/01/15", 1, 1);
		
		em.remove(u);
		
		//process --> record table
		em.getTransaction().commit();
		em.close();
	}
}
