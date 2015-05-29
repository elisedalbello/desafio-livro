package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.dao.RankingDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Ranking;

@Service
public class RankingService {
	
	@Autowired
	RankingDAO dao;
	
	@Autowired
	LivroDAO livroDAO;
	
	public Ranking salvar(int livroId){
		Livro livro = livroDAO.obterPeloID(livroId);
		Ranking ranking = new Ranking();
		ranking.setLivro(livro);
				
		dao.salvar(ranking);
		return ranking;
	}

	public List<Ranking> recuperarRanking() {
		return dao.listar();
	}

	public Ranking salvarComUsuario(Ranking ranking) {
		System.out.println("***************************" + ranking);
		dao.salvar(ranking);
		return ranking;
	}
}
