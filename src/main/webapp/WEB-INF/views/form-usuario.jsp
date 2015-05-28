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
		<h1 class="titulo-principal">Formulário</h1>
		
		<div class="div-form">
			<form action="POST" >
				<p>Nome:</p></br> 
				<input type="text" name="nome"></br>
				<p>Email:</p></br>
				<input type="email" nome="email"></br>
				<input type="submit" name="gravar-usuario" value="Gravar" class="botao">
			</form>
		</div>
		
		<footer class="rodape"> Bluesoft 2015 </footer>
		
		<script type="text/javascript" src="pages/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="pages/js/comparacao.js"></script>
		<script type="text/javascript"></script>
	</body>
</html>