<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function removerCliente(nome,setor){
	question = confirm("Confirma remoção do cliente?")
	if (question !="0"){
		document.location.href  ="/appCentralAtendimentoReenge/cadastroEmails/cadastroEmail?operacao=removerResponsavel&setorResponsavel="+ setor +"&nome="+ nome;
	}
}
//--></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Lista de Responsáveis</title>
<style type="text/css">
<!--
.style1 {font-family: Verdana, Arial, Helvetica, sans-serif}
.style3 {font-family: Verdana, Arial, Helvetica, sans-serif; color: #FFFFFF; font-weight: bold; }
-->
</style>
</head>

<body>
<p align="right"><font face="Verdana">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="window.open ('ajudaListagem.html', 'Ajuda', 'scrollbars=yes,width=500,height=500')"><font face="Arial" size="5" color="#0000FF"><u>Ajuda</u></font></p>
<% int c = 0;%>
<p class="style1">
  <c:out value="${mensagem}" />
</p>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td bgcolor="#000000" class="style3">Nome</td>
    <td bgcolor="#000000" class="style3">Email</td>
    <td bgcolor="#000000" class="style3">Remover</td>
  </tr>
  <tr>
    <c:forEach var="resp" items="${responsaveis}">
    <td class="style1"><c:out value="${resp.nome}"/></td>
    <td class="style1"><c:out value="${resp.email}"/></td>
    <td class="style1"><img src="remove.jpg" alt="Remover" width="16" height="16" onClick="removerCliente('${resp.nome}', '${setorResponsavel}'); return false;"> 
  </tr>
  <tr>
    </c:forEach>
</table>
</body>
</html>
