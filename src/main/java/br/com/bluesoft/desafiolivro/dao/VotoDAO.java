package br.com.bluesoft.desafiolivro.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.model.Voto;

@Repository
public class VotoDAO  extends AbstractDAO<Voto>{
	
	@Autowired
	private EntityManagerFactory emf; 
	
	public VotoDAO() {
		super(Voto.class);
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<Voto> obterPeloIdUsuario(Usuario usuario){
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<Voto> votoUsuario  = new ArrayList<>();
		
		tx.begin();

		String hql = "select v from Voto v join v.usuario u where u.id = :usuarioId";
		Query query = em.createQuery(hql);
		query.setParameter("usuarioId", usuario.getId());
		
		votoUsuario = query.getResultList();
		
		tx.commit();
		
		return votoUsuario;
	}

	public Map<BigInteger, String> obterRanking(Usuario usuario) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Map<BigInteger, String> livroVoto = new LinkedHashMap<>();
		
		tx.begin();
		
		StringBuilder hql = new StringBuilder();
				
		hql.append("select count(v.livro_id) as qtd_votos, l.nome ");
		hql.append("from Voto v ");
		hql.append("left join Livro l on(v.livro_id = l.id) ");
		hql.append("left join Usuario u on(v.usuario_id = u.id) ");
		hql.append("where u.id = :usuarioId ");
		hql.append("group by v.livro_id, l.nome ");
		hql.append("order by count(v.livro_id) desc ");
		
		Query query = em.createNativeQuery(hql.toString());
		query.setParameter("usuarioId", usuario.getId());
		
		List<Object[]> list = query.getResultList();
		
		tx.commit();
		
		for (Object[]  result : list) {
			livroVoto.put((BigInteger) result[0], (String) result[1]);
		}
		
		return livroVoto;
	}
	
	public Map<BigInteger, String> obterRankingGeral(){
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Map<BigInteger, String> livroVoto = new LinkedHashMap<>();
		
		tx.begin();
		
		StringBuilder hql = new StringBuilder();
				
		hql.append("select count(v.livro_id) as qtd_votos, l.nome ");
		hql.append("from Voto v ");
		hql.append("left join Livro l on(v.livro_id = l.id) ");
		hql.append("left join Usuario u on(v.usuario_id = u.id) ");
		hql.append("group by v.livro_id, l.nome ");
		hql.append("order by count(v.livro_id) desc ");
		
		Query query = em.createNativeQuery(hql.toString());		
		List<Object[]> list = query.getResultList();
		
		tx.commit();
		
		for (Object[]  result : list) {
			livroVoto.put((BigInteger) result[0], (String) result[1]);
		}
		
		return livroVoto;
	}
}