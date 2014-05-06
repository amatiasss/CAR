package testeUnidade;

import formulario.laboratorio.logic.Curso;
import junit.framework.TestCase;

public class CursoTeste extends TestCase {

	Curso curso = new Curso();
	
	public CursoTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.Curso.isPago()'
	 */
	public void testIsPago() {
		assertFalse(curso.isPago());
		curso.setCursoPago("SIM");
		assertTrue(curso.isPago());
		curso.setCursoPago("NAO");
		assertFalse(curso.isPago());
	}

	/*
	 * Test method for 'formulario.logic.Curso.getExplicacaoPago() and set()'
	 */
	public void testGetExplicacaoPago() {
		assertEquals(curso.getExplicacaoPago(),"Nao foi declarado se o curso será pago");
		curso.setCursoPago("SIM");
		assertEquals(curso.getExplicacaoPago(),"O curso será pago");
		curso.setCursoPago("NÃO");
		assertEquals(curso.getExplicacaoPago(),"O curso não será pago");
		
	}

	/*
	 * Test method for 'formulario.logic.Curso.getCursoPado() and set()'
	 */
	public void testGetCursoPago(){
		curso.setCursoPago(null);
		assertEquals(curso.getCursoPago(),null);
		curso.setCursoPago("Nao");
		assertEquals(curso.getCursoPago(),"Nao");
	}

	/*
	 * Test method for 'formulario.logic.Curso.getPublicoAlvo() and set()'
	 */
	public void testGetPublicoAlvo() {
		curso.setPublicoAlvo(null);
		assertEquals(curso.getPublicoAlvo(),null);
		curso.setPublicoAlvo("jovens");
		assertEquals(curso.getPublicoAlvo(),"jovens");
	}


	/*
	 * Test method for 'formulario.logic.Curso.getSoftwareNecessario() and set()'
	 */
	public void testGetSoftwareNecessario() {
		curso.setSoftwareNecessario(null);
		assertEquals(curso.getSoftwareNecessario(),null);
		curso.setSoftwareNecessario("eclipse");
		assertEquals(curso.getSoftwareNecessario(),"eclipse");		
	}

	/*
	 * Test method for 'formulario.logic.Curso.getNumeroAlunos() and set()'
	 */
	public void testGetNumeroAlunos() {
		curso.setNumeroAlunos(null);
		assertEquals(curso.getNumeroAlunos(),null);
		curso.setNumeroAlunos("10");
		assertEquals(curso.getNumeroAlunos(),"10");
	}

	/*
	 * Test method for 'formulario.logic.Curso.getNomeCurso() and set()'
	 */
	public void testGetNomeCurso() {
		curso.setNomeCurso(null);
		assertEquals(curso.getNomeCurso(),null);
		curso.setNomeCurso("java");
		assertEquals(curso.getNomeCurso(),"java");
	}

	/*
	 * Test method for 'formulario.logic.Curso.getFinalidade() and set()'
	 */
	public void testGetFinalidade() {
		curso.setFinalidade(null);
		assertEquals(curso.getFinalidade(),null);
		curso.setFinalidade("ensinar");
		assertEquals(curso.getFinalidade(),"ensinar");
	}

	/*
	 * Test method for 'formulario.logic.Curso.getCursosPertence() and set()'
	 */
	public void testGetCursosPertence() {
		curso.setCursoPertence(null);
		assertEquals(curso.getCursoPertence(),null);
		curso.setCursoPertence("computacao");
		assertEquals(curso.getCursoPertence(),"computacao");
	}

	/*
	 * Test method for 'formulario.logic.Curso.getDuracaoCurso() and set()'
	 */
	public void testGetDuracaoCurso() {
		curso.setDuracaoCurso(null);
		assertEquals(curso.getDuracaoCurso(),null);
		curso.setDuracaoCurso("10 horas");
		assertEquals(curso.getDuracaoCurso(),"10 horas");
	}


}
