package br.com.unidas.template.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.unidas.template.config.AdminConfig;

import static br.com.unidas.template.util.Assert.has;

import java.io.Serializable;

/**
 * Created by rmpestano on 07/01/17.
 */
@Named
@SessionScoped
public class SkinMB implements Serializable {

    private String skin;

    @Inject
    private AdminConfig adminConfig;

    @PostConstruct
    public void init() {
        skin = adminConfig.getSkin();
        if(!has(skin)) {
            skin = "skin-blue";
        }
    }

    public void changeSkin(String skin){
        this.skin = skin;
    }
    
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
