package com.github.adminfaces.starter.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexMB {
    private List<String> images;

	@PostConstruct
	public void init() {
		images = new ArrayList<String>();

		images.add("https://emais.estadao.com.br/blogs/daniel-martins-de-barros/wp-content/uploads/sites/168/2018/08/il2705x.jpg");
		images.add("https://storage.googleapis.com/stateless-falauniversidades-co/2018/08/Caricatura-Charge-Candidatos-Presidencia-Fala-Universidades-5.jpg");
	}
 
    public List<String> getImages() {
        return images;
    }
}
