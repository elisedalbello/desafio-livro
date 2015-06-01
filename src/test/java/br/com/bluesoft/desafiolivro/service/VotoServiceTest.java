package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.dao.UsuarioDAO;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Voto;
import br.com.bluesoft.desafiolivro.model.Usuario;
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
	public void deveRecuperarTodosOsVotos(){
		Usuario usuario = new Usuario("Maria", "maria@email.com.br");
		usuarioDAO.salvar(usuario);
		
		Voto voto = new Voto(livros.get(1), usuario);
		service.salvarComUsuario(voto);
		
		List<Voto> votos = service.obterVotos();
		
		assertEquals(1, votos.size());
		assertEquals("Guerra e Paz", votos.get(0).getLivro().getNome());
		assertEquals("Maria", votos.get(0).getUsuario().getNome());
	}
}
