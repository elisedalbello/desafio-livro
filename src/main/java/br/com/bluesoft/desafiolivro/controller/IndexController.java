package br.com.bluesoft.desafiolivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bluesoft.desafiolivro.service.LivroService;
import br.com.bluesoft.desafiolivro.service.RankingService;

@Controller
public class IndexController {
	
	private static final String INDEX_VIEW = "vote-no-livro";
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private RankingService rankingService;
	
	@RequestMapping(value = { "" ,"/" } )
	public String voteNoLivro(Model model) {
		model.addAttribute("comparacoes", livroService.carregarLivrosNaTela());
		return INDEX_VIEW;
	}
	
	@RequestMapping(value="/salvar/voto", method=RequestMethod.POST)
	public void salvarVoto(RankingForm form){
		
		rankingService.salvar(form.getLivroId());
		
	}

}
