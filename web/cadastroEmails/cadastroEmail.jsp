<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<form action="/appCentralAtendimentoReenge/cadastroEmails/cadastroEmail" name="formCadastroEmail" method="post" class="style1" id="form1" >
<input type="hidden" name="operacao" value="cadastrar"/>
  <p>	<b>	<font face="Verdana" color="#0000FF">Cadastro de Emails para Central de Atendimento Reenge
  </font> </b> </p>
  <p align="right"><font face="Verdana">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.open ('ajudaCadastraEmail.html', 'Ajuda', 'scrollbars=yes,width=500,height=500')"><font face="Arial" size="5" color="#0000FF"><u>Ajuda</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font></a></p>
  <table width="464" height="175" border="1">
    <tr>
      <td><font face="Verdana"><font color="#0000FF">Nome do Respons&aacute;vel:</font> </font> </td>
      <td><label>
        <font face="Verdana">
        <input name="nome" type="text" id="nome" value = "${nome}" size="20" />
      </font>
      </label></td>
    </tr>
    <tr>
      <td><font face="Verdana" color="#0000FF">E-mail para cadastrar:</font></td>
      <td><label>
        <font face="Verdana">
        <input name="email" type="text" id="email" value = "${email}" size="20"/>
      </font>
      </label></td>
    </tr>
    <tr>
      <td><font face="Verdana" color="#0000FF">Setor Respons&aacute;vel:</font></td>
      <td><label>
      <font face="Verdana">
      <select name="setorResponsavel" id="setorResponsavel" >
        <option value="laboratorio" selected="selected">Laborat&oacute;rio</option>
        <option value="outro">Outro</option>
        <option value="reclamacao">Reclama&ccedil;&atilde;o</option>
        <option value="sala">Sala</option>
        <option value="servico">Servi&ccedil;o</option>
        <option value="sugestao">Sugest&atilde;o</option>
      </select> </font>
      </label></td>
    </tr>
    <tr>
      <td><label>
        <font face="Verdana">
        <input name="cadastrar" type="submit" id="cadastrar" value="Cadastar" />
      </font>
      </label></td>
      <td><label>
        <font face="Verdana">
        <input name="cancelar" type="submit" id="cancelar" value="Cancelar" />
      </font>
      </label></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>