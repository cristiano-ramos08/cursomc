package com.cristianoramos.mc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Juridíca");
	
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	//static porque será possível ser executada mesmo sem precisar instanciar o objeto. 
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido: " + cod);
	}
}
