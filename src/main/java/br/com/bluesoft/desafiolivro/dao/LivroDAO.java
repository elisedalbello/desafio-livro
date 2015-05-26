package br.com.bluesoft.desafiolivro.dao;

import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafiolivro.model.Livro;

@Repository
public class LivroDAO extends AbstractDAO<Livro> {
	
	public LivroDAO() {
		super(Livro.class);
	}
	
}