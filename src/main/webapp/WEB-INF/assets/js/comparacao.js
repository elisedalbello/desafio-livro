
$('.img-esquerda').click(function() {
	$(this).css('border', "solid 5px silver");
	var id = $(this).data("id");
	
	$.ajax({
		type: 'POST',
		url : "salvar/voto",
		context : document.body,
		data: { livroId: id},
		success : function() {
			alert("Funcionou");
		},
		error : function() {
			alert("Não funcionou");
		}
	});
});

$(".img-direita").click(function() {
	$(this).css('border', "solid 5px silver");
	var id = $(this).data("id");
	
	$.ajax({
		type: 'POST',
		url : "salvar/voto",
		context : document.body,
		data: { livroId: id},
		success : function() {
			alert("Funcionou");
		},
		error : function() {
			alert("Não funcionou");
		}
	});
});


