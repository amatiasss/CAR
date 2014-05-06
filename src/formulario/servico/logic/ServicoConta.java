/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package formulario.servico.logic;

public class ServicoConta extends Servico{
	private String tipo;

	private String justificativa;

	private String conta;

	public ServicoConta() {
		
	}
	public ServicoConta(String tipo, String justificativa, String conta) {
		this.tipo = tipo;
		this.justificativa = justificativa;
		this.conta = conta;
		this.setDataSemanal(this.getDataAtual());
	}

	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}

	/**
	 * @return the justificativa
	 */
	public String getJustificativa() {
		return justificativa;
	}

	/**
	 * @param justificativa the justificativa to set
	 */
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
