package br.com.unidas.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.descriptor.java.BigDecimalTypeDescriptor;

@Entity
@Table(name = "grupo_carros")
public class GrupoCarros implements Serializable, Comparable<GrupoCarros> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "grupo")
	private String grupo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "carros")
	private String nomeCarros;
	
	@Column(name = "arcondicionado")
	private boolean arCondicionado;
	
	@Column(name = "qtd_portas")
	private Integer portas;
	
	@Column(name = "direcao_hidraulica")
	private boolean direcaoHidraulica;
	
	@Column(name = "airbag")
	private boolean airBag;
	
	@Column(name = "transmissao_automatica")
	private boolean transmissaoAutomatica;
	
	@Column(name = "motor")
	private Motor motor;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "categoria")
	private Integer categoria;

	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "preco")
	private BigDecimal preco;
		
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getGrupo() {
		return grupo;
	}



	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getNomeCarros() {
		return nomeCarros;
	}



	public void setNomeCarros(String nomeCarros) {
		this.nomeCarros = nomeCarros;
	}



	public boolean isArCondicionado() {
		return arCondicionado;
	}



	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}



	public Integer getPortas() {
		return portas;
	}



	public void setPortas(Integer portas) {
		this.portas = portas;
	}



	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}



	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}



	public boolean isAirBag() {
		return airBag;
	}



	public void setAirBag(boolean airBag) {
		this.airBag = airBag;
	}



	public boolean isTransmissaoAutomatica() {
		return transmissaoAutomatica;
	}



	public void setTransmissaoAutomatica(boolean transmissaoAutomatica) {
		this.transmissaoAutomatica = transmissaoAutomatica;
	}



	public Motor getMotor() {
		return motor;
	}



	public void setMotor(Motor motor) {
		this.motor = motor;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public Integer getCategoria() {
		return categoria;
	}



	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	@Override
	public int compareTo(GrupoCarros o) {
		return this.id.compareTo(o.getId());
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
}
