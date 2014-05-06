/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package auto_Atendimento.logic;

public class Outro extends AutoAtendimento {
	private String comentario;
	
	
	public Outro() {


	}


	public Outro(String comentario2) {
		this.comentario = comentario2;
		this.setDataSemanal(this.getDataAtual());
	}


	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}


	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
