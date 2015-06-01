package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.model.ComparacaoLivros;
import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.util.PopulaLivro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/spring-context.xml"} )
public class ComparacaoLivrosServiceTest {
	
	@Autowired
	private ComparacaoLivrosService service;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private PopulaLivro popula;
	
	private List<Livro> livros;
	
	@Before
	public void init(){
		livroService.deletaLivros();
		livros = popula.insereLivros();
	}

	@Test
	public void deveCarregarDoisLivrosPorVez(){
		List<ComparacaoLivros> comparacoes = service.carregarLivrosNaTela();
		
		assertEquals(10, comparacoes.size());
		assertEquals("1984", comparacoes.get(0).getLivroEsquerda().getNome());
		assertEquals("Guerra e Paz", comparacoes.get(0).getLivroDireita().getNome());
	}
	
}
