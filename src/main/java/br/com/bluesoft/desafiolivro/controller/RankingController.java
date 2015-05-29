package br.com.bluesoft.desafiolivro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Ranking;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.service.RankingService;

@Controller
public class RankingController {
	
	@Autowired
	private RankingService service;

	
	@RequestMapping(value = "/ranking")
	@ResponseBody
	public String carregarRanking(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		System.out.println("lalalalallaa::::" + session.getAttribute("usuario"));
		System.out.println("lelelelellel::::" + session.getAttribute("livrosVotados"));
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Livro> livros = (List<Livro>) session.getAttribute("livrosVotados");

		salvarRanking(usuario, livros);
			
		return "ranking";		
	}

	private void salvarRanking(Usuario usuario, List<Livro> livros) {
		for(Livro livro : livros){
			System.out.println("Livro:::::::" + livro);
			System.out.println("Usuario:::::" + usuario);
			
			Ranking ranking = new Ranking(livro, usuario);
			service.salvarComUsuario(ranking);
		}
	}

}
