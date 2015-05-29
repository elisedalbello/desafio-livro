package br.com.bluesoft.desafiolivro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluesoft.desafiolivro.model.Livro;
import br.com.bluesoft.desafiolivro.model.Usuario;
import br.com.bluesoft.desafiolivro.service.ComparacaoLivrosService;
import br.com.bluesoft.desafiolivro.service.LivroService;
import br.com.bluesoft.desafiolivro.service.RankingService;
import br.com.bluesoft.desafiolivro.service.UsuarioService;

@Controller
public class IndexController {
	
	private static final String INDEX_SESSION_ATRIBUTE = "INDEX";

	private static final String INDEX_VIEW = "vote-no-livro";
	
	@Autowired
	private ComparacaoLivrosService comparacaoService;
	
	@Autowired
	private RankingService rankingService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
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
				
		List<Livro> livrosVotados = carregarListaVotados(form, session);
		
		session.setAttribute("livrosVotados", livrosVotados);
	
		return "ok";		
	}

	@RequestMapping(value = "/formulario", method=RequestMethod.POST)
	public void salvarUsuario(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		//Usuario usuario = new Usuario(nome, email);
		
		session.setAttribute("usuario", "");
		//return "/ranking";
	}
	
	
	private List<Livro> carregarListaVotados(RankingForm form, HttpSession session) {
		List<Livro> livrosVotados = (List<Livro>) session.getAttribute("livrosVotados");
		
		if(livrosVotados == null){
			livrosVotados = new ArrayList<>();
		}
		
		livrosVotados.add(livroService.recuperarLivroPeloID(form.getLivroId()));
		return livrosVotados;
	}

}
