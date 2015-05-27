package br.com.bluesoft.desafiolivro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String caminho;

	public Livro() {}
	
	public Livro(String nome, String caminho) {
		this.nome = nome;
		this.caminho = caminho;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getCaminho() {
		return this.caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.nome;
	}
}
