/**
 * 
 */
package testeUnidade;

import usuario.logic.Usuario;
import formulario.servico.logic.ServicoConta;
import junit.framework.TestCase;

/**
 * @author ADM
 *
 */
public class ServicoContaTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
	
	ServicoConta servico;
	ServicoConta servicoConta;
	Usuario usuario;
	
	protected void setUp() throws Exception {
		super.setUp();
		servico = new ServicoConta();
		servicoConta = new ServicoConta("ABERTURA","Passei no vestibular", "romulo");
		usuario = new Usuario("nome", "email", "ramal");
		servico.setUsuario(usuario);
		
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#getConta()}.
	 */
	public void testGetConta() {
		assertEquals("1",servicoConta.getConta(), "romulo");
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#setConta(java.lang.String)}.
	 */
	public void testSetConta() {
		assertTrue(servico.getConta()== null);
		servico.setConta("troquei");
		assertEquals("2", servico.getConta(), "troquei");
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#getJustificativa()}.
	 */
	public void testGetJustificativa() {
		assertEquals("1",servicoConta.getJustificativa(), "Passei no vestibular");
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#setJustificativa(java.lang.String)}.
	 */
	public void testSetJustificativa() {
		assertTrue(servico.getJustificativa()== null);
		servico.setJustificativa("troquei");
		assertEquals("2", servico.getJustificativa(), "troquei");
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#getTipo()}.
	 */
	public void testGetTipo() {
		assertEquals("1",servicoConta.getTipo(), "ABERTURA");
	}

	/**
	 * Test method for {@link formulario.servico.logic.ServicoConta#setTipo(java.lang.String)}.
	 */
	public void testSetTipo() {
		assertTrue(servico.getTipo()== null);
		servico.setTipo("troquei");
		assertEquals("2", servico.getTipo(), "troquei");
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#getUsuario()}.
	 */
	public void testGetUsuario() {
		assertTrue(servico.getUsuario().equals(usuario));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#setUsuario(usuario.logic.Usuario)}.
	 */
	public void testSetUsuario() {
		assertTrue(servico.getUsuario().equals(usuario));
		Usuario usuario2 = new Usuario();
		usuario2.setNome("");
		servico.setUsuario(usuario2);
		assertTrue(servico.getUsuario().equals(usuario2));
	}

}
