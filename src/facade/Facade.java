package facade;

import hibernate.ManipuladorDeBancoDeDados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import correio.email.logic.Sistema;
import correio.model.ManipuladorSistemaDeCorreio;

/**
 * Facade que acessa a logica da Aplicacao.
 * 
 * @author Romulo Calado  
 * @author Rodrigo Lopes
 * @author Hamon Barros
 */

public class Facade implements Sistema{
	// Responsavel pela manipulacao e envio de arquivo.
	private ManipuladorSistemaDeCorreio manipuladorEmail;

	private ManipuladorDeBancoDeDados manipuladorDoBD;

	/**
	 * Constroi uma Nova Facade
	 * 
	 * @param contexto
	 *            O Path da aplicacao
	 */
	public Facade(String contexto) {

		manipuladorEmail = new ManipuladorSistemaDeCorreio(contexto);
		manipuladorDoBD = new ManipuladorDeBancoDeDados();
	}

	/**
	 * Facade.java
	 * 
	 * Envia um e-mail para o remetente da e os demais endereços de e-mail
	 * contido no XML nomeArquivoXML.
	 * 
	 * @param emailRemetente
	 *            O endereço email do rementente.
	 * @param documento
	 *            Mensagem que será enviada no e-mail.
	 * @param attachFiles
	 *            Conjunto de arquivo a serem enviados em anexo.
	 * @throws FileNotFoundException
	 *             lancada se algum arquivo do set de arquivo não existir.
	 * @throws IOException
	 *             Lancada se o e-mail se ocorrer algum erro de envio do e-mail.
	 * @throws CampoVazioInvalidoException
	 *             Lancada se algum campo for vazio ou invalido.
	 */
	public boolean enviarEmail(Set<File> attachFiles, String emailRemetente,
			String documento, String tituloEmail, int tipo) throws FileNotFoundException,
			IOException, CampoVazioInvalidoException {
		boolean retorno = true;
		try {
			manipuladorEmail.enviarDocumento(attachFiles, emailRemetente,
					documento, tituloEmail, tipo);
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}

	public boolean grava(Object objeto, String realPathContext) {
		boolean retorno = true;
		try {
			manipuladorDoBD.insere(objeto, realPathContext);
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}

}
