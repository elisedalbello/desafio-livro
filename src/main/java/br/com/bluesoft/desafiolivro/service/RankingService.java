package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.RankingDAO;
import br.com.bluesoft.desafiolivro.model.Ranking;

@Service
public class RankingService {
	
	@Autowired
	RankingDAO dao;
	
	public Ranking salvar(Ranking ranking){
		dao.salvar(ranking);
		return ranking;
	}

	public List<Ranking> recuperarRanking() {
		return dao.obter();
	}
}
