package formulario.salaAula.logic;

import java.io.File;

import formulario.logic.Formulario;
import formulario.logic.HorarioSemanal;

/**
 * Classe que escreve o documento enviado por e-mail na solicitação de sala de
 * aula
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 */
public class FormularioSala extends Formulario {
	private final String NOVALINHA = System.getProperty("line.separator");
	
	private StringBuffer mensagem;

	private HorarioSemanal horario1 = new HorarioSemanal();

	private HorarioSemanal horario2 = new HorarioSemanal();

	private HorarioSemanal horario3 = new HorarioSemanal();

	private Professor professor = new Professor();

	private Disciplina disciplina = new Disciplina();

	private String equipamentosFrequentes;

	private String equipamentosIndispensaveis;

	private String equipamentosNaoDisponiveis;

	private String equipamentosNaoUtilizados;

	private String disciplinaPodeSerNoturno;

	private String justificativaNoturna;

	private String disciplinaPodeSerNoSabado;

	private String turnoParaSerSabado;

	private String justificativaSabado;

	private String contribuicao;

	private String dataDeCriacao;
	
	private Long codigoSoAula;
	
	/**
	 * @return the codigoSoAula
	 */
	public Long getCodigoSoAula() {
		return codigoSoAula;
	}

	/**
	 * @param codigo the codigoSoAula to set
	 */
	public void setCodigoSoAula(Long codigo) {
		this.codigoSoAula = codigo;
	}

	/**
	 * auto generated
	 * 
	 * @es_generated
	 */
	public FormularioSala() {
		mensagem = new StringBuffer();
		// dataDeCriacao = getDataAtual();
	}

	public FormularioSala(String nomeMinistrante, String disciplina,
			String periodo, String curso, String opcaoPeriodicidade,
			HorarioSemanal horario1, HorarioSemanal horario2,
			HorarioSemanal horario3, String totalAlunos,
			String emailMinistrante, String ramalProfessor, String salaAtual,
			String equipamentosFrequentes, String equipamentosIndispensaveis,
			String linkMaterial, String equipamentosNaoDisponiveis,
			String equipamentosNaoUtilizados, String disciplinaNoturna,
			String justificativaNoturna, String disciplinaSabado,
			String turnoSabado, String justificativaSabado,
			String contribuicao, File savedFile) {

		this.disciplina.setDisciplina(disciplina);
		this.disciplina.setCurso(curso);
		this.disciplina.setLinkMaterial(linkMaterial);
		this.disciplina.setMaterial(savedFile);
		this.disciplina.setPeriodicidade(opcaoPeriodicidade);
		this.disciplina.setPeriodo(periodo);
		this.disciplina.setSalaAtual(salaAtual);
		this.disciplina.setTotalAlunos(totalAlunos);
		
		this.professor.setEmail(emailMinistrante);
		this.professor.setNome(nomeMinistrante);
		this.professor.setRamal(Integer.parseInt(ramalProfessor));
		
		this.horario1 = horario1;
		this.horario2 = horario2;
		this.horario3 = horario3;
		
		//chaves estrangeiras de horario semanal
		
		this.equipamentosFrequentes = equipamentosFrequentes;
		this.equipamentosIndispensaveis = equipamentosIndispensaveis;
		this.equipamentosNaoDisponiveis = equipamentosNaoDisponiveis;
		this.equipamentosNaoUtilizados = equipamentosNaoUtilizados;
		this.disciplinaPodeSerNoturno = disciplinaNoturna;
		this.justificativaNoturna = justificativaNoturna;
		this.disciplinaPodeSerNoSabado = disciplinaSabado;
		this.turnoParaSerSabado = turnoSabado;
		this.justificativaSabado = justificativaSabado;
		this.contribuicao = contribuicao;
		this.dataDeCriacao = getDataAtual();
		mensagem = new StringBuffer();

	}

