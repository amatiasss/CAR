package testeUnidade;

import junit.framework.TestCase;
import formulario.laboratorio.logic.Curso;
import formulario.laboratorio.logic.FormularioLaboratorio;
import formulario.laboratorio.logic.Ministrante;
import formulario.logic.HorarioSemanal;

public class FormularioLaboratorioTeste extends TestCase {

	FormularioLaboratorio formulario = new FormularioLaboratorio();
	public FormularioLaboratorioTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getContribuicao()'
	 */
	public void testGetContribuicao() {
		formulario.setContribuicao(null);
		assertEquals(formulario.getContribuicao(),null);
		formulario.setContribuicao("bla bla");
		assertEquals(formulario.getContribuicao(),"bla bla");
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.isCursoNoturno()'
	 */
	public void testIsCursoNoturno() {
		assertFalse(formulario.isCursoNoturno());
		formulario.setCursoPodeSerNoturno("SIM");
		assertTrue(formulario.isCursoNoturno());
		formulario.setCursoPodeSerNoturno("NAO");
		assertFalse(formulario.isCursoNoturno());
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getExplicacaoCursoNoturno()'
	 */
	public void testGetExplicacaoCursoNoturno() {
		assertEquals(formulario.getExplicacaoCursoNoturno(),"Nada foi declarado sobre a realizacao do curso à noite.");
		formulario.setCursoPodeSerNoturno("SIM");
		assertEquals(formulario.getExplicacaoCursoNoturno(),"O curso pode ser realizado à noite.");
		formulario.setCursoPodeSerNoturno("NÃO");
		assertEquals(formulario.getExplicacaoCursoNoturno(),"O curso NAO pode ser realizado à noite.");
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.isCursoSabado()'
	 */
	public void testIsCursoSabado() {
		assertFalse(formulario.isCursoSabado());
		formulario.setCursoPodeSerNoSabado("SIM");
		assertTrue(formulario.isCursoSabado());
		formulario.setCursoPodeSerNoSabado("NAO");
		assertFalse(formulario.isCursoSabado());
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getExplicacaoCursoSabado()'
	 */
	public void testGetExplicacaoCursoSabado() {
		assertEquals(formulario.getExplicacaoCursoSabado(),"Nada foi declarado sobre a realizacao do curso aos sábados.");
		formulario.setCursoPodeSerNoSabado("SIM");
		assertEquals(formulario.getExplicacaoCursoSabado(),"O curso pode ser realizado aos sábados.");
		formulario.setCursoPodeSerNoSabado("NÃO");
		assertEquals(formulario.getExplicacaoCursoSabado(),"O curso NÃO pode ser realizado aos sábados.");
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getNumeroMaquinas()'
	 */
	public void testGetNumeroMaquinas() {
		formulario.setNumeroMaquinas(1);
		assertEquals(formulario.getNumeroMaquinas(),1);		
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getTurnoSabado()'
	 */
	public void testGetTurnoSabado() {
		formulario.setTurnoSabado(null);
		assertEquals(formulario.getTurnoSabado(),null);
		formulario.setTurnoSabado("Manha");
		assertEquals(formulario.getTurnoSabado(),"Manha");
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getHorarioSemanal()'
	 */
	public void testGetHorarioSemanal() {
		formulario.setHorario1(null);
		assertEquals(formulario.getHorario1(),null);
		HorarioSemanal hs = new HorarioSemanal("seg","7","8");
		formulario.setHorario1(hs);
		assertEquals(formulario.getHorario1().toString(),hs.toString());
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getDataDeCriacao()'
	 */
	public void testGetDataDeCriacao() {
		formulario.setDataDeCriacao(null);
		assertEquals(formulario.getDataDeCriacao(),null);
		formulario.setDataDeCriacao("25/05/2006");
		assertEquals(formulario.getDataDeCriacao(),"25/05/2006");		
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getDisciplinaPodeSerNoSabado()'
	 */
	public void testGetCursoPodeSerNoSabado() {
		formulario.setCursoPodeSerNoSabado("SIM");
		assertEquals(formulario.getCursoPodeSerNoSabado(),"SIM");
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getDisciplinaPodeSerNoturno()'
	 */
	public void testGetCursoPodeSerNoturno() {
		formulario.setCursoPodeSerNoturno("SIM");
		assertEquals(formulario.getCursoPodeSerNoturno(),"SIM");

	}
	
	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getCurso()'
	 */
	public void testGetCurso() {
		formulario.setCurso(null);
		assertEquals(formulario.getCurso(),null);
		Curso c = new Curso();
		c.setNomeCurso("Computacao");
		formulario.setCurso(c);
		assertEquals(formulario.getCurso().getNomeCurso(),"Computacao");		
	}

	/*
	 * Test method for 'formulario.logic.FormularioLaboratorio.getMinistrante()'
	 */
	public void testGetMinistrante() {
		formulario.setMinistrante(null);
		assertEquals(formulario.getMinistrante(),null);
		Ministrante m = new Ministrante();
		m.setNome("Lula");
		formulario.setMinistrante(m);
		assertEquals(formulario.getMinistrante().getNome(),"Lula");		
	}

}
