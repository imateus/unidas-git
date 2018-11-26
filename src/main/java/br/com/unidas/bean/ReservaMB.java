package br.com.unidas.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;

import br.com.unidas.entity.Endereco;
import br.com.unidas.entity.GrupoCarros;
import br.com.unidas.entity.Reserva;
import br.com.unidas.entity.Usuario;
import br.com.unidas.service.EmailService;
import br.com.unidas.service.EnderecoService;
import br.com.unidas.service.ReservaService;
import br.com.unidas.service.UsuarioService;

@ManagedBean
@ViewScoped
public class ReservaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Reserva reserva = new Reserva();
	
	private ReservaService service = new ReservaService();
	
	private GrupoCarros grupoCarros = new GrupoCarros();
	
	private Usuario usuario = new Usuario();
	
	private UsuarioService usuarioService = new UsuarioService();
	
	private EnderecoService enderecoService = new EnderecoService(); 

	private EmailService emailService = new EmailService(); 
	
	private String numeroCartao;
	
	private String nomeTitular;
	
	private Date dataExpiracao;
	
	private Integer codigoSeguranca;
	
	private boolean saved = false;
	
	public ReservaMB() {
    	FacesContext context = FacesContext.getCurrentInstance();    	
    	String email = (String) context.getExternalContext().getSessionMap().get("email");    	
    	usuario = usuarioService.findByEmail(email);
    	
    	if (getSession().getAttribute("reserva") == null) {
    		reserva = new Reserva();
    		reserva.setId(null);
		}else {
			reserva = (Reserva) getSession().getAttribute("reserva");
			reserva.setId(null);
		}
    	
    	saved = false;
	}
	
    public void efetuarReserva() throws IOException {
    	if(validateReserva()) {
    		reserva.setDataLocacao(new Date());
    		reserva.setUsuario(getUsuario());
    		reserva.setId(null);
    		getSession().setAttribute("reserva", reserva);
    		Faces.redirect("grupo-carros-reserva.jsf");
    	}
    }
    
    public void salvarReserva() {
    	Reserva reserva = (Reserva) getSession().getAttribute("reserva");
    	reserva.setStatusPagamento("pago");
    	service.salvarReserva(reserva);
    	emailService.enviarEmailReserva(reserva);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Reserva salva com sucesso."));
    	getSession().setAttribute("reserva", null);
    	saved = true;
    }
	
    public void selecionarGrupo(GrupoCarros grupoCarros) throws IOException {
    	Reserva reservaAux = (Reserva) getSession().getAttribute("reserva");
    	reservaAux.setGrupoCarro(grupoCarros.getGrupo());
    	reservaAux.setStatusPagamento("pendente");
    	reservaAux.setValorReserva(new BigDecimal(((reservaAux.getDataDevolucao().getTime() - reservaAux.getDataLocacao().getTime()) / 86400000L) * grupoCarros.getPreco().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
    	reservaAux.setId(null);
    	
    	getSession().setAttribute("reserva", reservaAux);
    	
    	Faces.redirect("efetivar-reserva.jsf");
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
    	    
        if (usuario == null || usuario.getEmail() == null) {
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

    public void voltarGrupoCarros() throws IOException {
    	Faces.redirect("grupo-carros-reserva.jsf");
    }
    
    public HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
    
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public GrupoCarros getGrupoCarros() {
		return grupoCarros;
	}

	public void setGrupoCarros(GrupoCarros grupoCarros) {
		this.grupoCarros = grupoCarros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ReservaService getService() {
		return service;
	}

	public void setService(ReservaService service) {
		this.service = service;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public EnderecoService getEnderecoService() {
		return enderecoService;
	}

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Integer getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(Integer codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	
}
