package aplicativo;

import dominio.Pessoa;
import dominio.Vendedor;
import dominio.Cliente;

import java.util.ArrayList;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = emf.createEntityManager(); //Intancia o EntityManager
		
		Vendedor vendedor = new Vendedor("Gabriel", 20, 01);
		Cliente cliente = new Cliente("Rafael", 34, 01);
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		em.persist(vendedor);
		em.persist(cliente);
		
		Query consultaV = em.createQuery("select vendedor from Vendedor vendedor"); //consulta em jpql
		ArrayList<Vendedor> listaV = (ArrayList<Vendedor>) consultaV.getResultList();
		
		Query consultaC = em.createQuery("select cliente from Cliente cliente"); //consulta em jpql
		ArrayList<Cliente> listaC = (ArrayList<Cliente>) consultaC.getResultList();
		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
		
		for(Vendedor objV: listaV) {
			System.out.println(objV);
		}
		
		for(Cliente objC: listaC) {
			System.out.println(objC);
		}
	}			
}