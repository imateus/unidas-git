package br.com.unidas.service;

import java.util.Date;
import java.util.List;

import br.com.unidas.dao.ReservaDAO;
import br.com.unidas.entity.Reserva;

public class ReservaService {
	
	private ReservaDAO dao = new ReservaDAO();
	
	public List<Reserva> listAll() {
		return dao.listAll();
	}
	
	public Reserva findById(Integer id){
		return dao.findById(id);
	}
	
	public List<Reserva> findByDataLocacao(Date dataLocacao){
		return dao.findByDataLocacao(dataLocacao);
	}
	
	public void salvarReserva(Reserva reserva) {
		dao.save(reserva);
	}
}
