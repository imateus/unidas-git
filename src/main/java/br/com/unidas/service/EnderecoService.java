package br.com.unidas.service;

import java.util.List;

import br.com.unidas.dao.EnderecoDAO;
import br.com.unidas.entity.Endereco;

public class EnderecoService {
	
	private EnderecoDAO dao = new EnderecoDAO(); 
	
	public List<Endereco> listAll() {
		return dao.listAll();
	}
}
