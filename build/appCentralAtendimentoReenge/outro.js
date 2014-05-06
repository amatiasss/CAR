var faltaObrigatorio = 0

function verificaObrigatorio(dados, mensagem){
	if(dados.value.length < 2){
		faltaObrigatorio = 1;
		mensagem.innerHTML = " - campo obrigatório";
	} else{
		mensagem.innerHTML = "";
	}
}

function recarrega(){
       document.outro.operacao.value  = "enviarEmail";
}

function abreJanela(){
        NovaJanela = window.open ("AjudaOutro.html", "Ajuda", "scrollbars=yes,width=500,height=500")
}

function verificaEmail(){
	var valor = document.outro.email.value;
	if((valor.length < 3) || (valor.indexOf("@") < 1) || (valor.indexOf("@") == valor.length - 1)){
		faltaObrigatorio = 1;
		msgEmail.innerHTML = " - e-mail inválido";
	} else if((valor.indexOf(".@") >= 0) || (valor.indexOf("@.") >= 0) || (valor.indexOf("/")  >= 0) ) {
		faltaObrigatorio = 1;
		msgEmail.innerHTML = " - e-mail inválido";
	} else if(valor.indexOf(".")  < 1 ){
		faltaObrigatorio = 1;
		msgEmail.innerHTML = " - e-mail inválido";
	}else {
		indiceEspaco = valor.indexOf(" ");
		if((indiceEspaco > 0) && (indiceEspaco < valor.length -1)){
			faltaObrigatorio = 1;
			msgEmail.innerHTML = " - e-mail inválido";
		}else {
			msgEmail.innerHTML = " ";
		}
	}
}


function verificaObrigatorios(){
         recarrega();
         faltaObrigatorio = 0;
         verificaObrigatorio(document.outro.nome, msgNome);
         verificaEmail();
         verificaObrigatorio(document.outro.comentario, msgComentario);
}

function cancelar(){
	if(confirm("confirma o cancelamento?") == true){
		window.location="apresentacao.html";
	}
}





function preEnvio(){
         verificaObrigatorios();
         if(faltaObrigatorio == 1){
		alert("Falta o preenchimento de campo(s) obrigatório(s)!")
		return false;
	} else{
               return true;
        }
}