package br.com.unidas.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.unidas.entity.GrupoCarros;
import br.com.unidas.service.GrupoCarrosService;

@ManagedBean
@ViewScoped
public class DetalheGrupoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GrupoCarros grupo;

	private GrupoCarrosService service = new GrupoCarrosService();
	
    @PostConstruct
    public void init() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	grupo = service.buscaPorGrupo((String) context.getExternalContext().getSessionMap().get("grupo")).get(0);
    }
	
	public GrupoCarros getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoCarros grupo) {
		this.grupo = grupo;
	}
		
}
