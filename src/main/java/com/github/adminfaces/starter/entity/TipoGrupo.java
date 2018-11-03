package com.github.adminfaces.starter.entity;

public enum TipoGrupo {
	Economico("Econômico"),
	Intermediario("Intermediário"),
	Executivo("Executivo"),
	SUV("SUV"),
	Utilitarios("Utilitários");
	
	public String descricao;

	TipoGrupo(String descricao) {
		this.descricao = descricao;
	}
}
