package br.com.bluesoft.desafiolivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bluesoft.desafiolivro.service.LivroService;

@Controller
public class IndexController {
	
	private static final String INDEX_VIEW = "vote-no-livro";
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value = { "" ,"/" } )
	public String voteNoLivro(Model model) {
		model.addAttribute("comparacoes", livroService.carregarLivrosNaTela());
		return INDEX_VIEW;
	}

}
