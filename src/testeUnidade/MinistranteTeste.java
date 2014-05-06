package testeUnidade;

import formulario.laboratorio.logic.Ministrante;
import junit.framework.TestCase;

public class MinistranteTeste extends TestCase {

	Ministrante m = new Ministrante();
	public MinistranteTeste(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'formulario.logic.Ministrante.getEmail()'
	 */
	public void testGetEmail() {
		m.setEmail(null);
		assertEquals(m.getEmail(),null);
		m.setEmail("bla@gmail.com");
		assertEquals(m.getEmail(),"bla@gmail.com");
	}

	/*
	 * Test method for 'formulario.logic.Ministrante.getNome()'
	 */
	public void testGetNome() {
		m.setNome(null);
		assertEquals(m.getNome(),null);
		m.setNome("Camilo");
		assertEquals(m.getNome(),"Camilo");
	}

	/*
	 * Test method for 'formulario.logic.Ministrante.getCodigoMinistrante()'
	 */
	public void testGetCodigoMinistrante() {
		m.setCodigoMinistrante(null);
		assertEquals(m.getCodigoMinistrante(),null);
		Long l = new Long(120);
		m.setCodigoMinistrante(l);
		assertEquals(m.getCodigoMinistrante().toString(),"120");
	}

}
