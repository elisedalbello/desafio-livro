package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.util.PopulaLivro;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/spring-context.xml"} )
public class LivroServiceTest {
	
	@Autowired
	LivroService service;
	
	@Autowired
	PopulaLivro popula;
	
	List<Livro> livros;
	@Before
	public void init(){
		service.deletaLivros();
		livros = popula.insereLivros();
	}
	
	@Test
	public void deveRecuperarLivroPeloID(){
		Livro livro = service.recuperarLivroPeloID(11);
		
		assertEquals(11, livro.getId());
	}
		
	@Test
	public void deveSalvarLivro(){
		Livro livro = new Livro("Alice no Pais das Maravilhas", "");
		Livro result  = service.salvar(livro);
		
		assertEquals(21, result.getId());
		assertEquals("Alice no Pais das Maravilhas", result.getNome());
	}
	
	@Test
	public void deveLimparATabelaDeLivros() {
		service.deletaLivros();
		
		List<Livro> livros = service.recuperarLivros();

		assertEquals(0, livros.size());
	}
	
	@Test
	public void deveRecuperarTodosOsLivros(){
		List<Livro> livros = service.recuperarLivros();
		
		assertEquals(5, livros.size());
		assertEquals("1984", livros.get(0).getNome());
		assertEquals("Guerra e Paz", livros.get(1).getNome());
	}
	
}
