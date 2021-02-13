package br.com.dsi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	// @Enumerated(EnumTyppe.STRING)
	// @ManyToOne
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String marca;
	private Double preco;

	public Produto(String descricao, String marca, Double preco) {
		super();
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
	}
	
	public Produto() {};

	// Getter&Setter
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id: " + id + ", descricao: " + descricao + ", marca: " + marca + ", preço: " + preco + "]";
	}
	
}
