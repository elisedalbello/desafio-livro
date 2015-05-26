package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.dao.UsuarioDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Ranking;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.util.PopulaLivro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/spring-context.xml"} )
public class RankingServiceTest {
	
	@Autowired
	RankingService service;
	
	@Autowired
	PopulaLivro popula;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	List<Livro> livros;
	@Before
	public void init(){
		livros = popula.insereLivros();
	}
	
	@Test
	public void deveSalvarORanking(){
		Usuario usuario = new Usuario("Elise", "elise@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Ranking ranking = new Ranking(livros.get(0), usuario);
		Ranking result = service.salvar(ranking);
		
		assertEquals("1984", result.getLivro().getNome());
		assertEquals("Elise", result.getUsuario().getNome());
		assertEquals("elise@email.com.br", result.getUsuario().getEmail());
	}

	@Test
	public void deveRecuperarTodosOsRankings(){
		Usuario usuario = new Usuario("Maria", "maria@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Ranking ranking = new Ranking(livros.get(1), usuario);
		service.salvar(ranking);
		
		List<Ranking> rankings = service.recuperarRanking();
		
		assertEquals(2, rankings.size());
		assertEquals("1984", rankings.get(0).getLivro().getNome());
		assertEquals("Guerra e Paz", rankings.get(1).getLivro().getNome());
		assertEquals("Elise", rankings.get(0).getUsuario().getNome());
		assertEquals("Maria", rankings.get(1).getUsuario().getNome());
	}
}