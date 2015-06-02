package br.com.bluesoft.desafiolivro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.service.VotoService;

@Controller
public class RankingController {
	
	@Autowired
	private VotoService service;

	@RequestMapping(value="/ranking")
	public String exibirRankings(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		model.addAttribute("rankingGeral", service.obterRankingGeralOrdenado());
		model.addAttribute("rankingUsuario", service.obterRankingUsuarioOrdenado(usuario));
		
		return "ranking";
	}
	
	@RequestMapping(value="/novaVotacao")
	public String abrirNovaVotacao(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:index";
	}
}
