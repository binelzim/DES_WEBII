package aplicativo;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Passaporte;
import dominio.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("aula-jpa");
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			Pessoa pessoa1 = new Pessoa("Rafael");
			Passaporte passaporte1 = new Passaporte(1111111111L);
			
			Pessoa pessoa2 = new Pessoa("Gabriel");
			Passaporte passaporte2 = new Passaporte(2222222222L);
			
			pessoa1.setPassaporte(passaporte1);
			passaporte1.setPessoa(pessoa1);
			
			pessoa2.setPassaporte(passaporte2);
			passaporte2.setPessoa(pessoa2);
			
			em.persist(pessoa1);
			em.persist(passaporte1);
			
			em.persist(pessoa2);
			em.persist(passaporte2);
			
			Query consultaPessoa = em.createQuery("select pessoa from Pessoa pessoa");
			ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>)consultaPessoa.getResultList();
			
			Query consultaPassaporte = em.createQuery("select passaporte from Passaporte passaporte");
			ArrayList<Passaporte> listaPassaporte = (ArrayList<Passaporte>)consultaPassaporte.getResultList();
			
			em.getTransaction().commit();
			
			for(Pessoa objPessoa: listaPessoa) {
				System.out.println(objPessoa.toString());
			}
		
			for(Passaporte objPassaporte: listaPassaporte) {
				System.out.println(objPassaporte.toString());
			}
		}catch (Exception e){
			if(em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
			}
			if(emf != null) {
				emf.close();
			}
		}
	}
}
