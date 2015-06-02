var emailValido = function(email) {
	verifica = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
	
	if(verifica.exec(email)){
		return true;
	}else{
		return false;
	}
} 

$('.livro').click(function() {
	var id = $(this).data("id");
	
	$.ajax({
		type: 'POST',
		url : "salvar/voto",
		context : document.body,
		data: { livroId: id},
		success : function() {
			window.location.reload(true);
		},
		error : function() {
			alert("Não funcionou " + id);
		}
	});
});

$('#nova-votacao').click(function() {
	$.ajax({
		type : 'GET',
		url : 'novaVotacao',
		success : function() {
			location.href = 'index';
		},
		error : function() {
			alert("Não foi possivel redirecionar para nova votação");
		}
	});
});

$('#gravar').click(function(){
	var email = $('#email').val();
	var nome = $('#nome').val();
	
	if ( nome == ""){
		$('#nome').focus();
		alert("Preencha o nome");
		
	}else if(email == "" || !emailValido(email)){
		$('#email').focus();
		alert("Preencha com um email válido");
		
	}else{
		$.ajax({
			type: 'POST',
			url: "formulario",
			context: document.body,
			data: { nome: nome, email: email },
			success: function(){
				location.href = 'ranking';
			},
			error: function() {
				alert("Os dados não foram salvos");
			}
		});
	}
});
