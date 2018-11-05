package br.com.unidas.service;

import java.util.List;

import br.com.unidas.dao.GrupoCarrosDAO;
import br.com.unidas.entity.GrupoCarros;

public class GrupoCarrosService {
		
	private GrupoCarrosDAO dao = new GrupoCarrosDAO();
	 
    public List<GrupoCarros> buscaPorCategora(int categoria) {       
    	return dao.buscaPorCategora(categoria);
    }
    
    public List<GrupoCarros> buscaPorGrupo(String grupo) {       
    	return dao.buscaPorGrupo(grupo);
    }

}
