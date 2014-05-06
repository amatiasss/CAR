/**
 * 
 */
package formulario.laboratorio.logic;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import formulario.logic.Formulario;
import formulario.logic.HorarioSemanal;

/**
 * Classe que escreve o documento enviado por e-mail na solicitação de
 * Laboratório
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 */
public class FormularioLaboratorio extends Formulario {

	private final String NOVALINHA = System.getProperty("line.separator");

	private HttpServletRequest request;

	private HorarioSemanal horario1;

	private HorarioSemanal horario2;

	private HorarioSemanal horario3;

	private Long codigoSolab;

	private int numeroMaquinas;

	private Ministrante ministrante = new Ministrante();

	private Curso curso = new Curso();

	private String cursoPodeSerNoturno;

	private String justificativaNoturno = "";

	private String cursoPodeSerNoSabado;

	private String justificativaSabado = "";

	private String turnoSabado;

	private String contribuicao;

	private String dataDeCriacao;

	/**
	 * Cria um novo formulario de laboratório.
	 */
	public FormularioLaboratorio() {
		super();
	}

	/**
	 * Cria um novo formulario de laboratório.
	 * 
	 * @param request
	 *            Request recebido de um servlet.
	 */
	public FormularioLaboratorio(HttpServletRequest request) {
		super();
		dataDeCriacao = getDataAtual();
		this.request = request;
	}

