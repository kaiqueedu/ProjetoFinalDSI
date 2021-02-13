package br.com.dsi.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.com.dsi.modelo.Produto;

public class ProdutoService {

	EntityManagerFactory emf; 
	
	public ProdutoService() {
		emf = Persistence.createEntityManagerFactory("produtos");
	}	
	
	public boolean insert(Produto prod) {
		EntityManager em = emf.createEntityManager();
		try {
			// Inicia transação
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
		}catch (IllegalStateException  | RollbackException e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void update(Long id, Produto prodAlterado) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Produto managed = find(id, em);
			managed = prodAlterado;
			em.getTransaction().commit();
		}catch (IllegalStateException  | RollbackException e ) {
			e.printStackTrace();

		}
	}

	public Produto find(Long id, EntityManager em){
		return em.find(Produto.class, id);
	}

	public void fecharConexao(){
		emf.close();
	}

}
