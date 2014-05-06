/*
 * Created on 12/10/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package usuario.logic;

public class Usuario {
	
	private Long codigoUsuario;
	private String nome;
	private String email;
	private String ramal;
	
	public Usuario() {
	}
	
	public Usuario(String nomeUsuario, String emailUsuario, String ramalUsuario){
		this.nome = nomeUsuario;
		this.email = emailUsuario;
		this.ramal = ramalUsuario;
		
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
	
	/**
	 * Define uma string se o ramal tiver algum valor
	 * @return texto contendo o ramal
	 */
	public String getRamalExistente(){
		String retorno = "";
		if (ramal != null){
			retorno = "ramal " + getRamal();
		}
		return retorno;
	}
	

}
