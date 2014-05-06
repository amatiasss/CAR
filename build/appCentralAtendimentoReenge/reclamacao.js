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
       document.reclamacao.operacao.value  = "enviarEmail";
}

function abreJanela(){
        NovaJanela = window.open ("AjudaReclamacao.html", "Ajuda", "scrollbars=yes,width=500,height=500")
}

function verificaSelecao(){
         if(document.reclamacao.tipo[0].checked || document.reclamacao.tipo[1].checked || document.reclamacao.tipo[2].checked || document.reclamacao.tipo[3].checked){
            msgTipo.innerHTML = ""
         } else{
                msgTipo.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1
         }
}
function verificaTipoOutro(){
         if(document.reclamacao.tipo[0].checked || document.reclamacao.tipo[1].checked || document.reclamacao.tipo[2].checked || document.reclamacao.tipo[3].checked){
               if (document.reclamacao.tipo[3].checked){
                 verificaObrigatorio(document.reclamacao.tipoDeOutro, msgTipo);
                 document.reclamacao.tipoDeOutro.focus();
               }else{
                     msgTipo.innerHTML = ""
                }
         } else{
                msgTipo.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1
         }
}

function ativaOpcao(){
	document.reclamacao.tipo[3].checked = true;
}

function desativaTipoOutro(){
         document.reclamacao.tipoDeOutro.value ="";
}

function verificaEmail(){
	var valor = document.reclamacao.email.value;
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
         verificaObrigatorio(document.reclamacao.nome, msgNome);
         verificaEmail();
         verificaTipoOutro();
         verificaObrigatorio(document.reclamacao.descricao, msgDescricao);
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