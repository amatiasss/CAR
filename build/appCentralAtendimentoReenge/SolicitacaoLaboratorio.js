var faltaObrigatorio = 0
var incompleto = 0

function verificaObrigatorio(dados, mensagem){
	if(dados.value.length < 2){
		faltaObrigatorio = 1;
		mensagem.innerHTML = " - campo obrigatório";
	} else{
		mensagem.innerHTML = " ";
	}
}

function setFocusDesativa(campoFocus, campoDesativa){
         campoFocus.focus();
         campoDesativa.value ="";
}

function setFocus(campo){
         campo.focus();
}

function ativarOpcao(campo){
	campo.checked = true;
}
function recarrega(){
        document.laboratorio.operacao.value  = "enviarEmail";
}
function desativarOpcao(campo){
	campo.checked = false;
}

function desativarCampo(campo){
         campo.value = "";
}

function verificaNaoObrigatorio(dados){
	if(dados.value.length < 3){
		incompleto = 1;
	}
}

function verificaPreenchimentoHorario(){
if((document.laboratorio.dia1.value.length < 2) || (document.laboratorio.inicio1.value.length < 2) || (document.laboratorio.fim1.value.length < 2) ){
		msgHorarioCurso.innerHTML =" - horário inválido";
		faltaObrigatorio = 1;
	} else if(eval(document.laboratorio.inicio1.value - document.laboratorio.fim1.value) > -1){
		msgHorarioCurso.innerHTML =" - horário inválido";
		faltaObrigatorio = 1;
	} else if((document.laboratorio.dia2.value.length > 1) &&  (document.laboratorio.inicio1.value.length >1) && (document.laboratorio.fim1.value.length > 1)){
		if(eval(document.laboratorio.inicio2.value - document.laboratorio.fim2.value) > -1){
			msgHorarioCurso.innerHTML =" - horário inválido";
			faltaObrigatorio = 1;
		}else{
			msgHorarioCurso.innerHTML ="";
		}
	} else if((document.laboratorio.dia3.value.length > 1) &&  (document.laboratorio.inicio3.value.length >1) && (document.laboratorio.fim3.value.length > 1)){
		if(eval(document.laboratorio.inicio3.value - document.laboratorio.fim3.value) > -1){
			msgHorarioCurso.innerHTML =" - horário inválido";
			faltaObrigatorio = 1;
		}else{
			msgHorarioCurso.innerHTML ="";
		}
	}else{
			msgHorarioCurso.innerHTML ="";
	}
}

function verificaHorarioRepetido(){
	if((document.laboratorio.dia1.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio1.value == document.laboratorio.inicio3.value) && (document.laboratorio.fim1.value == document.laboratorio.fim3.value) && (document.laboratorio.dia1.value.length > 0)){
          msgHorarioCurso.innerHTML =" - horário repetido";
          faltaObrigatorio = 1;
        } else if((document.laboratorio.dia1.value == document.laboratorio.dia2.value) && (document.laboratorio.inicio1.value == document.laboratorio.inicio2.value) && (document.laboratorio.fim1.value == document.laboratorio.fim2.value) && (document.laboratorio.dia2.value.length > 0)){
          msgHorarioCurso.innerHTML =" - horário repetido";
          faltaObrigatorio = 1;
        } else if((document.laboratorio.dia2.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio2.value == document.laboratorio.inicio3.value) && (document.laboratorio.fim2.value == document.laboratorio.fim3.value) && (document.laboratorio.dia3.value.length > 0)){
          msgHorarioCurso.innerHTML =" - horário repetido";
          faltaObrigatorio = 1;
        }
}

