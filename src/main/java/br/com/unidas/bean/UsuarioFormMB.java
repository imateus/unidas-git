package br.com.unidas.bean;

import static br.com.unidas.template.util.Assert.has;
import static br.com.unidas.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import br.com.unidas.entity.Usuario;
import br.com.unidas.security.LogonMB;
import br.com.unidas.service.UsuarioService;
import br.com.unidas.template.config.AdminConfig;

@Named
@ViewScoped
public class UsuarioFormMB implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Usuario usuario;
    private String email;
    private LogonMB logonMB;
    
    @Inject
    private AdminConfig adminConfig;

    private UsuarioService UsuarioService = new UsuarioService();

    public void init() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	email = (String) context.getExternalContext().getSessionMap().get("email");
    	
        if(Faces.isAjaxRequest()){
           return;
        }
        if (email != null) {
        	usuario = UsuarioService.findByEmail(email);
        } else {
        	usuario = new Usuario();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void remove() throws IOException {
        if (has(usuario) && has(usuario.getId())) {
            UsuarioService.delete(usuario);
            addDetailMessage("Usuario " + usuario.getNome()
                    + " removed successfully");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("Usuario-list.jsf");
        }
    }

    public void save() throws IOException, SQLException {
        String msg;
        
        if (!validaCadastro()) {
			return;
		}
        
        if (usuario.getId() == null) {        	
        	usuario.setId(null);
        	
        	try {
        		UsuarioService.saveOrUpdate(usuario);
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao salvar usuário"));
				return;
			}        	
        	
        	/**Efetua login após cadastro*/
        	FacesContext context = FacesContext.getCurrentInstance();
        	context.getExternalContext().getSessionMap().put("email", usuario.getEmail());
            addDetailMessage("<b>" + usuario.getEmail() + "</b> logado com sucesso");
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            Faces.redirect(adminConfig.getIndexPage());        	
        	msg = "Usuário " + usuario.getNome() + " salvo com sucesso"; 
       } else {
	       	try {
	    		UsuarioService.saveOrUpdate(usuario);
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao salvar usuário"));
				return;
			}    
            msg = "Usuário " + usuario.getNome() + " alterado com sucesso";
        }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, msg));
    }
    
    private boolean validaCadastro() {
    	if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento do Nome é obrigatório"));
			return false;
		}
    	
    	if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento da senha é obrigatório"));
			return false;
		}
    	
    	if (usuario.getDataNascimento() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento da Data de Nascimento é o obrigatório"));
			return false;
		}
    	
       	if (usuario.getCategoriaCnh() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento da Categoria da CNH é o obrigatório"));
			return false;
		}
       	
       	if (usuario.getGenero() == null  || usuario.getSenha().isEmpty()) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento do Gênero é o obrigatório"));
			return false;
		}
       	
       	if (usuario.getEmail() == null  || usuario.getSenha().isEmpty()) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento do Email é o obrigatório"));
			return false;
		}
       	
       	if (usuario.getNumeroCnh() == null  || usuario.getSenha().isEmpty()) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento do Número da CNH é o obrigatório"));
			return false;
		}
       	
       	if (usuario.getValidadeCnh() == null) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento da Validade da CNH é o obrigatório"));
			return false;
		}
    	
       	if (usuario.isEstrangeiro() && (usuario.getPassaporte() == null  || usuario.getSenha().isEmpty())) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preenchimento do Passaporte é o obrigatório"));
			return false;
		}
       	
    	return true;
    }
    
    public void clear() {
    	usuario = new Usuario();
        id = null;
    }

    public boolean isNew() {
        return usuario == null || usuario.getId() == null;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
