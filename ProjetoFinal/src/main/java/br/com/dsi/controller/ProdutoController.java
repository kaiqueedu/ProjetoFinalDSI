package br.com.dsi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dsi.modelo.Produto;
import br.com.dsi.service.ProdutoService;

public class ProdutoController {
	
	//private JanelaConsulta tela;
	//private Pessoa modelo;	
	ProdutoService pservice;
	
	public ProdutoController() {
		pservice = new ProdutoService();		
	}	
	
	public void inserirProduto(Produto prod) {
		if(prod == null) {
			return;
		}
		pservice.insert(prod);
		pservice.fecharConexao();
	}

	public void atualizarProtudo(Long id, Produto prodAlterado){
		if(id == null || prodAlterado == null) {
			return;
		}
		pservice.update(id, prodAlterado);
		pservice.fecharConexao();
	}

	public Produto buscarId(Long id){
		if(id == null){
			return null;
		}
		return pservice.find(id);
	}



}
