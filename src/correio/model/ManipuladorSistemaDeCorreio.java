package correio.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import correio.email.logic.SistemaDeCorreio;
import correio.email.logic.SistemaDeCorreioEMail;
import facade.CampoVazioInvalidoException;


/**
 * Classe que manipula operacoes de sistemas de correios.
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 *
 */
public class ManipuladorSistemaDeCorreio {
	
	// Atributos
	
	private SistemaDeCorreio sistemaEmail;

	/**
	 * Construtor do sistema de correio.
	 * @param contexto diretorio onde está o arquivo
	 * @param nomeArquivoXML nome do arquivo utilizado para a criacao
	 * 
	 */
	public ManipuladorSistemaDeCorreio(String contexto) {
		
		sistemaEmail = new SistemaDeCorreioEMail(contexto);

	}

	

	/**
	 * Inicializa um sistema de correio.
	 * @param nomeDoSistema O nome do sistema de correio.
	 * @throws IOException
	 */
	/*public void initCorreio() throws IOException {
		 sistemaEmail.init();
		 
				
			
	}*/

	/**
	 * Envia um documento usando o sistema de correio adequado aquele cliente.
	 * @param attachFiles Conjunto de arquivo a serem enviados em anexo.
	 * @param emailRemetente O endereço email do rementente.
	 * @param documento Mensagem que será enviada no e-mail.
	 * @throws IOException
	 * @throws CampoVazioInvalidoException 
	 * 
	 */
	public void enviarDocumento(Set<File> attachFiles,String emailRemetente, String documento, String tituloEmail, int tipo) throws FileNotFoundException, IOException, CampoVazioInvalidoException {
			
				sistemaEmail.enviarDocumento(attachFiles,emailRemetente, documento, tituloEmail, tipo);
		
	}

	
}