package br.com.unidas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unidas.entity.Reserva;
import br.com.unidas.service.ReservaService;

@ManagedBean
@ViewScoped
public class MinhasReservasMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Reserva> reservas = new ArrayList<Reserva>();

	private ReservaService service = new ReservaService();
	
	private Integer id;
	
	private Date dataLocao;
	
	public MinhasReservasMB() {
		reservas = service.listAll();
	}
	
	public void consultaReserva() {
		this.reservas = new ArrayList<Reserva>();
		if (id != null) {
			reservas.add(service.findById(id));
			return;
		}
		
		if (dataLocao != null) {
			reservas.addAll(service.findByDataLocacao(dataLocao));
			return;
		}
		
		reservas = service.listAll();
		
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ReservaService getService() {
		return service;
	}

	public void setService(ReservaService service) {
		this.service = service;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLocao() {
		return dataLocao;
	}

	public void setDataLocao(Date dataLocao) {
		this.dataLocao = dataLocao;
	}
	
}
