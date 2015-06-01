package br.com.bluesoft.desafiolivro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafiolivro.dao.UsuarioDAO;
import br.com.bluesoft.desafiolivro.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public Usuario salvar(Usuario usuario){
		dao.salvar(usuario);
		return usuario;
	}

	public List<Usuario> recuperarUsuarios() {
		return dao.listar();
	}
	
	public Usuario recuperarUsuarioPeloID(int usuarioID){
		return dao.obterPeloID(usuarioID);
	}
}
