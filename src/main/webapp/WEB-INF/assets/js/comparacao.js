
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

var validarEmail = function(email) {
	verifica = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;
	
	if(!verifica.exec(email)){
		$('#email').focus(function() {
			alert("E-mail inválido");
		});
	}
} 


