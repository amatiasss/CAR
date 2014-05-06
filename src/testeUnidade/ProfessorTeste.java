package testeUnidade;

import formulario.salaAula.logic.Professor;
import junit.framework.TestCase;

public class ProfessorTeste extends TestCase {

	Professor p = new Professor();
	public ProfessorTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.Professor.getEmail()'
	 */
	public void testGetEmail() {
		p.setEmail(null);
		assertEquals(p.getEmail(),null);
		p.setEmail("bla@gmail.com");
		assertEquals(p.getEmail(),"bla@gmail.com");
	}

	/*
	 * Test method for 'formulario.logic.Professor.getNome()'
	 */
	public void testGetNome() {
		p.setNome(null);
		assertEquals(p.getNome(),null);
		p.setNome("Camilo");
		assertEquals(p.getNome(),"Camilo");
	}

	/*
	 * Test method for 'formulario.logic.Professor.getRamal()'
	 */
	public void testGetRamal() {
		p.setRamal(1);
		assertEquals(p.getRamal(),1);
	}

	/*
	 * Test method for 'formulario.logic.Professor.setCodigoProfessor(Long)'
	 */
	public void testSetCodigoProfessor() {
		p.setCodigoProfessor(null);
		assertEquals(p.getCodigoProfessor(),null);
		Long l = new Long(120);
		p.setCodigoProfessor(l);
		assertEquals(p.getCodigoProfessor().toString(),"120");
	}
}
