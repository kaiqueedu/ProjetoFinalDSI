package br.com.dsi.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dsi.controller.ProdutoController;
import br.com.dsi.modelo.Produto;
import br.com.dsi.telas.JanelaPrincipal;

public class Main {
	
	//static EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new JanelaPrincipal();
            }
        });			
	}	
		
	public static void teste() {
		Produto p = new Produto("Nintendo Switch", "Nintend", 2500.0);
		Produto p1 = new Produto("PS4", "Sony", 2300.0);
		
		// Insert
		//salvarProduto(p2);
		
		// Update
		//Produto pu = em.find(Produto.class, 1L);
		//atualizaProduto(pu);	
		
		//Merge: serve para refazer o estado do produto para manager no jpa
		//mergeProduto();

		ProdutoController pc = new ProdutoController();
		//pc.inserirProduto(p);
		p.setMarca("Nintendo");
		p.setPreco(1700.0);
		pc.atualizarProtudo(p.getId(), p);

		System.out.println();
	
		emf.close();
	}

	private static void salvarProduto(Produto p) {		
		EntityManager em = emf.createEntityManager();
		
		// Inicia transação
		em.getTransaction().begin();		
		em.persist(p);
		em.getTransaction().commit();
	}
	
	private static void atualizaProduto(Produto p) {		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		p.setMarca("Nintendo");
		em.getTransaction().commit();		
	}
	
	private static void mergeProduto() {		
		EntityManager em = emf.createEntityManager();
		
		Produto p = new Produto("Notebook", "Acer", 3500.0);
		em.getTransaction().begin();
		em.merge(p);
		p.setDescricao("Notebook Nitro 5");
		em.getTransaction().commit();		
		
	}

	
}






