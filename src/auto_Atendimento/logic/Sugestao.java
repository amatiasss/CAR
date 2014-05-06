package auto_Atendimento.logic;

import usuario.logic.Usuario;

/**
 * <b>Sugestao</b><br>
 * <br>
 * 
 * Classe que representa uma sugestão feita por um usuário
 * 
 * @author Rodrigo Lopes, Hamon Barros, Rômulo Calado
 * 
 */
public class Sugestao extends AutoAtendimento {

	private final String NOVALINHA = System.getProperty("line.separator");

	// private int codigoSugestao;

	private String sugestao;

	public Sugestao() {
	}

	public Sugestao(String nome, String email, String ramal, String sugestao) {
		super.usuario = new Usuario(nome, email, ramal);
		this.sugestao = sugestao;
		this.setDataSemanal(this.getDataAtual());
	}

	/**
	 * @return Returns the usuario.
	 */
	public Usuario getUsuario() {
		return super.getUsuario();
	}

	/**
	 * @param usuario
	 *            The usuario to set.
	 */
	public void setUsuario(Usuario usuario) {
		super.setUsuario(usuario);
	}

	/**
	 * @return the sugestao
	 */
	public String getSugestao() {
		return sugestao;
	}

	/**
	 * @param sugestao
	 *            the sugestao to set
	 */
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public String getRelatorio() {
		String ramal = "";
		String retorno = "";
		try {
			if (!usuario.getRamalExistente().equals("")) {
				ramal = ", " + usuario.getRamalExistente();
			}
			retorno = "O(A) Sr(a) " + usuario.getNome() + ", com email "
					+ usuario.getEmail() + ramal
					+ ", deixou a seguinte sugestão:" + NOVALINHA + sugestao
					+ NOVALINHA + NOVALINHA + "Sugestão realizada em "
					+ getDataSemanal().toString();
		} catch (NullPointerException e) {
		}
		return retorno;
	}

}
