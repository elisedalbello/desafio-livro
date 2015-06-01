package br.com.bluesoft.desafiolivro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.dao.RankingDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Ranking;
import br.com.bluesoft.desafiolivro.model.Usuario;

@Service
public class RankingService {
	
	@Autowired
	private RankingDAO dao;
	
	@Autowired
	private LivroDAO livroDAO;
	
	@Autowired
	private LivroService livroService;
	
	public Ranking salvar(int livroId){
		Livro livro = livroDAO.obterPeloID(livroId);
		Ranking ranking = new Ranking();
		ranking.setLivro(livro);
				
		dao.salvar(ranking);
		return ranking;
	}
	
	public Ranking salvarComUsuario(Ranking ranking) {
		dao.salvar(ranking);
		return ranking;
	}

	public List<Ranking> obterRanking() {
		return dao.listar();
	}
	
	public List<Ranking> obterRankingPor(Usuario usuario){
		return dao.obterPeloIdUsuario(usuario);
	}
	
	public Map<Livro, Integer> obterRankingGeralOrdenado(){
		List<Ranking> ranking = obterRanking();
		return ordenarRabking(ranking);
		
	}

	public Map<Livro, Integer> obterRankingUsuarioOrdenado(Usuario usuario){
		List<Ranking> ranking = obterRankingPor(usuario);
		return ordenarRabking(ranking);
	}
	
	private Map<Livro, Integer> ordenarRabking(List<Ranking> ranking) {
		Map<Livro, Integer> livroVoto = new HashMap<>();   
		
		for (Ranking r :  ranking) {
			Integer qtdVotos = livroVoto.get(r.getLivro());
			if(qtdVotos == null){
				qtdVotos = 0;
			}
			livroVoto.put(r.getLivro(), qtdVotos++);	
		}
		
		return livroVoto;
	}
	
	public void salvarRanking(Usuario usuario, List<Livro> livros) {
			for(Livro livro : livros){
				Ranking ranking = new Ranking(livro, usuario);
				salvarComUsuario(ranking);
			}
	}
	
}
