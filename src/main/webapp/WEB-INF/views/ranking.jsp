<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
	<head>
		<meta charset=UTF-8>
		<link rel="stylesheet" href="pages/css/reset.css">
		<link rel="stylesheet" href="pages/css/estilo.css">
		<title>Ranking</title>
	</head>
	<body>
		<h1 class="titulo-principal">Ranking</h1>
		
		<div class="ranking-usuario">
			<h1>Ranking Usuário</h2>
			<ul>
				<c:forEach var="u" items="${rankingUsuario}">
					<li>${u.key} - ${u.value}</li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="ranking-geral">
			<h1>Ranking Geral</h2>
			<ul>
				<c:forEach var="g" items="${rankingGeral}">
					<li>${g.key} - ${g.value}</li>
				</c:forEach>
			</ul>
		</div>
		
		<button class="nova-votacao" id="nova-votacao" name="nova-votacao"> Nova Votação </button>
		
		<footer class="rodape"> Bluesoft 2015 </footer>
		
		<script type="text/javascript" src="pages/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="pages/js/script.js"></script>
		<script type="text/javascript"></script>
	</body>
</html>