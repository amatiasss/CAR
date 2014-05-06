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
	if((document.salaAula.dia1.value.length < 2) || (document.salaAula.inicio1.value.length < 2) || (document.salaAula.fim1.value.length < 2) ){
		msgHorario.innerHTML ="horário inválido";
		faltaObrigatorio = 1;	
	} else if(eval(document.salaAula.inicio1.value - document.salaAula.fim1.value) > -1){
		msgHorario.innerHTML ="horário inválido";
		faltaObrigatorio = 1;	
	} else if((document.salaAula.dia2.value.length > 1) &&  (document.salaAula.inicio1.value.length >1) && (document.salaAula.fim1.value.length > 1)){
		if(eval(document.salaAula.inicio2.value - document.salaAula.fim2.value) > -1){
			msgHorario.innerHTML ="horário inválido";
			faltaObrigatorio = 1;	
		}else{
			msgHorario.innerHTML ="";
		}
	} else if((document.salaAula.dia3.value.length > 1) &&  (document.salaAula.inicio3.value.length >1) && (document.salaAula.fim3.value.length > 1)){
		if(eval(document.salaAula.inicio3.value - document.salaAula.fim3.value) > -1){
			msgHorario.innerHTML ="horário inválido";
			faltaObrigatorio = 1;	
		}else{
			msgHorario.innerHTML ="";
		} 
	}else{
			msgHorario.innerHTML ="";
	}
}

function verificaEmail(){
	var valor = document.salaAula.email.value;
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
	total = document.salaAula.numeroAlunos.value;
	if((total > 0 && total < 10) || (total > 40 && total < 56)){
		if(avisar == 1){
			alert("Verifique o número de alunos.");
		}
	} else if(total < 1 || total >= 55){
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
		document.salaAula.reset();
		return true;
	}
	return false;
}

function verificaPeriodicidade(){
	if(document.salaAula.opcaoPeriodicidade[0].checked || document.salaAula.opcaoPeriodicidade[1].checked || document.salaAula.opcaoPeriodicidade[2].checked ||document.salaAula.opcaoPeriodicidade[3].checked){
		if((document.salaAula.opcaoPeriodicidade[3].checked) && (document.salaAula.periodicidade.value.length < 3)){
			faltaObrigatorio = 1;
			msgPeriodicidade.innerHTML = " Informe a periodicidade.";
		} else{
			msgPeriodicidade.innerHTML = "";
		}
	}else{
		faltaObrigatorio = 1;
		msgPeriodicidade.innerHTML = " Informe a periodicidade.";
	}
}

function ativarOpcao(){
	document.salaAula.opcaoPeriodicidade[3].checked = true;
}

function isSimNao(campo, justificativa){
	if(campo[0].checked){
	}else if(campo[1].checked){
		if(justificativa.value.length < 10){
			incompleto = 1;
		}
	}else{
		incompleto = 1;
	}
}

function verificaObrigatorios(){
	faltaObrigatorio = 0;
	verificaHorario();
	verificaEmail();
	totalAlunos(0);
	verificaPeriodicidade();
	verificaHorario();
	verificaObrigatorio(document.salaAula.nomeDisciplina, msgNomeDisciplina);
	verificaObrigatorio(document.salaAula.periodo, msgPeriodo);
	verificaObrigatorio(document.salaAula.ramal, msgRamal);
	verificaObrigatorio(document.salaAula.nomeProfessor, msgNomeProfessor);
	verificaObrigatorio(document.salaAula.cursosPertence, msgCursosPertence);
	verificaObrigatorio(document.salaAula.salaAtual, msgSalaAtual);
}
	
function verificaNaoObrigatorios(){
	incompleto = 0;
	verificaNaoObrigatorio(document.salaAula.equipamentosFrequentes);
	verificaNaoObrigatorio(document.salaAula.equipamentosIndispensaveis);
	verificaNaoObrigatorio(document.salaAula.linkMaterial);
	verificaNaoObrigatorio(document.salaAula.material);
	verificaNaoObrigatorio(document.salaAula.equipamentosNaoDisponiveis);
	verificaNaoObrigatorio(document.salaAula.equipamentosNaoUtilizados);
	isSimNao(document.salaAula.disciplinaNoturna, document.salaAula.justificativaNoturna);
	isSimNao(document.salaAula.disciplinaSabado, document.salaAula.justificativaSabado);	
	verificaNaoObrigatorio(document.salaAula.contribuicao);
}
	
function preEnvio(){
	verificaObrigatorios();
	verificaNaoObrigatorios();
	if(faltaObrigatorio == 1){
		alert("Verifique o preenchimento das informações!");
	} else if(incompleto == 1){
		if(confirm("Alguns campos não foram preenchidos. A avaliação de sua solicitação será prejudicada. Confirma a solicitação?")){
			return true;
		}
	} else {
		return true;
	}
	return false;
}