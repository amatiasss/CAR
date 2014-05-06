package formulario.outro.logic;

import usuario.logic.Usuario;
import auto_Atendimento.logic.Outro;
import formulario.servico.logic.Servico;

public class FormularioOutro{
	private final String NOVALINHA = System.getProperty("line.separator");
	
	private Outro outro; 
	private StringBuffer mensagem;
	
	public FormularioOutro() {
		outro = new Outro();
	}
	public FormularioOutro(String nome, String emailRemetente, String ramal, String comentario, String string) {
		outro = new Outro(comentario);
		this.outro.setUsuario(new Usuario(nome, emailRemetente, ramal));
		mensagem = new StringBuffer();
	}
	
	public void escreveCartaOutro(){
		mensagem.append("O(A) Sr(a) ");
		mensagem.append(outro.getUsuario().getNome());
		mensagem.append(" deixou o seguinte comentário: ");
		mensagem.append(NOVALINHA);
		mensagem.append(outro.getComentario());
		mensagem.append(NOVALINHA);
		mensagem.append("Os contatos do solicitante são:");
		mensagem.append(NOVALINHA);
		mensagem.append("e-mail: " + outro.getUsuario().getEmail());
		mensagem.append(NOVALINHA);
		if (!outro.getUsuario().getRamal().equals("")) {
			mensagem.append("Ramal: ");
			mensagem.append(outro.getUsuario().getRamal());
			mensagem.append(NOVALINHA);
		}
		mensagem.append(NOVALINHA);
		mensagem.append("Mensagem enviada:");
		mensagem.append(outro.getDataSemanal());
		
	}
	public String toString(){
		return mensagem.toString();
	}
	public Outro getOutro() {
		return outro;
	}
	public void setOutro(Outro outro) {
		this.outro = outro;
	}
	
	

}
