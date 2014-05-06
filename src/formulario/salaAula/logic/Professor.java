package formulario.salaAula.logic;

public class Professor {
	
	private Long codigoProfessor;
	private int ramal;
	private String nome;
	private String email;

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Professor() {
		super();
	}
	/**
	 * @return the ramal
	 */
	public int getRamal() {
		return ramal;
	}
	/**
	 * @param ramalProfessor the ramal to set
	 */
	public void setRamal(int ramalProfessor) {
		this.ramal = ramalProfessor;
	}
	
	
	/**
	 * @param codigoProfessor The codigoProfessor to set.
	 */
	public void setCodigoProfessor(Long codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
	/**
	 * @return Returns the codigoProfessor.
	 */
	public Long getCodigoProfessor() {
		return codigoProfessor;
	}
}
