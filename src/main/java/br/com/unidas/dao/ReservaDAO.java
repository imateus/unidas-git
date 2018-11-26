package br.com.unidas.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.unidas.entity.Reserva;
import br.com.unidas.entity.Usuario;

public class ReservaDAO {
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@SuppressWarnings("unchecked")
	public List<Reserva> listAll() {
		Session session = connectionFactory.getSession();
		try {
			return (List<Reserva>) session.createQuery("FROM Reserva").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Reserva findById(Integer id){
		
		Session session = connectionFactory.getSession();
		String sql = "from Reserva where id = :id ";
		
		try {
				
		Query<?> query = session.createQuery(sql).setParameter("id", id);	
		
		return (Reserva) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> findByDataLocacao(Date dataLocacao){
		
		Session session = connectionFactory.getSession();
		String sql = "from Reserva where dataLocacao = :dataLocacao ";
		
		try {
				
		Query<?> query = session.createQuery(sql).setParameter("dataLocacao", dataLocacao);	
		
		return (List<Reserva>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public void save(Reserva reserva) {
		Transaction tx;
		Session session = connectionFactory.getSession();	
		tx = session.beginTransaction();
		try {
			session.saveOrUpdate(reserva);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
		
	}
}
