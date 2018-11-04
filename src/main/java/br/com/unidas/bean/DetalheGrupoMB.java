package br.com.unidas.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unidas.entity.GrupoCarros;

@ManagedBean
@ViewScoped
public class DetalheGrupoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GrupoCarros grupo;

	public GrupoCarros getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoCarros grupo) {
		this.grupo = grupo;
	}
		
}
