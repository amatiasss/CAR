package formulario.laboratorio.logic;

public class Ministrante {
	
	private Long codigoMinistrante;
	private String nome;
	private String email;
	
	public Ministrante(){
		
	}

	public Ministrante(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emailMinistrante the email to set
	 */
	public void setEmail(String emailMinistrante) {
		this.email = emailMinistrante;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nomeMinistrante the nome to set
	 */
	public void setNome(String nomeMinistrante) {
		this.nome = nomeMinistrante;
	}



	/**
	 * @return Returns the codigoMinistrante.
	 */
	public Long getCodigoMinistrante() {
		return codigoMinistrante;
	}

	/**
	 * @param codigoMinistrante The codigoMinistrante to set.
	 */
	public void setCodigoMinistrante(Long codigoMinistrante) {
		this.codigoMinistrante = codigoMinistrante;
	}

}
