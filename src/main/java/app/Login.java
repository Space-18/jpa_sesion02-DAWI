package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class Login {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//select * from tb_usuarios where idTipo = 1
		Query consulta = em.createNativeQuery("{call usp_validaAcceso (?,?)}",Usuario.class);
		consulta.setParameter(1,"U001@gmail.com");
		consulta.setParameter(2,"10001");
		
		Usuario user = (Usuario)consulta.getResultList();
		
		if (user == null) {
			System.out.println("Usuario no existe");
		}else {
			System.out.println("Hola " + user.getNombre() + "Bienvenido!!!");
			System.out.println("Tus datos son: " + user);
		}
		
		em.close();
	}
}
