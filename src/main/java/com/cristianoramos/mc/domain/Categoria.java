package com.cristianoramos.mc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//objetos dela poderão ser convertidos em uma sequência de bytes, para q os objetos possam ser gravados em arquivos, trafegar em rede..
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id será a chave primária
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Definição estratégia de criação automática de ID
	private Integer id;
	private String nome;
	
	//Instancia objetos sem jogar nada para os atributos.
	public Categoria() {
		
	}
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	//Dois objetos são comparados pelo seu conteúdo e não pelo ponteiro de memória e compara obetos por valor.
	//normalmente usa ID para comparar, se o ID é diferente, os objetos também são
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}