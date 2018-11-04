package br.com.unidas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class ConnectionFactory {
     
    public Session getSession(){
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	return sessionFactory.openSession();    	
    }
}