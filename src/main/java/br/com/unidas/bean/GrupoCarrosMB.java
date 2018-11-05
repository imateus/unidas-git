package br.com.unidas.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

import br.com.unidas.entity.GrupoCarros;
import br.com.unidas.service.GrupoCarrosService;

@ManagedBean
@ViewScoped
public class GrupoCarrosMB implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GrupoCarros> grupoCarrosListEconomico;    
    private List<GrupoCarros> grupoCarrosListIntermediario;    
    private List<GrupoCarros> grupoCarrosListExecutivo;    
    private List<GrupoCarros> grupoCarrosListSuv;    
    private List<GrupoCarros> grupoCarrosListUtilitarios;
 
    private GrupoCarros selectedGrupoCarros;
 
    private GrupoCarrosService service = new GrupoCarrosService();
 
    @PostConstruct
    public void init() {
    	grupoCarrosListEconomico = service.buscaPorCategora(1);
    	grupoCarrosListIntermediario = service.buscaPorCategora(2);
    	grupoCarrosListExecutivo = service.buscaPorCategora(3);
    	grupoCarrosListSuv = service.buscaPorCategora(4);
    	grupoCarrosListUtilitarios = service.buscaPorCategora(5);
    }

    
    public void redirectDetalheGrupo(GrupoCarros grupo) throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().getSessionMap().put("grupo", grupo.getGrupo());
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
