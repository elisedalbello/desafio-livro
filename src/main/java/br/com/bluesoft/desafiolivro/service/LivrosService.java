package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.model.Livro;

@Service
public class LivrosService {
	private int i;
	private int j;

	@Autowired
	LivroDAO dao;

	public Livro salvar(Livro livro) {
		dao.salvar(livro);
		return livro;

	}

	public List<Livro> recuperarLivros() {
		return dao.obter();
	}

	public Livro recuperarLivroPeloID(int k) {
		return dao.obterPeloID(k);
	}

	public List<Livro> carregarLivrosNaTela() {
		List<Livro> livros = dao.obter();

		for (i = 1; i <= livros.size(); i++) {

			for (j = i + 1; j <= livros.size(); j++) {
				Livro livroEsquerda = dao.obterPeloID(i);
				System.out.println("+++++++++++++++++" + livroEsquerda);
				Livro livroDireita = dao.obterPeloID(j);
				System.out.println("-----------------" + livroDireita);
				
			}
		}
		return null;
	}

	public void deletaLivros() {
		dao.deleta();
	}

}
