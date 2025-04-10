package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); 

		//Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = null; 
		
		try {
			//Intancia o EntityManager
			em = emf.createEntityManager(); 
			
			em.getTransaction().begin();
	
			// Inserir os objetos aqui!
			Produto objP1 = new Produto("SSD M2", 500);
			Produto objP2 = new Produto("HD SATA", 150);
			Produto objP3 = new Produto("SSD SATA", 200);
			Produto objP4 = new Produto("MEMORY CARD", 20);
			
			em.persist(objP1);
			em.persist(objP2);
			em.persist(objP3);
			em.persist(objP4);

			Cliente objC1 = new Cliente("Gabriel Henrique");
			Cliente objC2 = new Cliente("Rafael");
			Cliente objC3 = new Cliente("Vinicius");
			Cliente objC4 = new Cliente("Lucas");

			//

			Venda objV1 = new Venda(650);
			Venda objV2 = new Venda(350);
			Venda objV3 = new Venda(220);
			Venda objV4 = new Venda(520);

			//
			objV1.setProdutos(Arrays.asList(objP1,objP2));
			objV2.setProdutos(Arrays.asList(objP2,objP3));
			objV3.setProdutos(Arrays.asList(objP3,objP4));
			objV4.setProdutos(Arrays.asList(objP4,objP1));

			//
			objV1.setCliente(objC1); 
			objV2.setCliente(objC2); 
			objV3.setCliente(objC3); 
			objV4.setCliente(objC4); 

			//
			objC1.setVendas(Arrays.asList(objV1));
			objC2.setVendas(Arrays.asList(objV2));
			objC3.setVendas(Arrays.asList(objV3));
			objC4.setVendas(Arrays.asList(objV4));

			em.persist(objC1);
			em.persist(objC2);
			em.persist(objC3);
			em.persist(objC4);

			//
			
			em.persist(objV1);
			em.persist(objV2);
			em.persist(objV3);
			em.persist(objV4);

			Query consultaProduto = em.createQuery("select produto from Produto produto"); //consulta em jpql
			ArrayList<Produto> listaProduto = (ArrayList<Produto>) consultaProduto.getResultList();
			
			Query consultaCliente = em.createQuery("select cliente from Cliente cliente"); //consulta em jpql
			ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) consultaCliente.getResultList();

			Query consultaVenda = em.createQuery("select venda from Venda venda"); //consulta em jpql
			ArrayList<Venda> listaVenda = (ArrayList<Venda>) consultaVenda.getResultList();

			em.getTransaction().commit();//confirmar as alterações realizadas
			
			emf.close();
			em.close();
			
			// Inserir os laços for aqui!
			for(Produto objP: listaProduto) {
				System.out.println(objP);
			}
			
			for(Cliente objC: listaCliente) {
				System.out.println(objC);
			}
			for(Venda objV: listaVenda) {
				System.out.println(objV);
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
