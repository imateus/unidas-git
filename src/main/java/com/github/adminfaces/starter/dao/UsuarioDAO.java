package com.github.adminfaces.starter.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.github.adminfaces.starter.entity.Usuario;

public class UsuarioDAO {

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
/*	public boolean validadeLogin(String email, String pass) throws SQLException {
		Connection conexao = (Connection) connectionFactory.createConnection();
		String sql = "select * from dblea.usuario where email = " + email + " and senha = " + pass;
		PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(sql);
		return ((ps.getResultSet()) != null ? true : false);
	}*/
	
	public Usuario validadeEmailOrPass(String email, String pass){
		
		Session session = connectionFactory.getSession();
		String sql = "from Usuario where 1=1";
		
		try {
		
		if (email==null && pass==null) {
			return null;
		}		

		if (email!=null) {
			sql += " and email = :email ";
		}

		if (pass!=null) {
			sql += " and senha = :pass ";
		}
				
		Query<?> query = session.createQuery(sql);
		
		if (email!=null) {
			query.setParameter("email", email);
		}
		
		if (pass!=null) {
			query.setParameter("pass", pass);
		}
		
		return (Usuario) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listAll() {
		Session session = connectionFactory.getSession();
		try {
			return (List<Usuario>) session.createQuery("FROM Usuario").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Usuario findById(Integer id){
		
		Session session = connectionFactory.getSession();
		String sql = "from Usuario where id = :id ";
		
		try {
				
		Query<?> query = session.createQuery(sql).setParameter("id", id);	
		
		return (Usuario) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public Usuario findByEmail(String email){
		
		Session session = connectionFactory.getSession();
		String sql = "from Usuario where email = :email ";
		
		try {
				
		Query<?> query = session.createQuery(sql).setParameter("email", email);	
		
		return (Usuario) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public void save(Usuario usuario) {
		Session session = connectionFactory.getSession();
		try {
			session.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void delete(Usuario usuario) {
		Session session = connectionFactory.getSession();
		try {
			session.delete(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
