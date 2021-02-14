package br.com.dsi.principal;

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
	

	}
	
}






