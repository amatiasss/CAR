package auto_Atendimento.logic;

import usuario.logic.Usuario;

/**
 * Classe para persistencia do formulario de Reclamacao
 * 
 * @author Hamon Barros, Rodrigo Lopes, Romulo Calado
 */
public class Reclamacao extends AutoAtendimento {
	private final String NOVALINHA = System.getProperty("line.separator");

	private String tipoReclamacao;

	private String descricao;

	/**
	 * Construtor Default
	 */
	public Reclamacao() {
	}

	/**
	 * Contrutor
	 * 
	 * @param nome
	 *            Nome do reclamante
	 * @param email
	 *            Email do reclamante
	 * @param ramal
	 *            Ramal do reclamante
	 * @param tipoReclamacao
	 *            O tipo da reclamacao
	 * @param descricao
	 *            A descricao do tipo da reclamacao
	 */
	public Reclamacao(String nome, String email, String ramal,
			String tipoReclamacao, String descricao) {
		super.usuario = new Usuario(nome, email, ramal);
		this.tipoReclamacao = tipoReclamacao;
		this.descricao = descricao;
		this.setDataSemanal(this.getDataAtual());
	}

	/**
	 * Devolve o usuario
	 * 
	 * @return O usuario.
	 */
	public Usuario getUsuario() {
		return super.getUsuario();
	}

	/**
	 * Altera o usuario
	 * 
	 * @param usuario
	 *            Novo usuario.
	 */
	public void setUsuario(Usuario usuario) {
		super.setUsuario(usuario);
	}

	/**
	 * Devolve a descricao do tipo da reclamacao
	 * 
	 * @return A descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Altera a descricao do tipo da reclamacao
	 * 
	 * @param descricao
	 *            A nova descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Devolve o tipo da recamacao
	 * 
	 * @return O tipo
	 */
	public String getTipo() {
		return tipoReclamacao;
	}

	/**
	 * Altera o tipo da reclamacao
	 * 
	 * @param tipo
	 *            O novo tipo
	 */
	public void setTipo(String tipo) {
		this.tipoReclamacao = tipo;
	}

	/**
	 * Retorna a mensagem que sera mandada quando for feita uma reclamacao
	 * 
	 * @return A mensagem
	 */
	public String getRelatorio() {
		String ramal = "";
		String retorno = "";
		try {
			if (!usuario.getRamalExistente().equals("")) {
				ramal = " e " + usuario.getRamalExistente();
			}
			retorno = "O(A) Sr(a) " + usuario.getNome() + ", com email "
					+ usuario.getEmail() + ramal
					+ ", fez uma reclamação a respeito de ";
			if (tipoReclamacao.equalsIgnoreCase("Equipamento")) {
				retorno += "equipamento";
			} else if (tipoReclamacao.equalsIgnoreCase("PESSOAL_DE_APOIO")) {
				retorno += "pessoal de apoio";

			} else if (tipoReclamacao.equalsIgnoreCase("REDE")) {
				retorno += "problema de rede";

			} else {
				retorno += "problemas em geral";
			}

			retorno += ", " + NOVALINHA + "deixando a seguinte descrição:"
					+ NOVALINHA + descricao + NOVALINHA + NOVALINHA
					+ "Reclamação realizada em " + getDataSemanal().toString();
		} catch (NullPointerException e) {
		}
		return retorno;
	}

}
