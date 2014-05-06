package formulario.servico.logic;

import org.omg.PortableInterceptor.INACTIVE;

import auto_Atendimento.logic.AutoAtendimento;
import usuario.logic.Usuario;
import formulario.logic.Formulario;

public class FormularioServico {
	// Atributos
	private final String NOVALINHA = System.getProperty("line.separator");

	//private Usuario usuario = new Usuario();
	
	//private AutoAtendimento usuario = new AutoAtendimento();

	private StringBuffer mensagem;

	//private String tipoDeServico;

	private InstalacaoSoftware instalacaoDeSoftware;

	private ServicoConta servicoConta;
	
	private Manutencao manutencao;

	public FormularioServico() {

	}

	public FormularioServico(String nome, String emailRemetente, String ramal,
			StringBuffer link, String nomeSoftware, String localInst) {
		mensagem = new StringBuffer();
		String linkRecebido = link.toString();
		instalacaoDeSoftware = new InstalacaoSoftware(linkRecebido, nomeSoftware, localInst);
		this.instalacaoDeSoftware.setUsuario( new Usuario(nome, emailRemetente, ramal));
		/*this.usuario.setNome(nome);
		this.usuario.setEmail(emailRemetente);
		this.usuario.setRamal(ramal);*/
		
		

	}

	public FormularioServico(String nome, String emailRemetente, String ramal,
			String justificativa, String login, String tipo) {
		servicoConta = new ServicoConta(tipo,justificativa, login);
		/*		this.usuario.setNome(nome);
		this.usuario.setEmail(emailRemetente);
		this.usuario.setRamal(ramal);*/
		this.servicoConta.setUsuario( new Usuario(nome, emailRemetente, ramal));
		mensagem = new StringBuffer();
		

	}

	public FormularioServico(String nome, String emailRemetente, String ramal, String tipoManutencao, StringBuffer descricao) {
		manutencao = new Manutencao(tipoManutencao, descricao.toString());
		this.manutencao.setUsuario( new Usuario(nome, emailRemetente, ramal));
		
		/*this.usuario.setNome(nome);
		this.usuario.setEmail(emailRemetente);
		this.usuario.setRamal(ramal);*/
		
		mensagem = new StringBuffer();
	}

	public void escreveCartaInstalacao() {

		mensagem.append("O(A) Sr(a) ");
		mensagem.append(instalacaoDeSoftware.getUsuario().getNome());
		mensagem.append(" solicitou a instalação de um software. ");
		mensagem.append(NOVALINHA);
		mensagem.append("O local de instalação do software é: ");
		mensagem.append(instalacaoDeSoftware.getLocalInstalacao());
		mensagem.append(NOVALINHA);
		if (!instalacaoDeSoftware.getLink().equals("")) {
			mensagem.append("O usuário disse que o software era gratuito e se encontra no seguinte link:");
			mensagem.append(NOVALINHA);
			mensagem.append(instalacaoDeSoftware.getLink());
			mensagem.append(NOVALINHA);
		}
		if(!instalacaoDeSoftware.getNomeSoftware().equals("")){
			mensagem.append("O nome do software que foi pedido é ");
			mensagem.append(instalacaoDeSoftware.getNomeSoftware());
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Os contatos do solicitante são:");
		mensagem.append(NOVALINHA);
		mensagem.append("e-mail: " + instalacaoDeSoftware.getUsuario().getEmail());
		mensagem.append(NOVALINHA);
		if (!instalacaoDeSoftware.getUsuario().getRamal().equals("")) {
			mensagem.append("Ramal: ");
			mensagem.append(instalacaoDeSoftware.getUsuario().getRamal());
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Mensagem enviada:");
		mensagem.append(instalacaoDeSoftware.getDataSemanal());

		
	}

	public void escreveCartaConta() {
		mensagem.append("O(A) Sr(a) ");
		mensagem.append(servicoConta.getUsuario().getNome());
		mensagem.append(" solicitou o seguinte serviço: ");
		mensagem.append(NOVALINHA);
		if (servicoConta.getTipo().equalsIgnoreCase("ABERTURA")) {
			mensagem.append("Abertura de conta.");
			mensagem.append(NOVALINHA);
			mensagem.append("O motivo do seu pedido é:");
			mensagem.append(NOVALINHA);
			mensagem.append(servicoConta.getJustificativa());
			mensagem.append(NOVALINHA);
		} else {
			mensagem.append("Manutenção de conta.");
			mensagem.append(NOVALINHA);
			mensagem.append("O motivo do seu pedido é:");
			mensagem.append(NOVALINHA);
			mensagem.append(servicoConta.getJustificativa());
			mensagem.append(NOVALINHA);
			mensagem
					.append("O usuário deu como sugestão de conta o seginte login:");
			mensagem.append(NOVALINHA);
			mensagem.append(servicoConta.getConta());
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Os contatos do solicitante são:");
		mensagem.append(NOVALINHA);
		mensagem.append("e-mail: " + servicoConta.getUsuario().getEmail());
		mensagem.append(NOVALINHA);
		if (!servicoConta.getUsuario().getRamal().equals("")) {
			mensagem.append("Ramal: ");
			mensagem.append(servicoConta.getUsuario().getRamal());
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Mensagem enviada:");
		mensagem.append(servicoConta.getDataSemanal());
	
	}
	
	
	
	public void escreveCartaManutencao() {
		mensagem.append("O(A) Sr(a) ");
		mensagem.append(manutencao.getUsuario().getNome());
		mensagem.append(" solicitou manutenção na ");
		if(manutencao.getTipo().equalsIgnoreCase("REDE")){
			mensagem.append("Rede");
			mensagem.append(NOVALINHA);
			mensagem.append("Descrição do problema:");
			mensagem.append(NOVALINHA);
			mensagem.append(manutencao.getDescricao());
		}else{
			mensagem.append("Máquina");
			mensagem.append(NOVALINHA);
			mensagem.append("Descrição do problema:");
			mensagem.append(NOVALINHA);
			mensagem.append(manutencao.getDescricao());
		}
		mensagem.append(NOVALINHA);
		mensagem.append("Os contatos do solicitante são:");
		mensagem.append(NOVALINHA);
		mensagem.append("e-mail: " + manutencao.getUsuario().getEmail());
		mensagem.append(NOVALINHA);
		if (!manutencao.getUsuario().getRamal().equals("")) {
			mensagem.append("Ramal: ");
			mensagem.append(manutencao.getUsuario().getRamal());
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Mensagem enviada:");
		mensagem.append(manutencao.getDataSemanal());
	
	}
	

	public StringBuffer getMensagem() {
		return mensagem;
	}

	public void setMensagem(StringBuffer mensagem) {
		this.mensagem = mensagem;
	}

	

	public InstalacaoSoftware getInstalacaoDeSoftware() {
		return instalacaoDeSoftware;
	}

	public void setInstalacaoDeSoftware(InstalacaoSoftware instSoftware) {
		this.instalacaoDeSoftware = instSoftware;
	}

	public ServicoConta getServicoConta() {
		return servicoConta;
	}

	public void setServicoConta(ServicoConta servicoConta) {
		this.servicoConta = servicoConta;
	}
	public String toString(){
		return mensagem.toString();
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	
}
