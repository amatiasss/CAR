package formulario.laboratorio.logic;

public class Curso {
	private String duracaoCurso;

	private String cursoPertence;

	private String numeroAlunos;
	
	private String nomeCurso;
	private String cursoPago;

	private String softwareNecessario;

	private String publicoAlvo;
	private String finalidade;
	
	private Long codigoCurso;
	
	public Curso(){
		
	}
	/**
	 * Determina se o curso será pago.
	 * 
	 * @return true se for pago e false e caso contrário.
	 */
	public boolean isPago() {
		boolean infoPago = true;
		if (cursoPago == null) {
			infoPago = false;
		} else if (cursoPago.equalsIgnoreCase("NAO")) {
			infoPago = false;
		}
		return infoPago;
	}

	/**
	 * @return Retorna o pago.
	 */
	public String getExplicacaoPago() {
		String infoPago = "";
		if (cursoPago == null) {
			infoPago = "Nao foi declarado se o curso será pago";
		} else if (cursoPago.equalsIgnoreCase("SIM")) {
			infoPago = "O curso será pago";
		} else {
			infoPago = "O curso não será pago";
		}
		return infoPago;
	}
	/**
	 * @return Retorna o pago.
	 */
	public String getCursoPago() {
		return cursoPago;
	}
	/**
	 * @param pago
	 *            o valor a ser modificado.
	 */
	public void setCursoPago(String pago) {
		this.cursoPago = pago;
	}

	/**
	 * @return Retorna o publicoAlvo.
	 */
	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	/**
	 * @param publicoAlvo
	 *            o publicoAlvo a ser modificado.
	 */
	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	/**
	 * @return Retorna o softwareNecessario.
	 */
	public String getSoftwareNecessario() {
		return softwareNecessario;
	}

	/**
	 * @param softwareNecessario
	 *            o softwareNecessario a ser modificado.
	 */
	public void setSoftwareNecessario(String softwareNecessario) {
		this.softwareNecessario = softwareNecessario;
	}
	/**
	 * @return Retorna o numeroAlunos.
	 */
	public String getNumeroAlunos() {
		return numeroAlunos;
	}

	/**
	 * @param numeroAlunos
	 *            o numeroAlunos a ser modificado.
	 */
	public void setNumeroAlunos(String numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}

	/**
	 * @return Retorna o nomeCurso.
	 */
	public String getNomeCurso() {
		return nomeCurso;
	}

	/**
	 * @param nomeCurso
	 *            o nomeCurso a ser modificado.
	 */
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	/**
	 * @return Retorna o finalidade.
	 */
	public String getFinalidade() {
		return finalidade;
	}

	/**
	 * @param finalidade
	 *            o finalidade a ser modificado.
	 */
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	/**
	 * @return Retorna o cursosPertence.
	 */
	public String getCursoPertence() {
		return cursoPertence;
	}

	/**
	 * @param cursosPertence
	 *            o cursosPertence a ser modificado.
	 */
	public void setCursoPertence(String cursosPertence) {
		this.cursoPertence = cursosPertence;
	}

	/**
	 * @return Retorna o duracaoCurso.
	 */
	public String getDuracaoCurso() {
		return duracaoCurso;
	}

	/**
	 * @param duracaoCurso
	 *            o duracaoCurso a ser modificado.
	 */
	public void setDuracaoCurso(String duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}
	/**
	 * @return o codigoCurso
	 */
	public Long getCodigoCurso() {
		return codigoCurso;
	}
	/**
	 * @param codigoCurso o codigoCurso a ser modificado.
	 */
	public void setCodigoCurso(Long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	

}
