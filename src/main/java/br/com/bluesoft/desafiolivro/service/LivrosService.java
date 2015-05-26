package br.com.bluesoft.desafiolivro.service;

import java.util.List;

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

	 public List<Livro> carregarLivrosNaTela(){
		 List<Livro> livros = dao.obter();
		 for(i = 1; i <= livros.size(); i++){
			 for(j = i+1; j <= livros.size(); j++){
				 System.out.println("Livros: " + i + " x " + j);
			 }
		 }
		 return null;
	 }

	public void deletaLivros() {
		dao.deleta();
	}

}
