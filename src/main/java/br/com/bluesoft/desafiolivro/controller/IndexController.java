package br.com.bluesoft.desafiolivro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
		
	@RequestMapping(value = { "" ,"/" } )
	public String voteNoLivro() {
		return "vote-no-livro";
	}

}
