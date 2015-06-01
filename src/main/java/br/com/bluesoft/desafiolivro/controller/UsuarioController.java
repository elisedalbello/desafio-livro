package br.com.bluesoft.desafiolivro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bluesoft.desafiolivro.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/formulario", method=RequestMethod.POST)
	public String salvarUsuario(String nome, String email){
		Usuario usuarioCadastro = new Usuario(nome, email); 
		
		session.setAttribute("usuario", usuarioCadastro);
		return "redirect:salvarRanking";
	}

}
