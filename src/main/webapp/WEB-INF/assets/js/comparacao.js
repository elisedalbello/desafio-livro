
$('.livro').click(function() {

	var id = $(this).data("id");
	
	$.ajax({
		type: 'POST',
		url : "salvar/voto",
		context : document.body,
		data: { livroId: id},
		success : function() {
			alert("Funcionou " + id);
			window.location.reload(true);
		},
		error : function() {
			alert("Não funcionou " + id);
		}
	});
});
