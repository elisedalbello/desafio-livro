package br.com.bluesoft.desafiolivro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluesoft.desafiolivro.service.ComparacaoLivrosService;
import br.com.bluesoft.desafiolivro.service.RankingService;

@Controller
public class IndexController {
	
	private static final String INDEX_SESSION_ATRIBUTE = "INDEX";

	private static final String INDEX_VIEW = "vote-no-livro";
	
	@Autowired
	private ComparacaoLivrosService comparacaoService;
	
	@Autowired
	private RankingService rankingService;
	
	
	@RequestMapping(value = { "" ,"/" }, method=RequestMethod.GET )
	public String voteNoLivro(Model model, HttpServletRequest request, Integer indexLista) {
		
		HttpSession session = request.getSession();
		Integer index = (Integer) session.getAttribute(INDEX_SESSION_ATRIBUTE);
		
		if(index == null){
			index = 0;
			session.setAttribute(INDEX_SESSION_ATRIBUTE, index);
		}

		model.addAttribute("comparacao", comparacaoService.carregarComparacao(index));
		if(index != 9){
			return INDEX_VIEW;
		}else{
			return "form-usuario";
		}
	}
	
	@RequestMapping(value = "/salvar/voto", method=RequestMethod.POST)
	@ResponseBody
	public String salvarVoto(RankingForm form, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Integer index = (Integer) session.getAttribute(INDEX_SESSION_ATRIBUTE);
		session.setAttribute(INDEX_SESSION_ATRIBUTE, ++index);
		return "ok";
//		rankingService.salvar(form.getLivroId());
		
	}
	
	
	@RequestMapping(value = "/formulario", method=RequestMethod.POST)
	public String salvarUsuario(HttpServletRequest request){
		HttpSession session = request.getSession();
		return "ranking";
	}

}
