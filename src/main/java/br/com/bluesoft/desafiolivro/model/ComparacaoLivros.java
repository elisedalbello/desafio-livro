package br.com.bluesoft.desafiolivro.model;

public class ComparacaoLivros {
	private Livro livroEsquerda;
	private Livro livroDireita;
	
	public ComparacaoLivros() {}
		
	public ComparacaoLivros(Livro livroEsquerda, Livro livroDireita) {
		this.livroEsquerda = livroEsquerda;
		this.livroDireita = livroDireita;
	}

	public Livro getLivroEsquerda() {
		return livroEsquerda;
	}
	public void setLivroEsquerda(Livro livroEsquerda) {
		this.livroEsquerda = livroEsquerda;
	}
	public Livro getLivroDireita() {
		return livroDireita;
	}
	public void setLivroDireita(Livro livroDireita) {
		this.livroDireita = livroDireita;
	}
	
	@Override
	public String toString() {
		return "Livro esquerda: " + livroEsquerda + " - Livro direita: " + livroDireita;
	}
}
