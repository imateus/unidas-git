package br.com.unidas.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.unidas.entity.GrupoCarros;

public class GrupoCarrosDAO {
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();	
	
	@SuppressWarnings("unchecked")
	public List<GrupoCarros> listAll() {
		Session session = connectionFactory.getSession();
		try {			
			return (List<GrupoCarros>) session.createQuery("FROM GrupoCarros").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoCarros> buscaPorCategora(Integer categoria){		
		Session session = connectionFactory.getSession();
		String sql = "from GrupoCarros where categoria = :categoria ";
		
		try {
			Query<?> query = session.createQuery(sql).setParameter("categoria", categoria);		
			return (List<GrupoCarros>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoCarros> buscaPorGrupo(String grupo){		
		Session session = connectionFactory.getSession();
		String sql = "from GrupoCarros where grupo = :grupo ";
		
		try {
			Query<?> query = session.createQuery(sql).setParameter("grupo", grupo);		
			return (List<GrupoCarros>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
}