function verificaChoqueHorario(){
	if((document.laboratorio.dia1.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio1.value < document.laboratorio.inicio3.value) && (document.laboratorio.fim1.value > document.laboratorio.inicio3.value) && (document.laboratorio.dia1.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	} else 	 if((document.laboratorio.dia1.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio1.value > document.laboratorio.inicio3.value) && (document.laboratorio.fim3.value > document.laboratorio.inicio1.value) && (document.laboratorio.dia1.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	} else 	if((document.laboratorio.dia1.value == document.laboratorio.dia2.value) && (document.laboratorio.inicio1.value < document.laboratorio.inicio2.value) && (document.laboratorio.fim1.value > document.laboratorio.inicio2.value) && (document.laboratorio.dia2.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	} else 	 if((document.laboratorio.dia1.value == document.laboratorio.dia2.value) && (document.laboratorio.inicio1.value > document.laboratorio.inicio2.value) && (document.laboratorio.fim2.value > document.laboratorio.inicio1.value) && (document.laboratorio.dia2.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	} else 	if((document.laboratorio.dia2.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio2.value < document.laboratorio.inicio3.value) && (document.laboratorio.fim2.value > document.laboratorio.inicio3.value) && (document.laboratorio.dia3.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	} else 	 if((document.laboratorio.dia2.value == document.laboratorio.dia3.value) && (document.laboratorio.inicio2.value > document.laboratorio.inicio3.value) && (document.laboratorio.fim3.value > document.laboratorio.inicio2.value) && (document.laboratorio.dia3.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
	}
}

function verificaInicioTermino(){
	if((document.laboratorio.dia1.value == document.laboratorio.dia3.value) && ((document.laboratorio.inicio1.value == document.laboratorio.inicio3.value) || (document.laboratorio.fim1.value == document.laboratorio.fim3.value)) && (document.laboratorio.dia1.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
        } else if((document.laboratorio.dia1.value == document.laboratorio.dia2.value) && ((document.laboratorio.inicio1.value == document.laboratorio.inicio2.value) || (document.laboratorio.fim1.value == document.laboratorio.fim2.value)) && (document.laboratorio.dia2.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
        } else if((document.laboratorio.dia2.value == document.laboratorio.dia3.value) && ((document.laboratorio.inicio2.value == document.laboratorio.inicio3.value) || (document.laboratorio.fim2.value == document.laboratorio.fim3.value)) && (document.laboratorio.dia3.value.length > 0)){
          msgHorarioCurso.innerHTML =" - choque de horário";
          faltaObrigatorio = 1;
        }
}

function verificaHorario(){

	verificaPreenchimentoHorario();
	verificaChoqueHorario();
	verificaInicioTermino();
	verificaHorarioRepetido();

}


function verificaEmail(){
	var valor = document.laboratorio.email.value;
	msgEmail;
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

function totalAlunos(){
	total = document.laboratorio.numeroAlunos.value;
	if(total < 5 || total > 45){
		msgNumeroAlunos.innerHTML = " - número de alunos inválido";
		faltaObrigatorio = 1;
	} else if(isNaN(parseInt(total))){
		msgNumeroAlunos.innerHTML = " - número de alunos inválido";
		faltaObrigatorio = 1;
	} else {
		msgNumeroAlunos.innerHTML = " ";
	}
}

function totalMaquinas(){
	total = document.laboratorio.numeroMaquinas.value;
	if(total < 5 || total > 45){
		msgNumeroMaquinas.innerHTML = " - número de máquinas inválido";
		faltaObrigatorio = 1;
	} else if(isNaN(parseInt(total))){
		msgNumeroMaquinas.innerHTML = " - número de máquinas inválido";
		faltaObrigatorio = 1;
	} else {
		msgNumeroMaquinas.innerHTML = " ";
	}
}

function cancelar(){
	if(confirm("confirma o cancelamento? Se você cancelar, as futuras solicitações terão suas avaliações prejudicadas.") == true){
		document.laboratorio.operacao.value  = "";
		return true;
	}
	return false;
}

function isSimNaoJustificado(campo, justificativa){
	if(campo[0].checked){
	}else if(campo[1].checked){
		if(justificativa.value.length < 10){
			incompleto = 1;
		}
	}else{
		incompleto = 1;
	}
}

function isSimNao(campo){
	if(campo[0].checked || campo[1].checked){
	}else{
		incompleto = 1;
	}
}

function verificaObrigatorios(){
	faltaObrigatorio = 0;
	verificaEmail();
	totalAlunos();
	totalMaquinas();
	verificaHorario();
	verificaObrigatorio(document.laboratorio.duracaoCurso, msgDuracaoCurso);
	verificaObrigatorio(document.laboratorio.nomeCurso, msgNomeCurso);
	verificaObrigatorio(document.laboratorio.nomeMinistrante, msgNomeMinistrante);
	verificaObrigatorio(document.laboratorio.cursosPertence, msgCursosPertence);
}
	
function verificaNaoObrigatorios(){
	incompleto = 0;
	verificaNaoObrigatorio(document.laboratorio.finalidade);
	verificaNaoObrigatorio(document.laboratorio.softwareNecessario);
	verificaNaoObrigatorio(document.laboratorio.publicoAlvo);
	isSimNao(document.laboratorio.pago);
	isSimNaoJustificado(document.laboratorio.cursoNoturno, document.laboratorio.justificativaNoturno);
	isSimNaoJustificado(document.laboratorio.cursoSabado, document.laboratorio.justificativaSabado);	
	verificaNaoObrigatorio(document.laboratorio.contribuicao);
}

function abreJanela(){
        NovaJanela = window.open ("AjudaLab.html", "Ajuda", "scrollbars=yes,width=500,height=500")
}

function preEnvio(){
        recarrega();
	verificaObrigatorios();
	verificaNaoObrigatorios();
	if(faltaObrigatorio == 1){
		alert("Algum(ns) campo(s) obrigatório(s) não foram preenchidos! A solicitação não pode ser enviada.");
	} else if(incompleto == 1){
		if(confirm("Alguns campos não foram preenchidos. A avaliação de sua solicitação será prejudicada. Confirma a solicitação?") == true){
			return true;
		}
	} else {
		return true;
	}
	return false;
}