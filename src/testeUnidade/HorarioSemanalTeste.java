package testeUnidade;

/**
* Classe de Teste
* @author Romulo Calado
* @author Rodrigo Lopes
* @author Hamon Barros
* */

import junit.framework.TestCase;
import formulario.logic.HorarioSemanal;


public class HorarioSemanalTeste extends TestCase{
		//Atributos
	HorarioSemanal hs = new HorarioSemanal("Seg","7","10");
	HorarioSemanal hs1 = new HorarioSemanal("","","");
	
	/**
	 * Testa getDia()
	 */
	public void testGetDia(){
		assertEquals("Seg",hs.getDia());
		assertEquals("",hs1.getDia());
	}
	
	/**
	 * Testa setDia()
	 */
	public void testSetDia(){
		hs.setDia("Ter");
		assertEquals("Ter",hs.getDia());
		hs.setDia("");
		assertEquals("",hs.getDia());
	}
	
	/**
	 * Testa getInicio()
	 */
	public void testGetInicio(){
		assertEquals("7",hs.getInicio());
		assertEquals("",hs1.getInicio());
	}
	
	/**
	 * Testa setInicio()
	 */
	public void testSetInicio(){
		hs.setInicio("10");
		assertEquals("10",hs.getInicio());
		hs.setInicio("");
		assertEquals("",hs.getInicio());
	}
	
	/**
	 * Testa getFim()
	 */
	public void testGetFim(){
		assertEquals("10",hs.getFim());	
		assertEquals("",hs1.getFim());
	}
	
	/**
	 * Testa setFim()
	 */
	public void testSetFim(){
		hs.setFim("12");
		assertEquals("12",hs.getFim());
		hs.setFim("");
		assertEquals("",hs.getFim());
	}
	
	/**
	 * Testa idIncompleto()
	 */
	public void testIsIncompleto(){
		assertTrue(hs1.isIncompleto());
		assertFalse(hs.isIncompleto());
	}
	
	/**
	 * Testa toString()
	 */
	public void testToString(){
		assertEquals("Seg de 7 até 10",hs.toString());
		assertEquals(" de  até ",hs1.toString());
	}

}
