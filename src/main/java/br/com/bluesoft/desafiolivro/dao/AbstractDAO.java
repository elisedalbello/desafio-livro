package br.com.bluesoft.desafiolivro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractDAO<T> {
	
	@Autowired
	private EntityManagerFactory emf; 
	
	private Class<T> clazz;
	
	public AbstractDAO() {}
		
	public AbstractDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public T salvar(T t){
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(t);
		tx.commit();
		return t;		
	}
	
	public List<T> obter(){
		 return getEntityManager().createQuery("from " + clazz.getName()).getResultList();
	}
	
	public void deleta() {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
				
		transaction.begin();
		Query query = manager.createQuery("delete from " + clazz.getName());
		query.executeUpdate();
		transaction.commit();
	}
}
