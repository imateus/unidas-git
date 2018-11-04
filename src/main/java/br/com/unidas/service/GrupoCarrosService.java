package br.com.unidas.service;

import java.util.ArrayList;
import java.util.List;

import br.com.unidas.dao.GrupoCarrosDAO;
import br.com.unidas.entity.GrupoCarros;

public class GrupoCarrosService {
		
	private GrupoCarrosDAO dao = new GrupoCarrosDAO();
	 
    public List<GrupoCarros> createGrupoCarros(int categoria) {       
    	return dao.buscaPorCategora(categoria);
    }	 	 	

}
