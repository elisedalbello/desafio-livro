package br.com.bluesoft.desafiolivro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.model.ComparacaoLivros;
import br.com.bluesoft.desafiolivro.model.Livro;

@Service
public class ComparacaoLivrosService {
	
	@Autowired
	LivroDAO dao;
	
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
	
	public ComparacaoLivros carregarComparacao(int i){
		
		List<ComparacaoLivros> comparacoes = carregarLivrosNaTela();
		
		Livro livroEsquerda = comparacoes.get(i).getLivroEsquerda();
		Livro livroDireita = comparacoes.get(i).getLivroDireita();
		
		ComparacaoLivros comparacao = new ComparacaoLivros(livroEsquerda, livroDireita);
		return comparacao;
	}

}
