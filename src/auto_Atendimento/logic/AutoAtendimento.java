/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package auto_Atendimento.logic;

import usuario.logic.Usuario;
import formulario.logic.Formulario;

public class AutoAtendimento extends Formulario{
	private Long numeroDocumento;
	private String dataSemanal;
	protected Usuario usuario;
	
	/**
	 * @return Returns the usuario.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario The usuario to set.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public AutoAtendimento() {
	}
	/**
	 * @return the dataSemanal
	 */
	public String getDataSemanal() {
		return dataSemanal;
	}
	/**
	 * @param dataSemanal the dataSemanal to set
	 */
	public void setDataSemanal(String data) {
		this.dataSemanal = data;
	}
	/**
	 * @return the numeroDocumento
	 */
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(Long numDoc) {
		this.numeroDocumento = numDoc;
	}
	
	
}
