package br.com.unidas.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;

import br.com.unidas.entity.GrupoCarros;
import br.com.unidas.service.GrupoCarrosService;

@ManagedBean
@ViewScoped
public class GrupoCarrosMB implements Serializable {
 
    private List<GrupoCarros> grupoCarrosListEconomico;    
    private List<GrupoCarros> grupoCarrosListIntermediario;    
    private List<GrupoCarros> grupoCarrosListExecutivo;    
    private List<GrupoCarros> grupoCarrosListSuv;    
    private List<GrupoCarros> grupoCarrosListUtilitarios;
 
    private GrupoCarros selectedGrupoCarros;
 
    private GrupoCarrosService service = new GrupoCarrosService();
 
    @PostConstruct
    public void init() {
    	grupoCarrosListEconomico = service.createGrupoCarros(1);
    	grupoCarrosListIntermediario = service.createGrupoCarros(2);
    	grupoCarrosListExecutivo = service.createGrupoCarros(3);
    	grupoCarrosListSuv = service.createGrupoCarros(4);
    	grupoCarrosListUtilitarios = service.createGrupoCarros(5);
    }

    
    public void redirectDetalheGrupo() throws IOException {
    	Faces.redirect("detalhe-grupo.jsf");
    }
    
	public List<GrupoCarros> getGrupoCarrosListEconomico() {
		return grupoCarrosListEconomico;
	}



	public void setGrupoCarrosListEconomico(List<GrupoCarros> grupoCarrosListEconomico) {
		this.grupoCarrosListEconomico = grupoCarrosListEconomico;
	}



	public List<GrupoCarros> getGrupoCarrosListIntermediario() {
		return grupoCarrosListIntermediario;
	}



	public void setGrupoCarrosListIntermediario(List<GrupoCarros> grupoCarrosListIntermediario) {
		this.grupoCarrosListIntermediario = grupoCarrosListIntermediario;
	}



	public List<GrupoCarros> getGrupoCarrosListExecutivo() {
		return grupoCarrosListExecutivo;
	}



	public void setGrupoCarrosListExecutivo(List<GrupoCarros> grupoCarrosListExecutivo) {
		this.grupoCarrosListExecutivo = grupoCarrosListExecutivo;
	}



	public List<GrupoCarros> getGrupoCarrosListSuv() {
		return grupoCarrosListSuv;
	}



	public void setGrupoCarrosListSuv(List<GrupoCarros> grupoCarrosListSuv) {
		this.grupoCarrosListSuv = grupoCarrosListSuv;
	}



	public List<GrupoCarros> getGrupoCarrosListUtilitarios() {
		return grupoCarrosListUtilitarios;
	}



	public void setGrupoCarrosListUtilitarios(List<GrupoCarros> grupoCarrosListUtilitarios) {
		this.grupoCarrosListUtilitarios = grupoCarrosListUtilitarios;
	}



	public GrupoCarros getSelectedGrupoCarros() {
		return selectedGrupoCarros;
	}

	public void setSelectedGrupoCarros(GrupoCarros selectedGrupoCarros) {
		this.selectedGrupoCarros = selectedGrupoCarros;
	}
    
}