package correio.email.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.mail.MessagingException;

import facade.CampoVazioInvalidoException;
import formulario.logic.email.CadastroEmail;


/**
 * Classe que representa um sistema de correio de email.
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 *
 */
public class SistemaDeCorreioEMail implements SistemaDeCorreio, Sistema {
	
	// Atributos
	//private File arquivo;
	//private final String NOME_ARQUIVO_SAIDA = "/emailLog.txt";
	@SuppressWarnings("unused")
	private String contexto;
	//private final String NOME_DO_DIRETORIO_TEMP = "/temp/";
	private Set<String> conjuntoEmails;
	
	private CadastroEmail cadastroEmail;
	
	
	/**
	 * Construtor do sistema de correio.
	 * @param nomeArquivoXML Arquivo contendo os e-mail dos demais destinatários.
	 * @param contexto Path da aplicacao
	 */
	@SuppressWarnings("unchecked")
	public SistemaDeCorreioEMail(String contexto) {
		this.contexto = contexto;
		ConexaoXML conexao = new ConexaoXML();
		String arquivo = this.contexto + "/CadastroEmail.xml";
		System.out.println(arquivo);       
		cadastroEmail = (CadastroEmail) conexao.read(arquivo);
		
	}

		/**
	 * Inicializa o sistema.
	 * @throws IOException
	 */
	/*public void init() throws IOException {
		//TODO talvez n�o ser� preciso!!!
		if (arquivo.exists())
			arquivo.delete();
		arquivo.createNewFile();
	}*/

	/**
	 * Envia um documento.
	 * @param attachFiles Conjunto de arquivo a serem enviados em anexo.
	 * @param emailRemetente O endereço email do rementente.
	 * @param documento Mensagem que será enviada no e-mail.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void enviarDocumento(Set<File> attachFiles,String emailRemetente, String documento, String tituloEmail, int tipo) throws IOException, CampoVazioInvalidoException {
		
		
		//Iterator<String> it = conjuntoEmails.iterator(); 
		String[] para; //= new String[conjuntoEmails.size()+1];
		
		Set<String> cadastro = null;
		if(tipo == SALA){
			cadastro = cadastroEmail.getEmailsCadastroSala();
		} else if(tipo == LABORATORIO){
			cadastro = cadastroEmail.getEmailsCadastroLaboratorio();
		} else if(tipo == RECLAMACAO){
			cadastro = cadastroEmail.getEmailsCadastroReclamacao();
		} else if(tipo == SUGESTAO){
			cadastro = cadastroEmail.getEmailsCadastroSugestao();
		}else if(tipo == SERVICO){
			cadastro = cadastroEmail.getEmailsCadastroServico();
		} else if(tipo == OUTRO){
			cadastro = cadastroEmail.getEmailsCadastroOutro();
		}
		para = new String[cadastro.size()+1];
		Iterator<String> it = cadastro.iterator();
		int i = 0;
		while(it.hasNext()){
			para[i] = it.next();
			i++;
		}
		para[i] = emailRemetente;
		
		
		try {
			new GmailJavaMail().sendSSLMessage(para, "[CentralAtendimentoReenge] " + tituloEmail,attachFiles,documento, "proen.suporte@gmail.com");
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new CampoVazioInvalidoException("Campo Vazio");
		}

	}
}