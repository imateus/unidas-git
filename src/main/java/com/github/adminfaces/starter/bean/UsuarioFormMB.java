package com.github.adminfaces.starter.bean;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import com.github.adminfaces.starter.entity.Usuario;
import com.github.adminfaces.starter.service.UsuarioService;

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

    public void save() {
        String msg;
        if (usuario.getId() == null) {
        	usuario.setId(null);
        	UsuarioService.saveOrUpdate(usuario);
            msg = "Usuario " + usuario.getNome() + " Salvo com sucesso";
       } else {
            UsuarioService.saveOrUpdate(usuario);
            msg = "Usuario " + usuario.getNome() + " Alterado com sucesso";
        }
        addDetailMessage(msg);
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
