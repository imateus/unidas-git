package br.com.unidas.security;

import static br.com.unidas.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import br.com.unidas.service.UsuarioService;
import br.com.unidas.template.config.AdminConfig;
import br.com.unidas.template.session.AdminSession;

@Named
@SessionScoped
@Specializes
@ManagedBean
public class LogonMB extends AdminSession implements Serializable {

	private static final long serialVersionUID = 1L;
	private String currentUser;
    private String email;
    private String password;
    private boolean remember;
    @Inject
    private AdminConfig adminConfig;    
    private UsuarioService usuarioService = new UsuarioService();
    private boolean esqueciSenha;
    private String style;
    
    @PostConstruct
    public void init() {
    	esqueciSenha = false;
    	style = new String();
    	FacesContext context = FacesContext.getCurrentInstance();
    	currentUser = (String) context.getExternalContext().getSessionMap().get("email");
    }
    
    public void login() throws IOException, SQLException {
        
    	if(!loginValidade()) {
    		return;
    	}
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().getSessionMap().put("email", email);
    	currentUser = email;
        addDetailMessage("Logged in successfully as <b>" + email + "</b>");
        Faces.getExternalContext().getFlash().setKeepMessages(true);
        Faces.redirect(adminConfig.getIndexPage()); 
    }

    public void showEsqueciSenha() {
    	style = "height: 215px;";
    	esqueciSenha = true;
    }
    
    public void showLogin() {
    	style = new String();
    	esqueciSenha = false;
    }
    
    public void enviarSenha() {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, usuarioService.recuperarSenha(getEmail()), null));
    	style = new String();
    	esqueciSenha = false;
    }
    
    public boolean loginValidade() throws SQLException {
    	if (getEmail() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail Obrigatório.", null));
    		return false;
		}else if(usuarioService.validadeEmailOrPass(getEmail(), null) == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail não cadastrado", null));
			return false;
		}
    	
    	if (getPassword() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha Obrigatório", null));
    		return false;
		}if(usuarioService.validadeEmailOrPass(getEmail(), getPassword())== null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e Senha inválido\nou\nusuário não cadastrado", null));
    		return false;
    	}
    	
    	return true;    	
    }
    
    @Override
    public boolean isLoggedIn() {

        return currentUser != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

	public boolean isEsqueciSenha() {
		return esqueciSenha;
	}

	public void setEsqueciSenha(boolean esqueciSenha) {
		this.esqueciSenha = esqueciSenha;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
    	
}
