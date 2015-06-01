<%@ page import="br.com.bluesoft.desafiolivro.service.LivroService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="pages/css/reset.css">
		<link rel="stylesheet" href="pages/css/estilo.css">
		<title>Vote no Livro</title>
	</head>
	
	<body>
		<h1 class="titulo-principal">Escolha um livro</h1>
		
		<img data-id="${comparacao.livroEsquerda.id}" alt="${comparacao.livroEsquerda.nome}" src="${comparacao.livroEsquerda.caminho}" id="${comparacao.livroEsquerda.id}" class="livro img-esquerda">
		<img data-id="${comparacao.livroDireita.id}" alt="${comparacao.livroDireita.nome}" src="${comparacao.livroDireita.caminho}" id="${comparacao.livroDireita.id}" class="livro img-direita">
						
		<footer class="rodape"> Bluesoft 2015 </footer>
		
		<script type="text/javascript" src="pages/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="pages/js/script.js"></script>
		<script type="text/javascript"></script>
		
	</body>
	
</html>