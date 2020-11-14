package com.cristianoramos.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonBackReference//Do outro lado da associacao já foram buscados os objetos, então agora não busco mais. Vai omitir a lista de categorias p cada produto.
	//fazendo o mapeamento da lista de categorias:
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", //nome da tabela que ficará no meio de Produto e Categoria
	joinColumns = @JoinColumn(name = "produtos_id"),//nome da chave estrangeira correspondente a protudos
	inverseJoinColumns = @JoinColumn(name = "categoria_id")//nome da chave estrangeira correspondente a categoria
	)//Define qual ver a tabela que que vai fazer muitos p/ muitos na tabela relacional.
	private List<Categoria> categorias = new ArrayList<>();// não entra no construtor porque já foi iniciada
	
	public Produto() {
		
	}
	public Produto(Integer id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
