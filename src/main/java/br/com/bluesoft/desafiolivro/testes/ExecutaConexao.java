package br.com.bluesoft.desafiolivro.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecutaConexao {

	
	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection("jdbc:hsqldb:file:desafiolivro.db","sa", "");
	}

}
