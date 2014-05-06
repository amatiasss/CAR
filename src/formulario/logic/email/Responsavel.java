/*
 * Created on 02/11/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package formulario.logic.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Responsavel{
	private String nome;
	private String email;
	//private Set<Responsavel> responsaveis;
	private List<Responsavel> responsaveis;
	private TreeMap<String,String> setorResponsaveis;
	public Responsavel (String nome, String email){
		this.nome = nome;
		this.email = email;
	}
	public Responsavel(Map<String,String>setor){
		this.setorResponsaveis = (TreeMap<String, String>) setor;
		responsaveis = new ArrayList<Responsavel>();
		//responsaveis = new TreeSet<Responsavel>();
	}
	public Responsavel() {
	
	}
	@SuppressWarnings("unchecked")
	public List<Responsavel> getResponsaveis(){
		TreeMap<String, String> mapaClone = (TreeMap<String, String>) setorResponsaveis.clone();
		while(!mapaClone.isEmpty()){
			String nome1 = mapaClone.firstKey();
			String email1 = mapaClone.get(nome1);
			Responsavel resp = new Responsavel(nome1, email1);
			responsaveis.add(resp);
			mapaClone.remove(nome1);
		}
		
		return responsaveis;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @param responsaveis the responsaveis to set
	 */
	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	

}
