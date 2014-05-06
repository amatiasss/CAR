/**
 * 
 */
package testeUnidade;

import usuario.logic.Usuario;
import auto_Atendimento.logic.Reclamacao;
import junit.framework.TestCase;

/**
 * Testa a classe Reclamacao
 * @author Hamon Barros, Rodrigo Lopes, Romulo Calado
 */
public class ReclamacaoTeste extends TestCase {
		
	Reclamacao rec = new Reclamacao();
	Reclamacao rec2 = new Reclamacao("joao","joao@uol.com","1245","Equipamento","Bagunçado");
	Usuario usuario = new Usuario("joao","joao@uol.com","1245");

	/* 
	 * setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for getUsuario().
	 */
	public void testGetUsuario() {
		rec.setUsuario(usuario);
		assertTrue(rec.getUsuario().equals(usuario));
	}

	/**
	 * Test method for setUsusario().
	 */
	public void testSetUsuario() {
		Usuario usuario2 = new Usuario();
		rec.setUsuario(usuario2);
		assertTrue(rec.getUsuario().equals(usuario2));
	}
	/**
	 * Test method for getDescricao().
	 */
	public void testGetDescricao() {
		assertEquals(rec.getDescricao(), null);
		assertEquals(rec2.getDescricao(), "Bagunçado");		
	}

	/**
	 * Test method for setDescricao().
	 */
	public void testSetDescricao() {
		rec.setDescricao("Com problemas");
		assertEquals(rec.getDescricao(), "Com problemas");
		rec2.setDescricao("Com problemas");
		assertEquals(rec.getDescricao(), "Com problemas");		
	}

	/**
	 * Test method for getTipo().
	 */
	public void testGetTipo() {
		assertEquals(rec.getTipo(), null);
		assertEquals(rec2.getTipo(), "Equipamento");				
	}

	/**
	 * Test method for setTipo().
	 */
	public void testSetTipo() {
		rec.setTipo("Pessoal de Apoio");
		assertEquals(rec.getTipo(), "Pessoal de Apoio");
		rec2.setTipo("Pessoal de Apoio");
		assertEquals(rec.getTipo(), "Pessoal de Apoio");		
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.Reclamacao#getRelatorio()}.
	 */
	public void testGetRelatorio() {
		assertEquals(rec.getRelatorio(), "");
		assertTrue(rec2.getRelatorio().startsWith("O(A) Sr(a) joao, com email joao@uol.com e ramal "));				
	}

}
