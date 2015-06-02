package br.com.bluesoft.desafiolivro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.service.UsuarioService;
import br.com.bluesoft.desafiolivro.service.VotoService;

@Controller
public class VotoController {
	
	@Autowired
	private VotoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/salvarVoto")
	@ResponseBody
	public String carregarRanking(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		List<Livro> livros = (List<Livro>) session.getAttribute("livrosVotados");
		Usuario usuario = getUsuarioSession(request);
		
		usuarioService.salvar(usuario);
		service.salvarVoto(usuario, livros);
		
		return "ranking";		
	}	
	
	private Usuario getUsuarioSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		return (Usuario) session.getAttribute("usuario");
	}
}
