var faltaObrigatorio = 0
var incompleto = 0

function verificaObrigatorio(dados, mensagem){
	if(dados.value.length < 3){
		faltaObrigatorio = 1;
		mensagem.innerHTML = " - campo obrigatório";
	} else{
		mensagem.innerHTML = " ";
	}
}

function verificaNaoObrigatorio(dados){
	if(dados.value.length < 3){
		incompleto = 1;
	}
}

function verificaHorario(){
	if((document.laboratorio.dia1.value.length < 2) || (document.laboratorio.inicio1.value.length < 2) || (document.laboratorio.fim1.value.length < 2) ){
		msgHorarioCurso.innerHTML ="horário inválido";
		faltaObrigatorio = 1;	
	} else if(eval(document.laboratorio.inicio1.value - document.laboratorio.fim1.value) > -1){
		msgHorarioCurso.innerHTML ="horário inválido";
		faltaObrigatorio = 1;	
	} else if((document.laboratorio.dia2.value.length > 1) &&  (document.laboratorio.inicio1.value.length >1) && (document.laboratorio.fim1.value.length > 1)){
		if(eval(document.laboratorio.inicio2.value - document.laboratorio.fim2.value) > -1){
			msgHorarioCurso.innerHTML ="horário inválido";
			faltaObrigatorio = 1;	
		}else{
			msgHorarioCurso.innerHTML ="";
		}
	} else if((document.laboratorio.dia3.value.length > 1) &&  (document.laboratorio.inicio3.value.length >1) && (document.laboratorio.fim3.value.length > 1)){
		if(eval(document.laboratorio.inicio3.value - document.laboratorio.fim3.value) > -1){
			msgHorarioCurso.innerHTML ="horário inválido";
			faltaObrigatorio = 1;	
		}else{
			msgHorarioCurso.innerHTML ="";
		} 
	}else{
			msgHorarioCurso.innerHTML ="";
	}
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

function totalAlunos(avisar){
	total = document.laboratorio.numeroAlunos.value;
	if((total > 0 && total < 10) || (total > 40 && total < 56)){
		if(avisar == 1){
			alert("Verifique o número de alunos.");
		}
	} else if(total <1 || total > 55){
		msgNumeroAlunos.innerHTML = " - número de alunos inválido";
		faltaObrigatorio = 1;
	} else if(isNaN(parseInt(total))){
		msgNumeroAlunos.innerHTML = " - número de alunos inválido";
		faltaObrigatorio = 1;
	} else {
		msgNumeroAlunos.innerHTML = " "
	}
}

function cancelar(){
	if(confirm("confirma o cancelamento? Se você cancelar, as futuras solicitações terão suas avaliações prejudicadas.") == true){
		document.laboratorio.reset();
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

function isSimNao(campo, justificativa){
	if(campo[0].checked || campo[1].checked){
	}else{
		incompleto = 1;
	}
}

function verificaObrigatorios(){
	faltaObrigatorio = 0;
	verificaHorario();
	verificaEmail();
	totalAlunos(0);
	verificaHorario();
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
	
function preEnvio(){
	verificaObrigatorios();
	verificaNaoObrigatorios();
	if(faltaObrigatorio == 1){
		alert("Verifique o preenchimento das informações!");
	} else if(incompleto == 1){
		if(confirm("Alguns campos não foram preenchidos. A avaliação de sua solicitação será prejudicada. Confirma a solicitação?") == true){
			return true;
		}
	} else {
		return true;
	}
	return false;
}