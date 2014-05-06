/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package formulario.servico.logic;

public class Manutencao extends Servico{
	private String tipo;
	private String descricao;
	
	public Manutencao() {
		// TODO Auto-generated constructor stub
	}
	public Manutencao(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao =  descricao;
		this.setDataSemanal(this.getDataAtual());
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String desc) {
		this.descricao = desc;
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
	public void setTipo(String UmTipo) {
		this.tipo = UmTipo;
	}
}
