package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.model.Livro;

@Service
public class LivroService {

	@Autowired
	private LivroDAO dao;

	public Livro salvar(Livro livro) {
		dao.salvar(livro);
		return livro;

	}

	public List<Livro> listarLivros() {
		return dao.listar();
	}

	public Livro obterLivroPeloID(int livroID) {
		return dao.obterPeloID(livroID);
	}
	
	public void deletaLivros() {
		dao.deleta();
	}

}
