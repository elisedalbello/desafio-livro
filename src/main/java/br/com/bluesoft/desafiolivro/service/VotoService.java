package br.com.bluesoft.desafiolivro.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.dao.VotoDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.model.Voto;

@Service
public class VotoService {
	
	@Autowired
	private VotoDAO dao;
	
	@Autowired
	private LivroDAO livroDAO;
	
	@Autowired
	private LivroService livroService;
	
	public Voto salvar(int livroId){
		Livro livro = livroDAO.obterPeloID(livroId);
		Voto voto = new Voto();
		voto.setLivro(livro);
				
		dao.salvar(voto);
		return voto;
	}
	
	public Voto salvarComUsuario(Voto voto) {
		dao.salvar(voto);
		return voto;
	}

	public List<Voto> obterVotos() {
		return dao.listar();
	}
	
	public Map<String, BigInteger> obterRankingGeralOrdenado(){
		
		return dao.obterRankingGeral();
	}

	public Map<String, BigInteger> obterRankingUsuarioOrdenado(Usuario usuario){
		
		return dao.obterRanking(usuario);
	}
	

	public void salvarVoto(Usuario usuario, List<Livro> livros) {
		for(Livro livro : livros){
			Voto ranking = new Voto(livro, usuario);
			salvarComUsuario(ranking);
		}
	}
	
}
