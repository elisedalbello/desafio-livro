package br.com.bluesoft.desafiolivro.dao;

import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafiolivro.model.Usuario;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario>{
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
}
