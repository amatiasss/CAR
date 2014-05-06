/**
 * 
 */
package testeUnidade;

import usuario.logic.Usuario;
import auto_Atendimento.logic.Outro;
import junit.framework.TestCase;

/**
 * @author ADM
 *
 */
public class OutroTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
	Outro outro; 
	Usuario usuario;
	Outro outroComentario;
	
	protected void setUp() throws Exception {
		super.setUp();
		outro = new Outro();
		usuario = new Usuario("nome", "email", "ramal");
		outroComentario = new Outro("nada não");
		outro.setUsuario(usuario);
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.Outro#getComentario()}.
	 */
	public void testGetComentario() {
		assertTrue(outro.getComentario() == null);
		assertTrue(outroComentario.getComentario().equals("nada não"));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.Outro#setComentario(java.lang.String)}.
	 */
	public void testSetComentario() {
		assertTrue(outro.getComentario() == null);
		outro.setComentario("nada mesmo");
		assertTrue(outro.getComentario().equals("nada mesmo"));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#getUsuario()}.
	 */
	public void testGetUsuario() {
		assertTrue(outro.getUsuario().equals(usuario));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#setUsuario(usuario.logic.Usuario)}.
	 */
	public void testSetUsuario() {
		assertTrue(outro.getUsuario().equals(usuario));
		Usuario usuario2 = new Usuario();
		usuario2.setNome("");
		outro.setUsuario(usuario2);
		assertTrue(outro.getUsuario().equals(usuario2));
	}

}
