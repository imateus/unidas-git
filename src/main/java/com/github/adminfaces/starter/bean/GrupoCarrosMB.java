package com.github.adminfaces.starter.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.github.adminfaces.starter.entity.GrupoCarros;
import com.github.adminfaces.starter.service.GrupoCarrosService;

@ManagedBean
@ViewScoped
public class GrupoCarrosMB implements Serializable {
 
    private List<GrupoCarros> grupoCarrosList;
 
    private GrupoCarros selectedGrupoCarros;
 
    private GrupoCarrosService service = new GrupoCarrosService();
 
    @PostConstruct
    public void init() {
    	grupoCarrosList = service.createGrupoCarros(4);
    }

	public List<GrupoCarros> getGrupoCarrosList() {
		return grupoCarrosList;
	}

	public void setGrupoCarrosList(List<GrupoCarros> grupoCarrosList) {
		this.grupoCarrosList = grupoCarrosList;
	}

	public GrupoCarros getSelectedGrupoCarros() {
		return selectedGrupoCarros;
	}

	public void setSelectedGrupoCarros(GrupoCarros selectedGrupoCarros) {
		this.selectedGrupoCarros = selectedGrupoCarros;
	}
    
}