	public void escreveCarta() {

		mensagem.append("        Solicitação de Sala de Aula");
		mensagem.append(NOVALINHA);
		mensagem.append(NOVALINHA);
		mensagem.append("Foi solicitado pelo(a) professor(a) ");
		mensagem.append((new StringBuilder()).append(professor.getNome())
				.append(", ").toString());
		mensagem
				.append("uma sala de aula no bloco REENGE para que este lecione a disciplina ");
		mensagem.append(disciplina.getDisciplina());
		mensagem.append(" no periodo ");
		mensagem.append(disciplina.getPeriodo());
		mensagem.append(". Esta pertence ao(s) curso(s) ");
		mensagem.append(disciplina.getCurso());
		mensagem.append(" e tem periodicidade ");
		mensagem.append(disciplina.getPeriodicidade());

		mensagem.append(". É necessária uma sala de aula para os horários: ");
		mensagem.append(getHorario1());
		if (!getHorario2().toString().equals(" de  até ")) {
			mensagem.append(" | ");
			mensagem.append(getHorario2());
		}
		if (!getHorario3().toString().equals(" de  até ")) {
			mensagem.append(" | ");
			mensagem.append(getHorario3());
		}
		mensagem.append(" e que comportem ");
		mensagem.append(disciplina.getTotalAlunos());
		mensagem.append(" alunos. A disciplina é lecionada na sala ");
		mensagem.append(disciplina.getSalaAtual());
		mensagem.append(".");

		// inicio dos campos nao obrigatorios
		if (!equipamentosFrequentes.equals("")) {
			mensagem.append(NOVALINHA);
			mensagem
					.append("Os equipamentos informado que são utilizados em sala de aula são:");
			mensagem.append(NOVALINHA);
			mensagem.append(equipamentosFrequentes);
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (!equipamentosIndispensaveis.equals("")) {
			mensagem.append(NOVALINHA);
			mensagem.append("Os equipamentos indispensáveis são: ");
			mensagem.append(NOVALINHA);
			mensagem.append(equipamentosIndispensaveis);
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (!disciplina.getLinkMaterial().equals("")) {
			mensagem.append("O professor(a) ");
			mensagem.append(professor.getNome());
			mensagem
					.append(" deixou disponível seu material eletrônico no seguinte endereço: ");
			mensagem.append(NOVALINHA);
			mensagem.append(disciplina.getLinkMaterial());
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}

		if (!equipamentosNaoDisponiveis.equals("")) {
			mensagem.append("O professor(a) ");
			mensagem.append(professor.getNome());
			mensagem
					.append(" reclama por não dispor dos seguintes equipamentos:");
			mensagem.append(NOVALINHA);
			mensagem.append(equipamentosNaoDisponiveis);
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (!equipamentosNaoUtilizados.equals("")) {
			mensagem.append("O professor(a) ");
			mensagem.append(professor.getNome());
			mensagem
					.append(" afirma que existem equipamentos não necessários para as aulas. Eles estão a seguir: ");
			mensagem.append(NOVALINHA);
			mensagem.append(equipamentosNaoUtilizados);
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (disciplinaPodeSerNoturno.equals("SIM")) {
			mensagem.append("O professor(a) ");
			mensagem.append(professor.getNome());
			mensagem
					.append(" afirma que sua disciplina poder ser lecionada em horários noturnos.");
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		} else if (disciplinaPodeSerNoturno.equals("NAO")) {
			mensagem.append("O professor(a) ");
			mensagem.append(professor.getNome());
			mensagem
					.append(" afirma que sua disciplina não poder ser lecionada em horários noturnos pelo(s) seguinte(s) motivo(s):");
			mensagem.append(NOVALINHA);
			if (!justificativaNoturna.equals("")) {
				mensagem.append(justificativaNoturna);
			} else {
				mensagem.append("O professor(a) não justificou!");
			}
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (getDisciplinaPodeSerNoSabado().equals("SIM")) {
			mensagem
					.append("O professor(a) afirma que a disciplina pode ser ensinada no dia de sábado no turno ");
			mensagem.append(getTurnoParaSerSabado());
			mensagem.append(".");
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		} else if (getDisciplinaPodeSerNoSabado().equals("NAO")) {
			mensagem
					.append("O professor(a) afirma que a disciplina não pode ser ensinada no dia de sábado pelo(s) seguinte(s) motivo(s):");
			mensagem.append(NOVALINHA);
			if (!getJustificativaSabado().equals("")) {
				mensagem.append(getJustificativaSabado());
			} else {
				mensagem.append("O professor não justificou!");
			}

			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		if (contribuicao.equals("")) {
			mensagem
					.append("O professor(a) não deixou nenhuma contribuição para a melhoria do funcionamento do REENGE.");
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		} else {
			mensagem
					.append("Como contribuição para a melhoria no funcionamento do REENGE o professor deixou a(s) seguinte(s) sugestão(ões):");
			mensagem.append(NOVALINHA);
			mensagem.append(contribuicao);
			mensagem.append(NOVALINHA);
			mensagem.append(NOVALINHA);
		}
		mensagem.append("Contatos do solicitante:");
		mensagem.append(NOVALINHA);
		mensagem.append("e-mail: ");
		mensagem.append(professor.getEmail());
		mensagem.append(NOVALINHA);
		mensagem.append("ramal: ");
		mensagem.append(professor.getRamal());
		mensagem.append(NOVALINHA);
		mensagem.append(NOVALINHA);
		mensagem.append("Central de Atendimento Reenge");
		mensagem.append(NOVALINHA);
		mensagem.append(NOVALINHA);
		mensagem.append("Mensagem enviada:");
		mensagem.append(getDataDeCriacao());
	}

	public String toString() {
		return mensagem.toString();
	}

	/**
	 * @return the contribuicao
	 */
	public String getContribuicao() {
		return contribuicao;
	}

	/**
	 * @param contribuicao
	 *            the contribuicao to set
	 */
	public void setContribuicao(String contribuicao) {
		this.contribuicao = contribuicao;
	}

	

	/**
	 * @return the equipamentosFrequentes
	 */
	public String getEquipamentosFrequentes() {
		return equipamentosFrequentes;
	}

	/**
	 * @param equipamentosFrequentes
	 *            the equipamentosFrequentes to set
	 */
	public void setEquipamentosFrequentes(String equipamentosFrequentes) {
		this.equipamentosFrequentes = equipamentosFrequentes;
	}

	/**
	 * @return the equipamentosIndispensaveis
	 */
	public String getEquipamentosIndispensaveis() {
		return equipamentosIndispensaveis;
	}

	/**
	 * @param equipamentosIndispensaveis
	 *            the equipamentosIndispensaveis to set
	 */
	public void setEquipamentosIndispensaveis(String equipamentosIndispensaveis) {
		this.equipamentosIndispensaveis = equipamentosIndispensaveis;
	}

	/**
	 * @return the equipamentosNaoDisponiveis
	 */
	public String getEquipamentosNaoDisponiveis() {
		return equipamentosNaoDisponiveis;
	}

	/**
	 * @param equipamentosNaoDisponiveis
	 *            the equipamentosNaoDisponiveis to set
	 */
	public void setEquipamentosNaoDisponiveis(String equipamentosNaoDisponiveis) {
		this.equipamentosNaoDisponiveis = equipamentosNaoDisponiveis;
	}

	/**
	 * @return the equipamentosNaoUtilizados
	 */
	public String getEquipamentosNaoUtilizados() {
		return equipamentosNaoUtilizados;
	}

	/**
	 * @param equipamentosNaoUtilizados
	 *            the equipamentosNaoUtilizados to set
	 */
	public void setEquipamentosNaoUtilizados(String equipamentosNaoUtilizados) {
		this.equipamentosNaoUtilizados = equipamentosNaoUtilizados;
	}

	/**
	 * @return the horario1
	 */
	public HorarioSemanal getHorario1() {
		return horario1;
	}

	/**
	 * @param horario
	 *            the horario1 to set
	 */
	public void setHorario1(HorarioSemanal horario) {
		this.horario1 = horario;
	}

	/**
	 * @return the horario2
	 */
	public HorarioSemanal getHorario2() {
		return horario2;
	}

	/**
	 * @param horario
	 *            the horario2 to set
	 */
	public void setHorario2(HorarioSemanal horario) {
		this.horario2 = horario;
	}

	/**
	 * @return the horario3
	 */
	public HorarioSemanal getHorario3() {
		return horario3;
	}

	/**
	 * @param horario
	 *            the horario3 to set
	 */
	public void setHorario3(HorarioSemanal horario) {
		this.horario3 = horario;
	}

	/**
	 * @return the justificativaNoturna
	 */
	public String getJustificativaNoturna() {
		return justificativaNoturna;
	}

	/**
	 * @param justificativaNoturna
	 *            the justificativaNoturna to set
	 */
	public void setJustificativaNoturna(String justificativaNoturna) {
		this.justificativaNoturna = justificativaNoturna;
	}

	/**
	 * @return the justificativaSabado
	 */
	public String getJustificativaSabado() {
		return justificativaSabado;
	}

	/**
	 * @param justificativaSabado
	 *            the justificativaSabado to set
	 */
	public void setJustificativaSabado(String justificativaSabado) {
		this.justificativaSabado = justificativaSabado;
	}

	
	/**
	 * Determina se a disciplina pode ser realizado aos sábados.
	 * 
	 * @return true se puder ser aos sábados e false e caso contrário.
	 */
	public boolean isDisciplinaNoturna() {
		boolean infoDisciplinaNoturna = true;
		if (disciplinaPodeSerNoturno == null) {
			infoDisciplinaNoturna = false;
		} else if (disciplinaPodeSerNoturno.equalsIgnoreCase("NAO")) {
			infoDisciplinaNoturna = false;
		}
		return infoDisciplinaNoturna;
	}

	/**
	 * @return Returns infomação sobra a disciplina poder ou não ser lecionada
	 *         aos sábados.
	 */
	public boolean isDisciplinaSabado() {
		boolean infoDisciplinaSabado = true;
		if (disciplinaPodeSerNoSabado == null) {
			infoDisciplinaSabado = false;
		} else if (disciplinaPodeSerNoSabado.equalsIgnoreCase("NAO")) {
			infoDisciplinaSabado = false;
		}
		return infoDisciplinaSabado;
	}

	/**
	 * @return the dataDeCriacao
	 */
	public String getDataDeCriacao() {
		return dataDeCriacao;
	}

	/**
	 * @param dataCriacao
	 *            the dataDeCriacao to set
	 */
	public void setDataDeCriacao(String dataCriacao) {
		this.dataDeCriacao = dataCriacao;
	}

	/**
	 * @return the disciplinaPodeSerNoSabado
	 */
	public String getDisciplinaPodeSerNoSabado() {
		return disciplinaPodeSerNoSabado;
	}

	/**
	 * @param disciplinaSabado
	 *            the disciplinaPodeSerNoSabado to set
	 */
	public void setDisciplinaPodeSerNoSabado(String disciplinaSabado) {
		this.disciplinaPodeSerNoSabado = disciplinaSabado;
	}

	/**
	 * @return the disciplinaPodeSerNoturno
	 */
	public String getDisciplinaPodeSerNoturno() {
		return disciplinaPodeSerNoturno;
	}

	/**
	 * @param disciplinaNoturno
	 *            the disciplinaPodeSerNoturno to set
	 */
	public void setDisciplinaPodeSerNoturno(String disciplinaNoturno) {
		this.disciplinaPodeSerNoturno = disciplinaNoturno;
	}

	/**
	 * @return the turnoParaSerSabado
	 */
	public String getTurnoParaSerSabado() {
		return turnoParaSerSabado;
	}

	/**
	 * @param turnoSabado
	 *            the turnoParaSerSabado to set
	 */
	public void setTurnoParaSerSabado(String turnoSabado) {
		this.turnoParaSerSabado = turnoSabado;
	}

	/**
	 * @return the disciplina
	 */
	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}