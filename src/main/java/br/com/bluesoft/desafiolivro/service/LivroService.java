package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
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

}
