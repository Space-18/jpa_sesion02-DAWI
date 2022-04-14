package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		//valores del nuevo usuario
		Usuario us = new Usuario(11, "Sujeto", "Dos", "SujetoDos@demo.com", "345", "2000/01/15", 1, 1);
		
		//grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager  em = fabrica .createEntityManager();
		
		//empezar transac
		em.getTransaction().begin();
		
		//update table
		em.merge(us);//actualiza si existe, sino lo inserta
		
		//process --> record table
		em.getTransaction().commit();
		em.close();
	}
}
