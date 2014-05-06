function pop()
{
  if(document.opcoes.Responsavel.value.length > 1){
	document.opcoes.setorResponsavel.value = document.opcoes.Responsavel.value;
	return true;
  }
}