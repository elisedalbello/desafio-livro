package br.com.bluesoft.desafiolivro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.service.RankingService;
import br.com.bluesoft.desafiolivro.service.UsuarioService;

@Controller
public class RankingController {
	
	@Autowired
	private RankingService service;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/salvarRanking")
	@ResponseBody
	public String carregarRanking(HttpServletRequest request){
		
		List<Livro> livros = (List<Livro>) session.getAttribute("livrosVotados");
		Usuario usuario = getUsuarioSession();
		
		usuarioService.salvar(usuario);
		service.salvarRanking(usuario, livros);
		
		return "ranking";		
	}	

	
	@RequestMapping(value="/ranking")
	public String exibirRankings(Model model){
		
		model.addAttribute("rankingGeral", service.obterRankingGeralOrdenado());
		model.addAttribute("rankingUsuario", service.obterRankingUsuarioOrdenado(getUsuarioSession()));
		
		return "ranking";
	}
	
	private Usuario getUsuarioSession() {
		return (Usuario) session.getAttribute("usuario");
	}
}
