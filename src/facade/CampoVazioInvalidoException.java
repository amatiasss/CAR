package facade;
/**
 * Excecao lancada quando o conteudo de um campo estiver
 * vazio ou invalido
 * @author Romulo Calado
 *
 */
public class CampoVazioInvalidoException extends Exception {

	
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor da excecao
	 * @param message
	 */
	public CampoVazioInvalidoException(String message) {
		super(message);
	
	}


}
