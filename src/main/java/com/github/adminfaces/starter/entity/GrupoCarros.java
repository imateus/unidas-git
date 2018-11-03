package com.github.adminfaces.starter.entity;

public class GrupoCarros {
	
	private String nome;
	
	private String descrição;
	
	private String nomeCarros;
	
	private boolean arCondicionado;
	
	private Integer portas;
	
	private boolean direcaoHidraulica;
	
	private boolean airBag;
	
	private boolean transmissaoManual;

	private TipoGrupo tipoGrupo;
	
	private Motor motor;
	
	private String foto;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
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

	public boolean isTransmissaoManual() {
		return transmissaoManual;
	}

	public void setTransmissaoManual(boolean transmissaoManual) {
		this.transmissaoManual = transmissaoManual;
	}

	public TipoGrupo getTipoGrupo() {
		return tipoGrupo;
	}

	public void setTipoGrupo(TipoGrupo tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
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
	
	
}
