/**
 * 
 */
package testeUnidade;

import junit.framework.TestCase;
import usuario.logic.Usuario;
import formulario.servico.logic.Manutencao;

/**
 * @author ADM
 *
 */
public class ManutencaoTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
	Manutencao manutencao;
	Manutencao manutencaoOutra;
	Usuario usuario;
	
	protected void setUp() throws Exception {
		super.setUp();
		manutencao = new Manutencao();
		manutencaoOutra = new Manutencao("REDE", "qualquer");
		usuario = new Usuario("nome", "email", "ramal");
		manutencao.setUsuario(usuario);
		
	}

	/**
	 * Test method for {@link formulario.servico.logic.Manutencao#getDescricao()}.
	 */
	public void testGetDescricao() {
		assertEquals("1",manutencaoOutra.getDescricao(), "qualquer");
	}

	/**
	 * Test method for {@link formulario.servico.logic.Manutencao#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		assertTrue(manutencao.getDescricao() == null);
		manutencao.setDescricao("troquei");
		assertEquals("2", manutencao.getDescricao(), "troquei");
	}

	/**
	 * Test method for {@link formulario.servico.logic.Manutencao#getTipo()}.
	 */
	public void testGetTipo() {
		assertEquals("1",manutencaoOutra.getTipo(), "REDE");
	}

	/**
	 * Test method for {@link formulario.servico.logic.Manutencao#setTipo(java.lang.String)}.
	 */
	public void testSetTipo() {
		assertTrue(manutencao.getTipo() == null);
		manutencao.setTipo("MAQUINA");
		assertEquals("2", manutencao.getTipo(), "MAQUINA");
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#getUsuario()}.
	 */
	public void testGetUsuario() {
		assertTrue(manutencao.getUsuario().equals(usuario));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#setUsuario(usuario.logic.Usuario)}.
	 */
	public void testSetUsuario() {
		assertTrue(manutencao.getUsuario().equals(usuario));
		Usuario usuario2 = new Usuario();
		usuario2.setNome("");
		manutencao.setUsuario(usuario2);
		assertTrue(manutencao.getUsuario().equals(usuario2));
	}

}
