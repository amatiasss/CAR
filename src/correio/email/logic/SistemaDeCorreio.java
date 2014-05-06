package correio.email.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import facade.CampoVazioInvalidoException;


/**
 * Interface que representa um sistema de correio.
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 *
 */
public interface SistemaDeCorreio {
	
	

	/**
	 * Inicializa o sistema.
	 * @throws IOException
	 */
	//public void init() throws IOException;

	/**
	 * Envia um documento.
	 * @param attachFiles Conjunto de arquivo a serem enviados em anexo.
	 * @param emailRemetente O endereço email do rementente.
	 * @param documento Mensagem que será enviada no e-mail.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void enviarDocumento(Set<File> attachFiles,String emailRemetente, String documento, String tituloEmail, int tipo) throws FileNotFoundException, IOException, CampoVazioInvalidoException;


}
