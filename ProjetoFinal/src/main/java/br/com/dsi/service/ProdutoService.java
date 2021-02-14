package br.com.dsi.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.com.dsi.modelo.Produto;

import java.util.List;

public class ProdutoService {

	EntityManagerFactory emf; 
	
	public ProdutoService() {
		emf = Persistence.createEntityManagerFactory("banco");
	}	
	
	public boolean insert(Produto prod) {
		EntityManager em = emf.createEntityManager();
		try {
			// Inicia transação
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
			em.close();
		}catch (IllegalStateException  | RollbackException e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void update(Produto prodAlterado) {
		EntityManager em = emf.createEntityManager();
		try {
			Produto managed = find(prodAlterado.getId());

			em.getTransaction().begin();
			managed = prodAlterado;
			em.merge(managed);
			em.getTransaction().commit();
			em.close();
		}catch (IllegalStateException  | RollbackException e ) {
			e.printStackTrace();
		}
	}

	public void remove(Produto produto){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		produto = em.find(produto.getClass(), produto.getId());
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}

	public Produto find(Long id){
		EntityManager em = emf.createEntityManager();
		return em.find(Produto.class, id);
	}

	public List<Produto> findAll(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("FROM " + Produto.class.getName()).getResultList();
	}

	public void fecharConexao(){
		emf.close();
	}

}
