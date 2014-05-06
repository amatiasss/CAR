package testeUnidade;

import junit.framework.TestCase;
import usuario.logic.Usuario;

public class UsuarioTest extends TestCase {

	Usuario usuarioTest1;

	Usuario usuarioTest2;

	protected void setUp() throws Exception {
		super.setUp();
		usuarioTest1 = new Usuario();
		usuarioTest2 = new Usuario("Nome", "email", "ramal");
	}

	public void testGetCodigoUsuario() {
		assertTrue(usuarioTest1.getCodigoUsuario() == null);
		assertTrue(usuarioTest2.getCodigoUsuario() == null);
		usuarioTest2.setCodigoUsuario(new Long(12));
		assertTrue(usuarioTest2.getCodigoUsuario().doubleValue() == 12.0);
	}

	public void testSetCodigoUsuario() {
		assertTrue(usuarioTest1.getNome() == null);
		usuarioTest1.setNome("Nome");
		assertTrue(usuarioTest1.getNome().equals("Nome"));
	}

	public void testGetEmail() {
		assertTrue(usuarioTest1.getEmail() == null);
		assertTrue(usuarioTest2.getEmail().equals("email"));
	}

	public void testSetEmail() {
		assertTrue(usuarioTest1.getEmail() == null);
		usuarioTest1.setEmail("email");
		assertTrue(usuarioTest1.getEmail().equals("email"));
	}

	public void testGetNome() {
		assertTrue(usuarioTest1.getNome() == null);
		assertTrue(usuarioTest2.getNome().equals("Nome"));
	}

	public void testSetNome() {
		assertTrue(usuarioTest1.getNome() == null);
		usuarioTest1.setNome("Nome");
		assertTrue(usuarioTest1.getNome().equals("Nome"));
	}

	public void testGetRamal() {
		assertTrue(usuarioTest1.getRamal() == null);
		assertTrue(usuarioTest2.getRamal().equals("ramal"));
	}

	public void testSetRamal() {
		assertTrue(usuarioTest1.getRamal() == null);
		usuarioTest1.setRamal("ramal");
		assertTrue(usuarioTest1.getRamal().equals("ramal"));
	}

	public void testGetRamalExistente() {
		assertTrue(usuarioTest1.getRamalExistente().equals(""));
		assertTrue(usuarioTest2.getRamalExistente().equals("ramal ramal"));
	}

	public void testSetRamalExistente() {
		assertTrue(usuarioTest1.getRamalExistente().equals(""));
		usuarioTest1.setRamal("12345");
		assertTrue(usuarioTest1.getRamalExistente().equals("ramal 12345"));
	}

}
