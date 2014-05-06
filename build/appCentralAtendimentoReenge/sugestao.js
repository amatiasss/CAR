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
       document.sugestao.operacao.value  = "enviarEmail";
}

function abreJanela(){
        NovaJanela = window.open ("AjudaSugestao.html", "Ajuda", "scrollbars=yes,width=500,height=500")
}

function verificaEmail(){
	var valor = document.sugestao.email.value;
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
         verificaObrigatorio(document.sugestao.nome, msgNome);
         verificaEmail();
         verificaObrigatorio(document.sugestao.sugestao, msgSugestao);
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
	} else{
               return true;
        }
        return false;
}