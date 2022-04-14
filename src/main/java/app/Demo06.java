package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
		//listado de todos los usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//select * from tb_usuarios
		//TypedQuery<Usuario> consulta = em.createQuery("select a from Usuario a",Usuario.class);
		//List<Usuario> listaUsuario = consulta.getResultList();
		
		List<Usuario> listaUsuario = em.createQuery("select a from Usuario a",Usuario.class).getResultList();
		
		for (Usuario usuario : listaUsuario) {
			System.out.println(usuario);
		}
		
		em.close();
	}
}
