package br.com.bluesoft.desafiolivro.dao;

import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafiolivro.model.Ranking;

@Repository
public class RankingDAO  extends AbstractDAO<Ranking>{
	
	public RankingDAO() {
		super(Ranking.class);
	}
	
}