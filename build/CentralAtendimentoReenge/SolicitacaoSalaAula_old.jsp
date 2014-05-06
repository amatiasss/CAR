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
<form name="salaAula" method="post" action="/atendimentoReenge">
  <table border="0" cellspacing="0" width="876" cellpadding="0" height="213">
    <tr>
      <td width="249" height="21">Nome da disciplina<font color="#FF0000">*</font>:
      </td>
      <td width="233" height="21">
                <input name="nomeDisciplina" type="text" size="45"></td>
      <td width="157" height="21">Período<font color="#FF0000">*</font>:</td>
      <td width="237" height="21">
                <input name="periodo" type="text" size="10"></td>
    </tr>
    <tr>
      <td width="249" height="21">Professor<font color="#FF0000">*</font>: </td>
      <td width="233" height="21">
                <input name="nomeProfessor" type="text" size="45"></td>
      <td width="157" height="21">Ramal<font color="#FF0000">*</font>:</td>
      <td width="237" height="21">
                <input name="ramal" type="text" size="5"></td>
    </tr>
    <tr>
      <td width="249" height="21">E-mail<font color="#FF0000">*</font>: </td>
      <td width="233" height="21">
                <input name="email" type="text" size="30"></td>
      <td width="157" height="21">Nº de Alunos<font color="#FF0000">*</font>:</td>
      <td width="237" height="21">
                <input name="numeroAlunos" type="text" size="3"></td>
    </tr>
    <tr>
      <td width="249" height="21">Curso(s) a que pertence(m)<font color="#FF0000">*:</font></td>
      <td width="233" height="21">
                <input name="cursosPertence" type="text" size="35"></td>
      <td width="157" height="21">Horário da disciplina<font color="#FF0000">*</font>:</td>
      <td width="237" height="21">
				<input name="horarioDisciplina" type="text" size="40"></td>
    </tr>
    <tr>
      <td width="455" height="30" colspan="2">Periodicidade de oferta da disciplina<font color="#FF0000">*</font>:</td>
      <td width="157" height="30">Sala atual<font color="#FF0000">*</font>:</td>
      <td width="237" height="30">
				<input name="salaAtual" type="text" size="8"></td>
    </tr>
    <tr>
      <td width="249" rowspan="2" height="99">
				<input type="radio" name="opcaoPeriodicidade" value="TRIMESTRAL">Trimestral<BR>
				<input type="radio" name="opcaoPeriodicidade" value="SEMESTRAL">Semestral<BR>
				<input type="radio" name="opcaoPeriodicidade" value="ANUAL">Anual<BR>
				<input type="radio" name="opcaoPeriodicidade" value="OUTRA">Outra	(especifique)&nbsp;
      </td>
      <td width="233" height="60">&nbsp;</td>
      <td width="157" rowspan="2" height="99">&nbsp;</td>
      <td width="237" rowspan="2" height="99">&nbsp;</td>
    </tr>
    <tr>
      <td width="233" height="39"> <input name="periodicidade" type="text" size="20"></td>
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
<b>Obs: os campos com asterisco são de preenchimento obrigatório.</b><br>
<b>O não preenchimento dos demais campos resultará em envio com aviso. Neste caso,  
a avaliação da solicitação será prejudicada.</b><p><p>
<center>
	<button value="Submeter" type=submit>Submeter</button>
	<button value="Cancelar" type=reset>Cancelar</button>
	<button value="Ajuda">Ajuda</button></center>
</form>
<a href="Index.html">Página principal</a><p>
</BODY>
</HTML>