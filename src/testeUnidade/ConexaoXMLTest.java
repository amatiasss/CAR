package testeUnidade;

/**
* @author Romulo Calado
* @author Rodrigo Lopes
* @author Hamon Barros
* */


import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;
import correio.email.logic.ConexaoXML;

public class ConexaoXMLTest extends TestCase {

	/*
	 * Test method for 'correio.email.logic.ConexaoXML.write(Object, String)'
	 */
	public void testWrite() {
		Set<String> setTeste = new TreeSet<String>();
		setTeste.add("teste1");
		setTeste.add("teste2");
		ConexaoXML XML = new ConexaoXML();
		String nomeArquivoXML = "teste1.teste";
		String nomeArquivoXML2 = "teste2.teste";
		
		//Testa a gravacao de um Object Set
		XML.write(setTeste, nomeArquivoXML);
		assertTrue(((Set)XML.read(nomeArquivoXML)).size() == 2);
		
		//Testa a alteracao e regravação do Object Set 
		setTeste.add("teste3");
		XML.write(setTeste, nomeArquivoXML);
		assertTrue(((Set)XML.read(nomeArquivoXML)).size() == 3);
		
		//Testa a gravacao de um Object String
		String textoTeste = "Teste";
		XML.write(textoTeste, nomeArquivoXML2);
		assertTrue(((String)XML.read(nomeArquivoXML2)).equals(textoTeste));
	}

	/*
	 * Test method for 'correio.email.logic.ConexaoXML.read(String)'
	 */
	public void testRead() {
		String nomeArquivoXML = "teste1.teste";
		ConexaoXML XML = new ConexaoXML();
		String teste = "Teste";
		
		//Testa a leitura de um Object String
		XML.write(teste, nomeArquivoXML);
		assertTrue(((String)(XML.read(nomeArquivoXML))).equals(teste));
		
		teste = teste + teste;
		//Testa apos a regravacao do mesmo Object
		XML.write(teste, nomeArquivoXML);
		assertTrue(((String)(XML.read(nomeArquivoXML))).equals(teste));
		
		//Testa a leitura de outro Object
		HashMap hashmap = new HashMap();
		XML.write(hashmap, nomeArquivoXML);
		assertTrue(((HashMap)XML.read(nomeArquivoXML)).size() == 0);
	}

}
