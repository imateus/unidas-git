package com.github.adminfaces.starter.service;

import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.starter.entity.GrupoCarros;

public class GrupoCarrosService {
	  private final static String[] carros;
	  
	  private final static String[] names;
	  
	  private final static String[] descricao;
	  
	  private final static String[] fotos;
	 
	    static {
	        carros = new String[4];
	        carros[0] = "Peugeot 208 | Toyota Etios | Citroën C3 | ou similares";
	        carros[1] = "Renault KWID | Fiat Mobi | ou similares";
	        carros[2] = "Fiat Argo | Chevrolet Onix | Renault Sandero | ou similares";
	        carros[3] = "Nissan Versa | Renault Logan | Ford KA+ | ou similares";
	        
	        names = new String[4];
	        names[0] = "BM";
	        names[1] = "AM";
	        names[2] = "B";
	        names[3] = "BS";
	        
	        descricao = new String[4];
	        descricao[0] = "Hatch Médio Plus 1.2";
	        descricao[1] = "Hatch Compacto 1.0";
	        descricao[2] = "Hatch Médio 1.0";
	        descricao[3] = "Sedan Médio 1.0";
	        
	        fotos = new String[4];
	        fotos[0] = "https://www.unidas.com.br/media/2062/aluguel-de-carros-grupo-am-renault-kwid.png";
	        fotos[1] = "https://www.unidas.com.br/media/2065/aluguel-de-carros-grupo-bm-peugeot208.png";
	        fotos[2] = "https://www.unidas.com.br/media/2059/aluguel-de-carro-grupo-bs-nissan-versa.png";
	        fotos[3] = "https://www.unidas.com.br/media/2064/aluguel-de-carros-grupo-b-fiat-argo.png";
	    }
	 
	    public List<GrupoCarros> createGrupoCarros(int size) {
	        List<GrupoCarros> list = new ArrayList<GrupoCarros>();
	        for(int i = 0 ; i < size ; i++) {
	        	GrupoCarros grupo = new GrupoCarros();
	        	grupo.setNomeCarros(getCarros(i));
	        	grupo.setNome(getNames(i));
	        	grupo.setDescrição(getDescricao(i));
	        	grupo.setFoto(getFotos(i));
	        	list.add(grupo);
	        }
	 
	        return list;
	    }
	 
	 
	    private String getCarros(int i) {
	        return carros[i];
	    }
	 
	    private String getNames(int i) {
	        return names[i];
	    }
	    
	    private String getDescricao(int i) {
	        return descricao[i];
	    }
	 
	    private String getFotos(int i) {
	        return fotos[i];
	    }

}
