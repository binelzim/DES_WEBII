package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Curso;
import dominio.Estudante;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
			em = emf.createEntityManager(); //Intancia o EntityManager
			
			em.getTransaction().begin();
	
			Curso objC1 = new Curso("Python");
			Curso objC2 = new Curso("Java");
			Curso objC3 = new Curso("C#");
			Curso objC4 = new Curso("JavaScript");
			
			em.persist(objC1);
			em.persist(objC2);
			em.persist(objC3);
			em.persist(objC4);
			
			Estudante objE1 = new Estudante("Rafael");
			Estudante objE2 = new Estudante("Gabriel");
			Estudante objE3 = new Estudante("Miguel");
			Estudante objE4 = new Estudante("Uriel");
					
			objE1.setCursos(Arrays.asList(objC1,objC2));
			objE2.setCursos(Arrays.asList(objC3,objC4));
			objE3.setCursos(Arrays.asList(objC1,objC2));
			objE4.setCursos(Arrays.asList(objC3,objC4));
			
			em.persist(objE1);
			em.persist(objE2);
			em.persist(objE3);
			em.persist(objE4);
			
			Query consultaEstudantes = em.createQuery("select estudante from Estudante estudante"); //consulta em jpql
			ArrayList<Estudante> listaEstudante = (ArrayList<Estudante>) consultaEstudantes.getResultList();
			
			Query consultaCursos = em.createQuery("select curso from Curso curso"); //consulta em jpql
			ArrayList<Curso> listaCurso = (ArrayList<Curso>) consultaCursos.getResultList();
			
			em.getTransaction().commit();//confirmar as alterações realizadas
			
			emf.close();
			em.close();
			
			for(Estudante objE: listaEstudante) {
				System.out.println(objE);
			}
			
			for(Curso objC: listaCurso) {
				System.out.println(objC);
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