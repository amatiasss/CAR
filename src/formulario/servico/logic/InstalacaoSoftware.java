/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package formulario.servico.logic;

public class InstalacaoSoftware extends Servico{
	private String nomeSoftware;
	private String link;
	private String localInstalacao;
	public InstalacaoSoftware() {
	
	}
	public InstalacaoSoftware( String link, String nomeSoftware, String localInst) {
		this.nomeSoftware = nomeSoftware;
		this.link = link;
		this.localInstalacao = localInst;
		this.setDataSemanal(this.getDataAtual());
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the nomeSoftware
	 */
	public String getNomeSoftware() {
		return nomeSoftware;
	}
	/**
	 * @param nomeSoftware the nomeSoftware to set
	 */
	public void setNomeSoftware(String nomeSoftware) {
		this.nomeSoftware = nomeSoftware;
	}
	/**
	 * @return the localInstalacao
	 */
	public String getLocalInstalacao() {
		return localInstalacao;
	}
	/**
	 * @param localInstalacao the localInstalacao to set
	 */
	public void setLocalInstalacao(String localInst) {
		this.localInstalacao = localInst;
	}
	
}
