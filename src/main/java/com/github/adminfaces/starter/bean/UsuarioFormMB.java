package com.github.adminfaces.starter.bean;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import com.github.adminfaces.starter.entity.Usuario;
import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.starter.service.UsuarioService;
import com.github.adminfaces.template.config.AdminConfig;

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
        if (usuario.getId() == null) {
        	usuario.setId(null);
        	UsuarioService.saveOrUpdate(usuario);
        	
        	/**Efetua login após cadastro*/
        	FacesContext context = FacesContext.getCurrentInstance();
        	context.getExternalContext().getSessionMap().put("email", usuario.getEmail());
            addDetailMessage("Logged in successfully as <b>" + usuario.getEmail() + "</b>");
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            Faces.redirect(adminConfig.getIndexPage());        	
        	msg = "Usuario " + usuario.getNome() + " Salvo com sucesso"; 
       } else {
            UsuarioService.saveOrUpdate(usuario);
            msg = "Usuario " + usuario.getNome() + " Alterado com sucesso";
        }
        addDetailMessage(msg);
        Faces.refresh();
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
