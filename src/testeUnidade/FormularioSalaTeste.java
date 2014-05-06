package testeUnidade;

import junit.framework.TestCase;
import formulario.logic.HorarioSemanal;
import formulario.salaAula.logic.Disciplina;
import formulario.salaAula.logic.FormularioSala;
import formulario.salaAula.logic.Professor;

public class FormularioSalaTeste extends TestCase {
	
	FormularioSala formulario = new FormularioSala();
	public FormularioSalaTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getCodigoSoAula()'
	 */
	public void testGetCodigoSoAula() {
		formulario.setCodigoSoAula(null);
		assertEquals(formulario.getCodigoSoAula(),null);
		Long l = new Long(120);
		formulario.setCodigoSoAula(l);
		assertEquals(formulario.getCodigoSoAula().toString(),l.toString());		
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getContribuicao()'
	 */
	public void testGetContribuicao() {
		formulario.setContribuicao(null);
		assertEquals(formulario.getContribuicao(),null);
		formulario.setContribuicao("bla bla");
		assertEquals(formulario.getContribuicao(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getEquipamentosFrequentes()'
	 */
	public void testGetEquipamentosFrequentes() {
		formulario.setEquipamentosFrequentes(null);
		assertEquals(formulario.getEquipamentosFrequentes(),null);
		formulario.setEquipamentosFrequentes("bla bla");
		assertEquals(formulario.getEquipamentosFrequentes(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.setEquipamentosFrequentes(String)'
	 */
	public void testSetEquipamentosFrequentes() {

	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getEquipamentosIndispensaveis()'
	 */
	public void testGetEquipamentosIndispensaveis() {
		formulario.setEquipamentosIndispensaveis(null);
		assertEquals(formulario.getEquipamentosIndispensaveis(),null);
		formulario.setEquipamentosIndispensaveis("bla bla");
		assertEquals(formulario.getEquipamentosIndispensaveis(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getEquipamentosNaoDisponiveis()'
	 */
	public void testGetEquipamentosNaoDisponiveis() {
		formulario.setEquipamentosNaoDisponiveis(null);
		assertEquals(formulario.getEquipamentosNaoDisponiveis(),null);
		formulario.setEquipamentosNaoDisponiveis("bla bla");
		assertEquals(formulario.getEquipamentosNaoDisponiveis(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getEquipamentosNaoUtilizados()'
	 */
	public void testGetEquipamentosNaoUtilizados() {
		formulario.setEquipamentosNaoUtilizados(null);
		assertEquals(formulario.getEquipamentosNaoUtilizados(),null);
		formulario.setEquipamentosNaoUtilizados("bla bla");
		assertEquals(formulario.getEquipamentosNaoUtilizados(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getHorario1()'
	 */
	public void testGetHorario1() {
		formulario.setHorario1(null);
		assertEquals(formulario.getHorario1(),null);
		HorarioSemanal hs = new HorarioSemanal("seg","7","8");
		formulario.setHorario1(hs);
		assertEquals(formulario.getHorario1().toString(),hs.toString());
	}
	/*
	 * Test method for 'formulario.logic.FormularioSala.getJustificativaNoturna()'
	 */
	public void testGetJustificativaNoturna() {
		formulario.setJustificativaNoturna("Nada foi declarado sobre a realizacao do curso à noite.");
		assertEquals(formulario.getJustificativaNoturna(),"Nada foi declarado sobre a realizacao do curso à noite.");
		formulario.setDisciplinaPodeSerNoturno("SIM");
		formulario.setJustificativaNoturna("O curso pode ser realizado à noite.");
		assertEquals(formulario.getJustificativaNoturna(),"O curso pode ser realizado à noite.");
		formulario.setDisciplinaPodeSerNoturno("NÃO");
		formulario.setJustificativaNoturna("O curso NAO pode ser realizado à noite.");
		assertEquals(formulario.getJustificativaNoturna(),"O curso NAO pode ser realizado à noite.");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getJustificativaSabado()'
	 */
	public void testGetJustificativaSabado() {
		formulario.setJustificativaSabado("Nada foi declarado sobre a realizacao do curso nos sabados.");
		assertEquals(formulario.getJustificativaSabado(),"Nada foi declarado sobre a realizacao do curso nos sabados.");
		formulario.setDisciplinaPodeSerNoSabado("SIM");
		formulario.setJustificativaSabado("O curso pode ser realizado nos sabados.");
		assertEquals(formulario.getJustificativaSabado(),"O curso pode ser realizado nos sabados.");
		formulario.setDisciplinaPodeSerNoSabado("NÃO");
		formulario.setJustificativaSabado("O curso NAO pode ser realizado nos sabados.");
		assertEquals(formulario.getJustificativaSabado(),"O curso NAO pode ser realizado nos sabados.");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getDataDeCriacao()'
	 */
	public void testGetDataDeCriacao() {
		formulario.setDataDeCriacao(null);
		assertEquals(formulario.getDataDeCriacao(),null);
		formulario.setDataDeCriacao("25/05/2006");
		assertEquals(formulario.getDataDeCriacao(),"25/05/2006");		
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getDisciplinaPodeSerNoSabado()'
	 */
	public void testGetDisciplinaPodeSerNoSabado() {
		formulario.setDisciplinaPodeSerNoSabado("SIM");
		assertEquals(formulario.getDisciplinaPodeSerNoSabado(),"SIM");
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getDisciplinaPodeSerNoturno()'
	 */
	public void testGetDisciplinaPodeSerNoturno() {
		formulario.setDisciplinaPodeSerNoturno("SIM");
		assertEquals(formulario.getDisciplinaPodeSerNoturno(),"SIM");

	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getTurnoParaSerSabado()'
	 */
	public void testGetTurnoParaSerSabado() {
		formulario.setTurnoParaSerSabado("manha");
		assertEquals(formulario.getTurnoParaSerSabado(),"manha");		
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getDisciplina()'
	 */
	public void testGetDisciplina() {
		formulario.setDisciplina(null);
		assertEquals(formulario.getDisciplina(),null);
		Disciplina d = new Disciplina();
		d.setDisciplina("Computacao");
		formulario.setDisciplina(d);
		assertEquals(formulario.getDisciplina().getDisciplina(),"Computacao");		
	}

	/*
	 * Test method for 'formulario.logic.FormularioSala.getProfessor()'
	 */
	public void testGetProfessor() {
		formulario.setProfessor(null);
		assertEquals(formulario.getProfessor(),null);
		Professor p = new Professor();
		p.setNome("Lula");
		formulario.setProfessor(p);
		assertEquals(formulario.getProfessor().getNome(),"Lula");		
	}

}
