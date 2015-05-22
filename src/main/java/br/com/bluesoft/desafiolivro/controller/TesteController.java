package br.com.bluesoft.desafiolivro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TesteController {

	
	@RequestMapping(value ="/teste")
	public String digaOi(){
		return "teste";
	}
	
	
}
