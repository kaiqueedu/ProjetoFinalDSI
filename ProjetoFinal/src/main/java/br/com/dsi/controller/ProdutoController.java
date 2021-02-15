package br.com.dsi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dsi.modelo.Produto;
import br.com.dsi.service.ProdutoService;

import java.util.List;

public class ProdutoController {

	ProdutoService pservice;
	
	public ProdutoController() {
		pservice = new ProdutoService();		
	}	
	
	public void inserirProduto(Produto prod) {
		if(prod == null) {
			return;
		}
		pservice.insert(prod);
	}

	public void atualizarProtudo(Produto prodAlterado){
		if(prodAlterado == null) {
			return;
		}
		pservice.update(prodAlterado);
	}

	public List<Produto> buscaTodos(){
		return pservice.findAll();
	}

	public void removerProduto(Produto produto){
		if(produto == null){
			return;
		}
		pservice.remove(produto);
	}

	public Produto buscarId(Long id){
		if(id == null){
			return null;
		}
		return pservice.find(id);
	}

}
