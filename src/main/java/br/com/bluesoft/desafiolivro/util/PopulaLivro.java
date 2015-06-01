package br.com.bluesoft.desafiolivro.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluesoft.desafiolivro.dao.LivroDAO;
import br.com.bluesoft.desafiolivro.model.Livro;

import com.google.common.collect.ImmutableList;

@Component
public class PopulaLivro {
	
	@Autowired
	private LivroDAO livroDAO;
	
	public PopulaLivro() {}
	
	public List<Livro> insereLivros() {
		Livro livro1 = new Livro("1984", "/pages/img/1984.jpg");
		Livro livro2 = new Livro("Guerra e Paz", "/pages/img/Guerra-e-Paz.jpg");
		Livro livro3 = new Livro("Lolita", "/pages/img/Lolita.jpg");
		Livro livro4 = new Livro("O Som e a Fúria", "/pages/img/O-Som-e-a-Furia.jpg");
		Livro livro5 = new Livro("Ulysses", "/pages/img/Ulysses.jpg");
		
		livroDAO.salvar(livro1);
		livroDAO.salvar(livro2);
		livroDAO.salvar(livro3);
		livroDAO.salvar(livro4);
		livroDAO.salvar(livro5);
		
		return ImmutableList.of(livro1, livro2, livro3, livro4, livro5);
	}
}
