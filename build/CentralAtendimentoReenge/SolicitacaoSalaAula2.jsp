<HTML>
	<HEAD>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="description" content="Solicitação de sala de aula">
		<meta name="author" content="Rodrigo Lopes">
	</HEAD>
<BODY TEXT="#000000" >
<h2>Solicitação de sala de aula no bloco REENGE</h2><br>
&nbsp;&nbsp;&nbsp; Nesta página, os professores podem solicitar salas de aula no bloco REENGE.<br>
&nbsp;&nbsp;&nbsp; Para facilitar a avaliação da solicitações, preencha de forma objetiva os campos abaixo.<p><p>
<div align="left">

<script>
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
	} else if(total <1 || total > 55){
		msgNumeroAlunos.innerHTML = " - número de alunos inválido";
		faltaObrigatorio = 1;
	} else{
		msgNumeroAlunos.innerHTML = " "
	}
}

function cancelar(){
	if(confirm("confirma o cancelamento? Se você cancelar, as futuras solicitações terão suas avaliações prejudicadas.")){
		document.salaAula.reset();
	}
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

function isSimNao(campo){
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
	isSimNao(document.salaAula.disciplinaNoturna);
	isSimNao(document.salaAula.disciplinaSabado);	
	verificaNaoObrigatorio(document.salaAula.contribuicao);
}
	
function preEnvio(){
	verificaObrigatorios();
	verificaNaoObrigatorios();
	if(faltaObrigatorio == 1){
		alert("Verifique o preenchimento das informações!");
	} else if(incompleto == 1){
		if(confirm("Alguns campos não foram preenchidos. A avaliação de sua solicitação será prejudicada. Confirma a solicitação?")){
			document.salaAula.submit();
		}
	} else {
		document.salaAula.submit();
	}
}
</script>

<form name="salaAula" method="post" action="/atendimentoReenge" enctype="multipart/form-data">
  <table border="0" cellspacing="0" width="889" cellpadding="0" height="199" style="border-width:0; ">
    <tr>
      <td width="262" height="21" ><font color="#0000FF">Nome da disciplina</font><font id=msgNomeDisciplina color="#FF0000"> </font>:
      </td>
      <td width="233" height="21">
                <input name="nomeDisciplina" type="text" size="45" onblur="verificaObrigatorio(this, msgNomeDisciplina)"></td>
      <td width="155" height="21"><font color="#0000FF">Período</font><font id=msgPeriodo color="#FF0000"> </font>:</td>
      <td width="239" height="21">
                <input name="periodo" type="text" size="10" onblur="verificaObrigatorio(this, msgPeriodo)"></td>
    </tr>
    <tr>
      <td width="262" height="21"><font color="#0000FF">Professor</font><font id=msgNomeProfessor color="#FF0000"> </font>: </td>
      <td width="233" height="21">
                <input name="nomeProfessor" type="text" size="45" onblur="verificaObrigatorio(this, msgNomeProfessor)"></td>
      <td width="155" height="21"><font color="#0000FF">Ramal</font><font id=msgRamal color="#FF0000"> </font>:</td>
      <td width="239" height="21">
                <input name="ramal" type="text" size="5" onblur="verificaObrigatorio(this, msgRamal)"></td>
    </tr>
    <tr>
      <td width="262" height="21"><font color="#0000FF">E-mail</font><font id=msgEmail color="#FF0000"> </font>: </td>
      <td width="233" height="21">
                <input name="email" type="text" size="30" onblur="verificaEmail(this, msgEmail)"></td>
      <td width="155" height="21"><font color="#0000FF">Nº de Alunos</font><font id=msgNumeroAlunos color="#FF0000"> </font>:</td>
      <td width="239" height="21">
                <input name="numeroAlunos" type="text" size="3" onblur="totalAlunos(1)"></td>
    </tr>
    <tr>
      <td width="262" height="21"><font color="#0000FF">Curso(s) a que 
      pertence(m) / Público alvo</font><font id=msgCursosPertence color="#FF0000"> :</font></td>
      <td width="233" height="21">
                <input name="cursosPertence" type="text" size="35" onblur="verificaObrigatorio(this, msgCursosPertence)"></td>
      <td width="394" height="126" colspan="2" rowspan="4"><font color="#0000FF">
      <fieldset style="padding: 2">
      <legend>Horário da disciplina<font color="#FF0000"> </font>:</legend><font id=msgHorario color=FF0000> </font>
      <table border="1" cellspacing="1" style="border-collapse: collapse; border-width: 0" bordercolor="#FFFFFF" width="100%">
        <tr>
          <td width="33%" style="border-style: none; border-width: medium"><font color="#0000FF">Dias 
      da semana</font></td>
          <td width="33%" style="border-style: none; border-width: medium">
      <font color="#0000FF">Início</font></td>
          <td width="34%" style="border-style: none; border-width: medium">
      <font color="#0000FF">Término</font></td>
        </tr>
        <tr>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="dia1" >
      <option> </option>
      <option value="Seg">Seg</option>
      <option value="Ter">Ter</option>
      <option value="Qua">Qua</option>
      <option value="Qui">Qui</option>
      <option value="Sex">Sex</option>
      <option value="Sab">Sab</option>
      </select></td>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="inicio1" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
          <td width="34%" style="border-style: none; border-width: medium"><select size="1" name="fim1" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
        </tr>
        <tr>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="dia2" >
      <option> </option>
      <option value="Seg">Seg</option>
      <option value="Ter">Ter</option>
      <option value="Qua">Qua</option>
      <option value="Qui">Qui</option>
      <option value="Sex">Sex</option>
      <option value="Sab">Sab</option>      
      </select></td>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="inicio2" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
          <td width="34%" style="border-style: none; border-width: medium"><select size="1" name="fim2" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
        </tr>
        <tr>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="dia3" >
      <option> </option>
      <option value="Seg">Seg</option>
      <option value="Ter">Ter</option>
      <option value="Qua">Qua</option>
      <option value="Qui">Qui</option>
      <option value="Sex">Sex</option>
      <option value="Sab">Sab</option>      
      </select></td>
          <td width="33%" style="border-style: none; border-width: medium"><select size="1" name="inicio3" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
          <td width="34%" style="border-style: none; border-width: medium"><select size="1" name="fim3" >
      <option> </option>
      <option value="07">07</option>
      <option value="08">08</option>
      <option value="09">09</option>
      <option value="10">10</option>
      <option value="11">11</option>
      <option value="12">12</option>
      <option value="13">13</option>
      <option value="14">14</option>
      <option value="15">15</option>
      <option value="16">16</option>
      <option value="17">17</option>
      <option value="18">18</option>
      <option value="19">19</option>
      <option value="20">20</option>
      <option value="21">21</option>
      <option value="22">22</option>
      </select></td>
        </tr>
      </table>
      </fieldset></font></td>
    </tr>
    <tr>
      <td width="455" height="30" colspan="2" style="border-right-style: none; border-right-width: medium"><font color="#0000FF">Periodicidade de oferta da disciplina</font><font color="#FF0000"> </font>:</td>
    </tr>
    <tr>
      <td width="262" rowspan="3" height="85">
				<p style="margin-top: 0; margin-bottom: 0">
				<input type="radio" name="opcaoPeriodicidade" value="TRIMESTRAL" onChange="verificaPeriodicidade()">Trimestral<BR>
				<input type="radio" name="opcaoPeriodicidade" value="SEMESTRAL" onChange="verificaPeriodicidade()">Semestral<BR>
				<input type="radio" name="opcaoPeriodicidade" value="ANUAL" onChange="verificaPeriodicidade()">Anual<BR>
				<input type="radio" name="opcaoPeriodicidade" value="OUTRA" onChange="verificaPeriodicidade()">Outra	(especifique)&nbsp;
      </td>
      <td width="233" height="60">&nbsp;<font color=FF0000 id=msgPeriodicidade></font></td>
    </tr>
    <tr>
      <td width="233" height="25" rowspan="2"> <input name="periodicidade" type="text" size="20" onClick="ativarOpcao()"></td>
    </tr>
    <tr>
      <td width="155" height="11"><font color="#0000FF">Sala atual</font><font id=msgSalaAtual color="#FF0000"> </font>:</td>
      <td width="239" height="11">
				<input name="salaAtual" type="text" size="8" onblur="verificaObrigatorio(this, msgSalaAtual)"></td>
    </tr>
  </table>
</div><br>
Informe os equipamentos que você utiliza em suas aulas e a freqüência de utilização dos mesmos:<br>
	<textarea name="equipamentosFrequentes" rows="10" cols="100"></textarea><p>
Quais dos equipamentos acima são indispensáveis para execução da sua disciplina e por qual motivo?<br>
<textarea name="equipamentosIndispensaveis" rows="10" cols="100"></textarea><p>
Forneça link para o material eletrônico da disciplina.<br>
<textarea name="linkMaterial" rows="2" cols="100"></textarea><p>
Caso não possua o material on-line, anexe um cópia do mesmo.<br>
<input  type="file" name="material" size=60><p>
De quais outros equipamentos você necessitaria mas não dispõe na sala atual da disciplina?<br>
<textarea name="equipamentosNaoDisponiveis" rows="10" cols="100"></textarea><p>
Quais os equipamentos atualmente disponíveis na sua sala você não utiliza regularmente?<br>
<textarea name="equipamentosNaoUtilizados" rows="10" cols="100"></textarea><p>
Esta disciplina poderia ser alocada para horário noturno?<br>
<input type="radio" name="disciplinaNoturna" value="SIM">Sim</input><br>
<input type="radio" name="disciplinaNoturna" value="NAO">Não</input><br>
Justifique, caso a resposta seja negativa.<br>
<textarea name="justificativaNoturna" rows="10" cols="100"></textarea><P>
Esta disciplina poderia ser ofertada nos sábados?<br>
<input type="radio" name="disciplinaSabado" value="SIM">Sim</input>. Em caso afirmativo, em que 
turno?<select size="1" name="turnoSabado">
			<option value="Manhã">Manhã</option>
			<option value="Tarde">Tarde</option>
			<option value="Noite">Noite</option>
		</select><br>
<input type="radio" name="disciplinaSabado" value="NAO">Não</input><br>
Justifique, caso a resposta seja negativa.<br>
<textarea name="justificativaSabado" rows="10" cols="100"></textarea><p>
De que forma você pode contribuir para a melhoria do REENGE e do seu funcionamento?<br>
<textarea name="contribuicao" rows="10" cols="100"></textarea><p>
<b>Obs: os campos de cor azul são de preenchimento obrigatório.</b><br>
<b>O não preenchimento dos demais campos resultará em envio com aviso. Neste caso,  
a avaliação da solicitação será prejudicada.</b><p><p>
<center>
	<button value="Submeter" onclick="preEnvio()">Submeter</button>
	<button value="Cancelar" onClick="cancelar()">Cancelar</button>
	<button value="Ajuda" onClick="verificaHorario()">Ajuda</button></center>
</form>
<a href="Index.html">Página principal</a><p>
</BODY>
</HTML>