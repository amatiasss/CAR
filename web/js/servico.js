var faltaObrigatorio = 0;

function verificaObrigatorio(dados, mensagem){
	if(dados.value.length < 2){
		faltaObrigatorio = 1;
		mensagem.innerHTML = " - campo obrigatório";
	} else{
		mensagem.innerHTML = "";
	}
}

function recarrega(){
       document.servico.operacao.value  = "enviarEmail";
}

function abreJanela(){
        NovaJanela = window.open ("AjudaServico.html", "Ajuda", "scrollbars=yes,width=500,height=500")
}

function verificaEmail(){
	var valor = document.servico.email.value;
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

//Verifica a seleção de um tipo de manutenção
function verificaSelecao(){
         if(document.servico.tipo[0].checked || document.servico.tipo[1].checked || document.servico.tipo[2].checked){
                msgTipo.innerHTML = ""
         } else{
                msgTipo.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1;
         }
}


function verificaTipoManutencao(){
         if(document.servico.tipoManutencao[0].checked || document.servico.tipoManutencao[1].checked){
                msgTipoManutencao.innerHTML = ""
         } else{
                msgTipoManutencao.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1;
         }
}

function verificaManutencao(){
         verificaTipoManutencao();
         verificaObrigatorio(document.servico.descricao, msgDescricao);
}

//insere os campos referentes a manutenção de rede ou máquina
function manutencao(){

         local.innerHTML = "<font color='#0000FF'>Selecione o tipo de manutenção</font><font id=msgTipoManutencao color='#FF0000'> </font>: <br><input type='radio' name='tipoManutencao' value='REDE'>Rede <br> <input type='radio' name='tipoManutencao' value='MAQUINA'>Maquina <br><font color='#0000FF'> Como forma de auxiliar nossa equipe, descreva <B>precisamente </B>qual o problema identificado.</font>.<font id=msgDescricao  color='#FF0000'></font> <br><textarea rows='10' cols='90' name='descricao'></textarea>"
}




function verificaTipoServico(){
         if(document.servico.tipoServico[0].checked || document.servico.tipoServico[1].checked){
                msgTipoConta.innerHTML = ""
         } else{
                msgTipoConta.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1;
         }
}

function mensagemConta(){
         if (document.servico.tipoServico[0].checked){
            msgInfo.innerHTML = "<br>Justifique a necessidade de abertura de nova conta no sistema, quais os usos que fará da mesma e qual o prazo previsto para encerramento.<br>Sugira o nome da conta!";
         }else if(document.servico.tipoServico[1].checked){
            msgInfo.innerHTML = "<br>Informe a manutenção desejada."
         }
}

function verificaConta(){
         verificaTipoServico();
         verificaObrigatorio(document.servico.justificativa, msgJustificativa);
         verificaObrigatorio(document.servico.conta, msgConta);
}

//insere os campos referentes a serviço em conta
function servicoConta(){
         local.innerHTML="<font color='#0000FF'>Selecione o tipo de serviço</font><font id=msgTipoConta color='#FF0000'></font>: <br><input type='radio' name='tipoServico' value='ABERTURA' onClick='mensagemConta()'>Abertura <br> <input type='radio' name='tipoServico' value='MANUTENCAO' onClick='mensagemConta()'>manutenção<br><font color='#0000FF'> <font id=msgInfo color='#0000FF'></font><font id=msgJustificativa color='#FF0000'></font> <br><textarea rows='10' cols='90' name='justificativa'></textarea><br>Forneça o login da conta<font id=msgConta  color='#FF0000'></font>:<br><input type='text' size='50' name='conta'>";
}

//Verifica se o tipo de software foi selecionado e exibe o campo link, se necessário
function verificaTipoSoftware(){
         if(document.servico.tipoSoftware[0].checked || document.servico.tipoSoftware[1].checked){
                msgTipoSoftware.innerHTML = "";
         } else{
                msgTipoSoftware.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1;
         }
}
//Verifica se o tipo de software foi selecionado e exibe o campo link, se necessário
function verificaIncluiSoftware(){
         if(document.servico.tipoSoftware[0].checked || document.servico.tipoSoftware[1].checked){
                msgTipoSoftware.innerHTML = "";
                if(document.servico.tipoSoftware[0].checked){
                       link.innerHTML = "<font color='blue'>Link:<br><input type='text' size='75' name='link'>";
                 }else if(document.servico.tipoSoftware[1].checked){
                       link.innerHTML = ""
                 }
         } else{
                msgTipoSoftware.innerHTML = " - selecione uma das opções abaixo"
                faltaObrigatorio = 1;
         }
}


function verificaSoftware(){
         verificaObrigatorio(document.servico.nomeSoftware, msgNomeSoftware);
         verificaObrigatorio(document.servico.localInstalacao, msgLocalInstalacao);
         verificaTipoSoftware();
}


//insere os campos referentes a instalação de software
function instalacao(){
         local.innerHTML="<font color='#0000FF'>Para softwares disponíveis gratuitamente, informe o endereço para download.<br> Caso o software não seja gratuito, a mídia deverá ser fornecida para a administração do REENGE juntamente com a licença original, para que uma cópia da mesma possa ser arquivada para efeitos de controle.<br> O software é gratuito?<font id=msgTipoSoftware color='#FF0000'></font><br> <input type='radio' name='tipoSoftware' value='SIM' onClick='verificaIncluiSoftware()'>Sim.<br> <input type='radio' name='tipoSoftware' value='NAO' onClick='verificaIncluiSoftware()'>Não, mas possuo licença do software.<br><font id=link></font><br> Informe o nome do software:<font id=msgNomeSoftware color='#FF0000'></font><br><input type='text' size='50' name='nomeSoftware' onBlur='verificaObrigatorio(document.servico.nomeSoftware, msgNomeSoftware)'><br><font color='#0000FF'><br><font color='#0000FF'>Local de Instalação: </font><font id = msgLocalInstalacao color='#FF0000'> </font> <input type='text' size=11 name='localInstalacao'>"
}



function verificaObrigatorios(){
         recarrega();
         faltaObrigatorio = 0;
         verificaObrigatorio(document.servico.nome, msgNome);
         verificaSelecao();
         verificaEmail();
}

function cancelar(){
	if(confirm("confirma o cancelamento?") == true){
		window.location="index.html";
	}
}

function refresh(){
         if(document.servico.tipo[0].checked){
                 instalacao();
         }else if(document.servico.tipo[1].checked){
                 servicoConta();
                 mensagemConta();
         }else if(document.servico.tipo[2].checked){
                 manutencao();
         }
}

function mudanca(tipo){
         if(tipo == "INSTALACAO"){
                 instalacao();
         }else if(tipo == "SERVICOCONTA"){
                 servicoConta();
         }else if(tipo == "MANUTENCAO"){
                 manutencao();
         }
         verificaSelecao();
}



function preEnvio(){
         verificaObrigatorios();
         if(document.servico.tipo[0].checked){
                 verificaSoftware();
         } else if(document.servico.tipo[1].checked){
                 verificaConta();
         }  else if(document.servico.tipo[2].checked){
                 verificaManutencao();
         }
         if(faltaObrigatorio == 1){
		alert("Campo(s) obrigatório(s) não foi (foram) preenchido(s)!")
	} else{
               return true;
        }
        return false;
}