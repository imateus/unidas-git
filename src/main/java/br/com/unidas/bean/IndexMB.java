package br.com.unidas.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

import br.com.unidas.entity.Endereco;
import br.com.unidas.entity.Reserva;
import br.com.unidas.entity.Usuario;
import br.com.unidas.service.EnderecoService;
import br.com.unidas.service.UsuarioService;

@ManagedBean
public class IndexMB {
    
	private List<String> images;
    private EnderecoService enderecoService = new EnderecoService();
    private Reserva reserva = new Reserva();
    private UsuarioService usuarioService = new UsuarioService();
    
	@PostConstruct
	public void init() {
		images = new ArrayList<String>();

		images.add("https://i.imgur.com/RkeSgco.jpg");
		images.add("https://i.imgur.com/ifu4FC0.png");
	}
 
    public List<String> getImages() {
        return images;
    }
    
    public List<Endereco> completeEnderecoContains(String query) {
        List<Endereco> allEndereco = enderecoService.listAll();
        List<Endereco> filteredEndereco = new ArrayList<Endereco>();
         
        for (int i = 0; i < allEndereco.size(); i++) {
        	Endereco endereco = allEndereco.get(i);
            if(endereco.getLogradouro().toLowerCase().contains(query.toLowerCase())) {
            	filteredEndereco.add(endereco);
            }
        }
         
        return filteredEndereco;
    }
    
    public boolean validateReserva() {
    	
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	String email = (String) context.getExternalContext().getSessionMap().get("email");
    	

        if (email == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Efetue o login para efetivar a reserva."));
    		return false;
        }
    	
    	if (reserva.getDataRetirada().after(reserva.getDataDevolucao())) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Data de devolução não pode inferior a data de retirada"));
    		return false;
		}
    	
    	if (reserva.getLocalRetirada() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Local de Retirada Obrigatório"));
			return false;
		}
    	
    	if (reserva.getDataRetirada() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Data de retirada Obrigatória"));
    		return false;
		}else if (reserva.getDataDevolucao().before(new Date())) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Data de devolução não pode ser inferior a data atual"));
    		return false;			
		}
    	
    	if (reserva.getDataDevolucao() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Data de devolução Obrigatória"));
    		return false;
		}else if (reserva.getDataDevolucao().before(new Date())) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Data de devolução não pode ser anterior a data atual"));
    		return false;			
		}
    	    
    	return true;
    }
    
    public void efetuarReserva() {
    	if(!validateReserva()) {
    		return;
    	}

    }
    
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
        
}