	/**
	 * @return Returns the request.
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * Recebe uma enumaração de campos um formulário de laboratório e extrai os
	 * dados
	 */
	public void ExtrairDados(Enumeration enumeration) {
		horario1 = new HorarioSemanal();
		horario2 = new HorarioSemanal();
		horario3 = new HorarioSemanal();
		// Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String campo = enumeration.nextElement().toString();
			if (campo.equals("nomeCurso")) {
				curso.setNomeCurso(request.getParameter(campo));
			} else if (campo.equals("nomeMinistrante")) {
				ministrante.setNome(request.getParameter(campo));
			} else if (campo.equals("numeroMaquinas")) {
				numeroMaquinas = Integer.parseInt(request.getParameter(campo));
			} else if (campo.equals("email")) {
				ministrante.setEmail(request.getParameter(campo));
			} else if (campo.equals("numeroAlunos")) {
				curso.setNumeroAlunos(request.getParameter(campo));
			} else if (campo.equals("cursosPertence")) {
				curso.setCursoPertence(request.getParameter(campo));
			} else if (campo.equals("duracaoCurso")) {
				curso.setDuracaoCurso(request.getParameter(campo));
			} else if (campo.equals("finalidade")) {
				curso.setFinalidade(request.getParameter(campo) == null ? ""
						: request.getParameter(campo));
			} else if (campo.equals("pago")) {
				curso.setCursoPago(request.getParameter(campo));
			} else if (campo.equals("softwareNecessario")) {
				curso
						.setSoftwareNecessario(request.getParameter(campo) == null ? ""
								: request.getParameter(campo));
			} else if (campo.equals("publicoAlvo")) {
				curso.setPublicoAlvo(request.getParameter(campo) == null ? ""
						: request.getParameter(campo));
			} else if (campo.equals("cursoNoturno")) {
				cursoPodeSerNoturno = request.getParameter(campo);
			} else if (campo.equals("justificativaNoturno")) {
				String verificaCurso = request.getParameter("cursoNoturno");
				if (verificaCurso != null) {
					if (!verificaCurso.equalsIgnoreCase("SIM")) {
						if (request.getParameter(campo).length() < 10) {
							justificativaNoturno = "Não há justificativa sobre o curso ser noturno";
						} else {
							justificativaNoturno = "Justificativa: "
									+ request.getParameter(campo);
						}
					} else {
						justificativaNoturno = " ";
					}
				} else {
					justificativaNoturno = "";
				}
			} else if (campo.equals("cursoSabado")) {
				cursoPodeSerNoSabado = request.getParameter(campo);
			} else if (campo.equals("justificativaSabado")) {
				String verificaCurso = request.getParameter("cursoSabado");
				if (verificaCurso != null) {
					if (!verificaCurso.equalsIgnoreCase("SIM")) {
						if (request.getParameter(campo).length() < 10) {
							justificativaSabado = "Não há justificativa sobre o curso ser realizado aos sábados";
						} else {
							justificativaSabado = "Justificativa: "
									+ request.getParameter(campo);
						}
					} else {
						justificativaSabado = " " + request.getParameter(campo);
					}
				} else {
					justificativaSabado = "";
				}
			} else if (campo.equals("turnoSabado")) {
				String verificaCurso = request.getParameter("cursoSabado");
				if (verificaCurso != null) {
					if (verificaCurso.equalsIgnoreCase("SIM")) {
						turnoSabado = "Turno: " + request.getParameter(campo);
					} else {
						turnoSabado = " ";
					}
				} else {
					turnoSabado = " ";
				}
			} else if (campo.equals("contribuicao")) {
				contribuicao = request.getParameter(campo) == null ? ""
						: request.getParameter(campo);
			} else if (campo.equals("dia1")) {
				horario1.setDia(request.getParameter(campo));
			} else if (campo.equals("inicio1")) {
				horario1.setInicio(request.getParameter(campo));
			} else if (campo.equals("fim1")) {
				horario1.setFim(request.getParameter(campo));
			} else if (campo.equals("dia2")) {
				horario2.setDia(request.getParameter(campo));
			} else if (campo.equals("inicio2")) {
				horario2.setInicio(request.getParameter(campo));
			} else if (campo.equals("fim2")) {
				horario2.setFim(request.getParameter(campo));
			} else if (campo.equals("dia3")) {
				horario3.setDia(request.getParameter(campo));
			} else if (campo.equals("inicio3")) {
				horario3.setInicio(request.getParameter(campo));
			} else if (campo.equals("fim3")) {
				horario3.setFim(request.getParameter(campo));
			} else if (campo.equals("duracaoCurso")) {
				curso.setDuracaoCurso(request.getParameter(campo) == null ? ""
						: request.getParameter(campo));
			}
		}
	}

	/**
	 * @return Returns o contribuicao.
	 */
	public String getContribuicao() {
		return contribuicao;
	}

	/**
	 * @param contribuicao
	 *            o contribuicao a ser modificado.
	 */
	public void setContribuicao(String contribuicao) {
		this.contribuicao = contribuicao;
	}

	/**
	 * Determina se o curso pode ser realizado aos sábados.
	 * 
	 * @return true se puder ser aos sábados e false e caso contrário.
	 */
	public boolean isCursoNoturno() {
		boolean infoCursoNoturno = true;
		if (cursoPodeSerNoturno == null) {
			infoCursoNoturno = false;
		} else if (cursoPodeSerNoturno.equalsIgnoreCase("NAO")) {
			infoCursoNoturno = false;
		}
		return infoCursoNoturno;
	}

	/**
	 * Determina se o curso pode ser noturno.
	 * 
	 * @return true se o curso puder ser noturno e false e caso contrário.
	 */
	public String getExplicacaoCursoNoturno() {
		String infoCursoNoturno = "";
		if (cursoPodeSerNoturno == null) {
			infoCursoNoturno = "Nada foi declarado sobre a realizacao do curso à noite.";
		} else if (cursoPodeSerNoturno.equalsIgnoreCase("SIM")) {
			infoCursoNoturno = "O curso pode ser realizado à noite.";
		} else {
			infoCursoNoturno = "O curso NAO pode ser realizado à noite.";
		}
		return infoCursoNoturno;
	}

	/**
	 * @return Returns o cursoNoturno.
	 */
	public boolean isCursoSabado() {
		boolean infoCursoSabado = true;
		if (cursoPodeSerNoSabado == null) {
			infoCursoSabado = false;
		} else if (cursoPodeSerNoSabado.equalsIgnoreCase("NAO")) {
			infoCursoSabado = false;
		}
		return infoCursoSabado;
	}

	/**
	 * @return Returns o cursoSabado.
	 */
	public String getExplicacaoCursoSabado() {
		String infoCursoSabado = "";
		if (cursoPodeSerNoSabado == null) {
			infoCursoSabado = "Nada foi declarado sobre a realizacao do curso aos sábados.";
		} else if (cursoPodeSerNoSabado.equalsIgnoreCase("SIM")) {
			infoCursoSabado = "O curso pode ser realizado aos sábados.";
		} else {
			infoCursoSabado = "O curso NÃO pode ser realizado aos sábados.";
		}
		return infoCursoSabado;
	}

	/**
	 * @param cursoSabado
	 *            o cursoSabado a ser modificado.
	 */
	public void setCursoPodeSerNoSabado(String cursoSabado) {
		this.cursoPodeSerNoSabado = cursoSabado;
	}

	/**
	 * @return Returns o justificativaNoturno.
	 */
	public String getJustificativaNoturno() {
		return justificativaNoturno;
	}

	/**
	 * @param justificativaNoturno
	 *            o justificativaNoturno a ser modificado.
	 */
	public void setJustificativaNoturno(String justificativaNoturno) {
		this.justificativaNoturno = justificativaNoturno;
	}

	/**
	 * @return Returns o justificativaSabado.
	 */
	public String getJustificativaSabado() {
		return justificativaSabado;
	}

	/**
	 * @param justificativaSabado
	 *            o justificativaSabado a ser modificado.
	 */
	public void setJustificativaSabado(String justificativaSabado) {
		this.justificativaSabado = justificativaSabado;
	}

	/**
	 * @return Returns o numeroMaquinas.
	 */
	public int getNumeroMaquinas() {
		return numeroMaquinas;
	}

	/**
	 * @param numeroMaquinas
	 *            o numeroMaquinas a ser modificado.
	 */
	public void setNumeroMaquinas(int numeroMaquinas) {
		this.numeroMaquinas = numeroMaquinas;
	}

	/**
	 * @return Returns o turnoSabado.
	 */
	public String getTurnoSabado() {
		return turnoSabado;
	}

	/**
	 * @param turnoSabado
	 *            o turnoSabado a ser modificado.
	 */
	public void setTurnoSabado(String turnoSabado) {
		this.turnoSabado = turnoSabado;
	}

	public String getRelatorio() {
		String texto = "        Solicitação de Laboratório"
				+ NOVALINHA
				+ NOVALINHA
				+ NOVALINHA
				+ "Foi solicitado por "
				+ ministrante.getNome()
				+ ", e-mail "
				+ ministrante.getEmail()
				+ ", um laboratório no bloco REENGE para que este lecione o curso "
				+ curso.getNomeCurso() + ". Este pertence ao(s) curso(s) "
				+ curso.getCursoPertence() + " e terá duração de "
				+ curso.getDuracaoCurso()
				+ ". É necessário um laboratório nos horários: "
				+ getHorarioSemanal() + ", o laboratório deverá comportar "
				+ curso.getNumeroAlunos() + " alunos e possuir "
				+ numeroMaquinas + " máquinas." + NOVALINHA + "* Finalidade: "
				+ NOVALINHA + curso.getFinalidade() + NOVALINHA
				+ curso.getExplicacaoPago() + NOVALINHA
				+ "* Software Necessários:" + NOVALINHA
				+ curso.getSoftwareNecessario() + NOVALINHA
				+ "* Público Alvo: " + NOVALINHA + curso.getPublicoAlvo()
				+ NOVALINHA + getExplicacaoCursoNoturno() + NOVALINHA
				+ justificativaNoturno + NOVALINHA + getExplicacaoCursoSabado()
				+ NOVALINHA + justificativaSabado + NOVALINHA + turnoSabado
				+ NOVALINHA + "* Forma de contribuição: " + contribuicao
				+ NOVALINHA + NOVALINHA + NOVALINHA
				+ "A solicitação foi realizada em " + dataDeCriacao + ".";
		return texto;
	}

	/**
	 * Determina o horario semanal do curso.
	 * 
	 * @return Horario semanal do curso.
	 */
	public String getHorarioSemanal() {
		String inicio = horario1.isIncompleto() ? "" : horario1.toString();
		String meio = horario2.isIncompleto() ? "" : ", " + horario2.toString();
		String fim = horario3.isIncompleto() ? "" : ", " + horario3.toString();
		return inicio + meio + fim;
	}

	/**
	 * @return Returns the horario1.
	 */
	public HorarioSemanal getHorario1() {
		return horario1;
	}

	/**
	 * @param horario
	 *            The horario1 to set.
	 */
	public void setHorario1(HorarioSemanal horario) {
		this.horario1 = horario;
	}

	/**
	 * @return Returns the horario2.
	 */
	public HorarioSemanal getHorario2() {
		return horario2;
	}

	/**
	 * @param horario
	 *            The horario2 to set.
	 */
	public void setHorario2(HorarioSemanal horario) {
		this.horario2 = horario;
	}

	/**
	 * @return Returns the horario3.
	 */
	public HorarioSemanal getHorario3() {
		return horario3;
	}

	/**
	 * @param horario
	 *            The horario3 to set.
	 */
	public void setHorario3(HorarioSemanal horario) {
		this.horario3 = horario;
	}

	/**
	 * @return Returns the cursoNoturno.
	 */
	public String getCursoPodeSerNoturno() {
		return cursoPodeSerNoturno;
	}

	/**
	 * @param cursoNoturno
	 *            The cursoNoturno to set.
	 */
	public void setCursoPodeSerNoturno(String cursoNoturno) {
		this.cursoPodeSerNoturno = cursoNoturno;
	}

	/**
	 * @return Returns the cursoSabado.
	 */
	public String getCursoPodeSerNoSabado() {
		return cursoPodeSerNoSabado;
	}

	/**
	 * @return Returns the dataCriacao.
	 */
	public String getDataDeCriacao() {
		return dataDeCriacao;
	}

	/**
	 * @param dataCriacao
	 *            The dataCriacao to set.
	 */
	public void setDataDeCriacao(String dataCriacao) {
		this.dataDeCriacao = dataCriacao;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the ministrante
	 */
	public Ministrante getMinistrante() {
		return ministrante;
	}

	/**
	 * @param ministrante
	 *            the ministrante to set
	 */
	public void setMinistrante(Ministrante ministrante) {
		this.ministrante = ministrante;
	}

	/**
	 * @return the codigoSolab
	 */
	public Long getCodigoSolab() {
		return codigoSolab;
	}

	/**
	 * @param idLab
	 *            the codigoSolab to set
	 */
	public void setCodigoSolab(Long idLab) {
		this.codigoSolab = idLab;
	}
}
