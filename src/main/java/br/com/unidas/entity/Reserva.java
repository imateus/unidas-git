package br.com.unidas.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "data_retirada")
	private Date dataRetirada;
	
	@Column(name = "data_devolucao")
	private Date dataDevolucao;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_retirada")
	private Endereco localRetirada;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_devolucao")
	private Endereco localDevolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@Column(name = "data_locacao")
	private Date dataLocacao;
	
	@Column(name = "valor_reserva")
	private BigDecimal valorReserva;
	
	@Column(name = "status_pagamento")
	private String statusPagamento;
	
	@Column(name = "grupo_carro")
	private String grupoCarro;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public BigDecimal getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(BigDecimal valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getGrupoCarro() {
		return grupoCarro;
	}

	public void setGrupoCarro(String grupoCarro) {
		this.grupoCarro = grupoCarro;
	}

}
