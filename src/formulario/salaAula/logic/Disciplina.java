package formulario.salaAula.logic;

import java.io.File;

public class Disciplina {
	private  String disciplina;
	private  String curso;
	private  String periodicidade;
	private  String totalAlunos;
	private  String salaAtual;
	private  String linkMaterial;
	private  String periodo;
	private File material;
	private Long codigoProfessor_FK;
	private Long codigoSoSalaAula_FK;
	/** auto generated
	 * @es_generated
	 */
	private Long codigoDisciplina;
	
	
	public Disciplina() {
	
	}


	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}


	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}


	/**
	 * @return the disciplina
	 */
	public String getDisciplina() {
		return disciplina;
	}


	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}


	/**
	 * @return the linkMaterial
	 */
	public String getLinkMaterial() {
		return linkMaterial;
	}


	/**
	 * @param linkMaterial the linkMaterial to set
	 */
	public void setLinkMaterial(String linkMaterial) {
		this.linkMaterial = linkMaterial;
	}


	/**
	 * @return the material
	 */
	public File getMaterial() {
		return material;
	}


	/**
	 * @param material the material to set
	 */
	public void setMaterial(File material) {
		this.material = material;
	}


	/**
	 * @return the periodicidade
	 */
	public String getPeriodicidade() {
		return periodicidade;
	}


	/**
	 * @param periodicidade the periodicidade to set
	 */
	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}


	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}


	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	/**
	 * @return the salaAtual
	 */
	public String getSalaAtual() {
		return salaAtual;
	}


	/**
	 * @param salaAtual the salaAtual to set
	 */
	public void setSalaAtual(String salaAtual) {
		this.salaAtual = salaAtual;
	}


	/**
	 * @return the totalAlunos
	 */
	public String getTotalAlunos() {
		return totalAlunos;
	}


	/**
	 * @param totalAlunos the totalAlunos to set
	 */
	public void setTotalAlunos(String totalAlunos) {
		this.totalAlunos = totalAlunos;
	}


	/**
	 * @return the codigoDisciplina
	 */
	public Long getCodigoDisciplina() {
		return codigoDisciplina;
	}


	/**
	 * @param codigoDisciplina the codigoDisciplina to set
	 */
	public void setCodigoDisciplina(Long codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}


	/**
	 * @return the codigoProfessor_FK
	 */
	public Long getCodigoProfessor_FK() {
		return codigoProfessor_FK;
	}


	/**
	 * @param codigoProfessor the codigoProfessor_FK to set
	 */
	public void setCodigoProfessor_FK(Long codigoProfessor) {
		this.codigoProfessor_FK = codigoProfessor;
	}


	/**
	 * @return the codigoSoSalaAula_FK
	 */
	public Long getCodigoSoSalaAula_FK() {
		return codigoSoSalaAula_FK;
	}


	/**
	 * @param codigoAula the codigoSoSalaAula_FK to set
	 */
	public void setCodigoSoSalaAula_FK(Long codigoAula) {
		this.codigoSoSalaAula_FK = codigoAula;
	}


	
}
