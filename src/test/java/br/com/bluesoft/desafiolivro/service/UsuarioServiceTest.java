package br.com.bluesoft.desafiolivro.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.bluesoft.desafiolivro.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/spring-context.xml"} )
public class UsuarioServiceTest {
	
	@Autowired
	private UsuarioService service;
	
	@Test
	public void deveSalvarOUsuario(){
		Usuario usuario = new Usuario("Elise", "elise@email.com.br");
		Usuario result = service.salvar(usuario);
		
		assertEquals("Elise", result.getNome());
		assertEquals("elise@email.com.br", result.getEmail());
	}

	
	@Test
	public void deveRecuperarTodosOsUsuarios(){
		Usuario usuario = new Usuario("Maria", "maria@email.com.br");
		service.salvar(usuario);
		Usuario usuario2 = new Usuario("Joao", "joao@email.com.br");
		service.salvar(usuario2);
		
		List<Usuario> usuarios = service.recuperarUsuarios();
		
		assertEquals(3, usuarios.size());
		assertEquals("Elise", usuarios.get(0).getNome());
		assertEquals("Maria", usuarios.get(1).getNome());
		assertEquals("Joao", usuarios.get(2).getNome());
	}
}
