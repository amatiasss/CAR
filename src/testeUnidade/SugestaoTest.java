package testeUnidade;

import usuario.logic.Usuario;
import auto_Atendimento.logic.Sugestao;
import junit.framework.TestCase;

public class SugestaoTest extends TestCase {

	Sugestao sugestao;

	Sugestao sugestaoOutra;

	Usuario usuario;

	protected void setUp() throws Exception {
		super.setUp();
		sugestao = new Sugestao();
		sugestaoOutra = new Sugestao("nome", "email", "ramal", "nada não");
		usuario = new Usuario("nome", "email", "ramal");
		sugestao.setUsuario(usuario);
	}

	public void testGetUsuario() {
		assertTrue(sugestao.getUsuario().equals(usuario));
	}

	public void testSetUsuario() {
		assertTrue(sugestao.getUsuario().equals(usuario));
		Usuario usuario2 = new Usuario();
		usuario2.setNome("");
		sugestao.setUsuario(usuario2);
		assertTrue(sugestao.getUsuario().equals(usuario2));
	}

	public void testGetSugestao() {
		assertTrue(sugestao.getSugestao() == null);
		assertTrue(sugestaoOutra.getSugestao().equals("nada não"));
	}

	public void testSetSugestao() {
		assertTrue(sugestao.getSugestao() == null);
		sugestao.setSugestao("nada mesmo");
		assertTrue(sugestao.getSugestao().equals("nada mesmo"));
	}
	
	public void testGetRelatorio(){
		assertTrue(sugestao.getRelatorio().equals(""));
		String teste = sugestaoOutra.getRelatorio();
		assertTrue(sugestaoOutra.getRelatorio().startsWith("O(A) Sr(a) nome, com email email, ramal ramal, deixou a seguinte sugestão:"));
	}

}
