package com.github.adminfaces.starter.service;

import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.starter.dao.GrupoCarrosDAO;
import com.github.adminfaces.starter.entity.GrupoCarros;

public class GrupoCarrosService {
		
	private GrupoCarrosDAO dao = new GrupoCarrosDAO();
	 
    public List<GrupoCarros> createGrupoCarros(int categoria) {       
    	return dao.buscaPorCategora(categoria);
    }	 	 	

}
