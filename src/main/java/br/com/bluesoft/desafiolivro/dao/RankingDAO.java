package br.com.bluesoft.desafiolivro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafiolivro.model.Ranking;
import br.com.bluesoft.desafiolivro.model.Usuario;

@Repository
public class RankingDAO  extends AbstractDAO<Ranking>{
	
	@Autowired
	private EntityManagerFactory emf; 
	
	public RankingDAO() {
		super(Ranking.class);
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<Ranking> obterPeloIdUsuario(Usuario usuario){
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<Ranking> rankingUsuario  = new ArrayList<>();
		
		tx.begin();

		String sql = "select r from Ranking r join r.usuario u where u.id = :usuarioId";
		Query query = em.createQuery(sql);
		query.setParameter("usuarioId", usuario.getId());
		
		rankingUsuario = query.getResultList();
		
		tx.commit();
		
		return rankingUsuario;
	}
}