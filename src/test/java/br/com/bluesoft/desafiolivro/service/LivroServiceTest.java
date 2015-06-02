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
	private LivroService service;
	
	@Autowired
	private PopulaLivro popula;
	
	private List<Livro> livros;
	
	@Before
	public void init(){
		service.deletaLivros();
		livros = popula.insereLivros();
	}
	
	@Test
	public void deveObterLivroPeloID(){
		Livro livro = service.obterLivroPeloID(22);
		
		assertEquals(22, livro.getId());
		assertEquals("1984", livro.getNome());
	}
		
	@Test
	public void deveSalvarLivro(){
		Livro livro = new Livro("Alice no Pais das Maravilhas", "");
		Livro result  = service.salvar(livro);
		
		assertEquals(21, result.getId());
		assertEquals("Alice no Pais das Maravilhas", result.getNome());
	}
	
	@Test
	public void deveDeletarLivros() {
		service.deletaLivros();
		
		List<Livro> livros = service.listarLivros();

		assertEquals(0, livros.size());
	}
	
	@Test
	public void deveListarTodosOsLivros(){
		List<Livro> livros = service.listarLivros();
		
		assertEquals(5, livros.size());
		assertEquals("1984", livros.get(0).getNome());
		assertEquals("Guerra e Paz", livros.get(1).getNome());
	}
	
}
