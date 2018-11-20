package br.com.unidas.entity;

import java.util.Date;

public class Reserva {
	
	private int id;
	
	private Date dataRetirada;
	
	private Date dataDevolucao;
	
	private Endereco localRetirada;
	
	private Endereco localDevolucao;

	private Usuario usuario;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Endereco getLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(Endereco localRetirada) {
		this.localRetirada = localRetirada;
	}

	public Endereco getLocalDevolucao() {
		return localDevolucao;
	}

	public void setLocalDevolucao(Endereco localDevolucao) {
		this.localDevolucao = localDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/*private Filiais localRetirada;*/	
	
}
