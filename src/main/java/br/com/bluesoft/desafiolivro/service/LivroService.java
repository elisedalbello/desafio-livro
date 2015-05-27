package br.com.bluesoft.desafiolivro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.model.ComparacaoLivros;
import br.com.bluesoft.desafiolivro.model.Livro;

@Service
public class LivroService {

	@Autowired
	LivroDAO dao;

	public Livro salvar(Livro livro) {
		dao.salvar(livro);
		return livro;

	}

	public List<Livro> recuperarLivros() {
		return dao.listar();
	}

	public Livro recuperarLivroPeloID(int i) {
		return dao.obterPeloID(i);
	}
	
	public void deletaLivros() {
		dao.deleta();
	}

	public List<ComparacaoLivros> carregarLivrosNaTela() {
		int i;
		int j;
		List<Livro> livros = dao.listar();
		List<ComparacaoLivros> comparacoes = new ArrayList<>();
				
		for (i = 1; i <= livros.size(); i++) {
			for (j = i + 1; j <= livros.size(); j++) {
				
				//lista começa no 0...
				Livro livroEsquerda = livros.get(i-1);
				Livro livroDireita = livros.get(j-1);
				
				ComparacaoLivros comparacao = new ComparacaoLivros(livroEsquerda, livroDireita);
				comparacoes.add(comparacao);
			}
		}
		return comparacoes;
	}

}
