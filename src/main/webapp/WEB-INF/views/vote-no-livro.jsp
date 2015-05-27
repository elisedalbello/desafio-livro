<%@page import="br.com.bluesoft.desafiolivro.service.LivroService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="pages/css/reset.css">
		<link rel="stylesheet" href="pages/css/estilo.css">
		<title>Vote no Livro</title>
	</head>
	
	<body>
		<h1 class="titulo-principal">Escolha um livro</h1>
	
		
		<c:forEach var="c" items="${comparacoes}">
			<img data-id="${c.livroEsquerda.id}" alt="${c.livroEsquerda.nome}" src="${c.livroEsquerda.caminho}" id="${c.livroEsquerda.id}" class="img-esquerda">
			<img data-id="${c.livroDireita.id}" alt="${c.livroDireita.nome}" src="${c.livroDireita.caminho}" id="${c.livroDireita.id}" class="img-direita">
		</c:forEach>
				
		<footer class="rodape"> Bluesoft 2015 </footer>
		
		<script type="text/javascript" src="pages/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="pages/js/comparacao.js"></script>
		<script type="text/javascript"></script>
		
	</body>
	
</html>