/**
 * 
 */
package testeUnidade;

import junit.framework.TestCase;
import usuario.logic.Usuario;
import formulario.servico.logic.InstalacaoSoftware;

/**
 * @author ADM
 *
 */
public class InstalacaoSoftwareTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
	
	InstalacaoSoftware install;
	InstalacaoSoftware installComParametro;
	Usuario usuario;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		install = new InstalacaoSoftware();
		installComParametro = new InstalacaoSoftware("www.lcc.ufcg.edu.br", "windows", "no lcc");
		usuario = new Usuario("nome", "email", "ramal");
		install.setUsuario(usuario);
	}

	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#getLink()}.
	 */
	public void testGetLink() {
		assertEquals("1",installComParametro.getLink(), "www.lcc.ufcg.edu.br");
	}

	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#setLink(java.lang.String)}.
	 */
	public void testSetLink() {
		assertTrue(install.getLink() == null);
		install.setLink("www.dsc.ufcg.edu.br");
		assertEquals("2", install.getLink(), "www.dsc.ufcg.edu.br");
	}
	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#getLink()}.
	 */
	public void testGetLocalInstalacao() {
		assertEquals("1",installComParametro.getLocalInstalacao(), "no lcc");
	}

	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#setLink(java.lang.String)}.
	 */
	public void testSetLocalInstalacao() {
		assertTrue(install.getLocalInstalacao() == null);
		install.setLocalInstalacao("no dsc");
		assertEquals("2", install.getLocalInstalacao(), "no dsc");
	}

	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#getNomeSoftware()}.
	 */
	public void testGetNomeSoftware() {
		assertEquals("1",installComParametro.getNomeSoftware(), "windows");
	}

	/**
	 * Test method for {@link formulario.servico.logic.InstalacaoSoftware#setNomeSoftware(java.lang.String)}.
	 */
	public void testSetNomeSoftware() {
		assertTrue(install.getNomeSoftware() == null);
		install.setNomeSoftware("linux");
		assertEquals("2", install.getNomeSoftware(), "linux");
		
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#getUsuario()}.
	 */
	public void testGetUsuario() {
		assertTrue(install.getUsuario().equals(usuario));
	}

	/**
	 * Test method for {@link auto_Atendimento.logic.AutoAtendimento#setUsuario(usuario.logic.Usuario)}.
	 */
	public void testSetUsuario() {
		assertTrue(install.getUsuario().equals(usuario));
		Usuario usuario2 = new Usuario();
		usuario2.setNome("");
		install.setUsuario(usuario2);
		assertTrue(install.getUsuario().equals(usuario2));
	}

}
