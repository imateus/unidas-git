package br.com.unidas.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.unidas.entity.Endereco;

public class EnderecoDAO {
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listAll() {
		Session session = connectionFactory.getSession();
		try {
			return (List<Endereco>) session.createQuery("FROM Endereco").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
