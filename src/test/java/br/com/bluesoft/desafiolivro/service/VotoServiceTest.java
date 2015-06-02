package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.dao.UsuarioDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.model.Voto;
import br.com.bluesoft.desafiolivro.util.PopulaLivro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/spring-context.xml"} )
public class VotoServiceTest {
	
	@Autowired
	private VotoService service;
	
	@Autowired
	private PopulaLivro popula;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private List<Livro> livros;
	@Before
	public void init(){
		livros = popula.insereLivros();
	}
	
	@Test
	public void deveSalvarOVoto(){
		Usuario usuario = new Usuario("Elise", "elise@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Voto voto = new Voto(livros.get(0), usuario);
		Voto result = service.salvarComUsuario(voto);
		
		assertEquals("1984", result.getLivro().getNome());
		assertEquals("Elise", result.getUsuario().getNome());
		assertEquals("elise@email.com.br", result.getUsuario().getEmail());
	}

	@Test
	public void deveListarTodosOsVotos(){
		Usuario usuario = new Usuario("Maria", "maria@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Voto voto = new Voto(livros.get(1), usuario);
		service.salvarComUsuario(voto);
		
		List<Voto> votos = service.obterVotos();
		
		assertEquals(8, votos.size());
		assertEquals("1984", votos.get(0).getLivro().getNome());
		assertEquals("Maria", votos.get(0).getUsuario().getNome());
		assertEquals("1984", votos.get(1).getLivro().getNome());
		assertEquals("Maria", votos.get(1).getUsuario().getNome());
	}
	
	@Test
	public void deveObterRankingOrdenado(){
		Usuario usuario = new Usuario("Elise", "elise@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Voto voto1 = new Voto(livros.get(0), usuario);
		Voto voto2 = new Voto(livros.get(0), usuario);
		Voto voto3 = new Voto(livros.get(0), usuario);
		
		Voto voto4 = new Voto(livros.get(1), usuario);
		Voto voto5 = new Voto(livros.get(1), usuario);
		
		Voto voto6 = new Voto(livros.get(2), usuario);
		
		service.salvarComUsuario(voto1);
		service.salvarComUsuario(voto2);
		service.salvarComUsuario(voto3);
		service.salvarComUsuario(voto4);
		service.salvarComUsuario(voto5);
		service.salvarComUsuario(voto6);
		
		
		
		Map<String, BigInteger> ranking = new LinkedHashMap<String, BigInteger>();
		
		ranking = service.obterRankingUsuarioOrdenado(usuario);
		
		assertEquals(BigInteger.valueOf(3L), ranking.get(livros.get(0).getNome()));
		assertEquals(BigInteger.valueOf(2L), ranking.get(livros.get(1).getNome()));
		assertEquals(BigInteger.valueOf(1L), ranking.get(livros.get(2).getNome()));
	}
	
	@Test
	public void deveObterRankingGeralOrdenado(){
		Usuario usuario = new Usuario("Maria", "maria@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Voto voto1 = new Voto(livros.get(0), usuario);
		Voto voto2 = new Voto(livros.get(0), usuario);
		Voto voto3 = new Voto(livros.get(0), usuario);
		
		Voto voto4 = new Voto(livros.get(1), usuario);
		Voto voto5 = new Voto(livros.get(1), usuario);
		
		Voto voto6 = new Voto(livros.get(2), usuario);
		
		service.salvarComUsuario(voto1);
		service.salvarComUsuario(voto2);
		service.salvarComUsuario(voto3);
		service.salvarComUsuario(voto4);
		service.salvarComUsuario(voto5);
		service.salvarComUsuario(voto6);
		
		
		
		Map<String, BigInteger> ranking = new LinkedHashMap<String, BigInteger>();
		
		ranking = service.obterRankingGeralOrdenado();
		
		assertEquals(BigInteger.valueOf(3L), ranking.get(livros.get(0).getNome()));
		assertEquals(BigInteger.valueOf(2L), ranking.get(livros.get(1).getNome()));
		assertEquals(BigInteger.valueOf(1L), ranking.get(livros.get(2).getNome()));
	}
}
