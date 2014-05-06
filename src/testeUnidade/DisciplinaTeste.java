package testeUnidade;

import java.io.File;

import formulario.salaAula.logic.Disciplina;
import junit.framework.TestCase;

public class DisciplinaTeste extends TestCase {

	Disciplina disciplina = new Disciplina();
	public DisciplinaTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getDisciplina() and set()'
	 */
	public void testGetDisciplina() {
		disciplina.setDisciplina(null);
		assertEquals(disciplina.getDisciplina(),null);
		disciplina.setDisciplina("P2");
		assertEquals(disciplina.getDisciplina(),"P2");		

	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getLinkMaterial() and set()'
	 */
	public void testGetLinkMaterial() {
		disciplina.setLinkMaterial(null);
		assertEquals(disciplina.getLinkMaterial(),null);
		disciplina.setLinkMaterial("www.globo.com");
		assertEquals(disciplina.getLinkMaterial(),"www.globo.com");		
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getMaterial() and set()'
	 */
	public void testGetMaterial() {
		disciplina.setMaterial(null);
		assertEquals(disciplina.getMaterial(),null);
		disciplina.setMaterial(new File("jsp"));
		assertEquals(disciplina.getMaterial().toString(),"jsp");		
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getPeriodicidade() and set()'
	 */
	public void testGetPeriodicidade() {
		disciplina.setPeriodicidade(null);
		assertEquals(disciplina.getPeriodicidade(),null);
		disciplina.setPeriodicidade("semestral");
		assertEquals(disciplina.getPeriodicidade(),"semestral");		
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getPeriodo() and set()'
	 */
	public void testGetPeriodo() {
		disciplina.setPeriodo(null);
		assertEquals(disciplina.getPeriodo(),null);
		disciplina.setPeriodo("2006.1");
		assertEquals(disciplina.getPeriodo(),"2006.1");		
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getSalaAtual() and set()'
	 */
	public void testGetSalaAtual() {
		disciplina.setSalaAtual(null);
		assertEquals(disciplina.getSalaAtual(),null);
		disciplina.setSalaAtual("CD107");
		assertEquals(disciplina.getSalaAtual(),"CD107");		
	}

	/*
	 * Test method for 'formulario.logic.Disciplina.getTotalAlunos() and set()'
	 */
	public void testGetTotalAlunos() {
		disciplina.setTotalAlunos(null);
		assertEquals(disciplina.getTotalAlunos(),null);
		disciplina.setTotalAlunos("25");
		assertEquals(disciplina.getTotalAlunos(),"25");		
	}

}
