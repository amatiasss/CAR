/**
 * 
 */
package formulario.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author XP
 * 
 */
public class Formulario {

	/**
	 * auto generated
	 * 
	 * @es_generated
	 */
	private Integer id;

	/**
	 * Constroi um novo formulário
	 * 
	 */
	public Formulario() {
	}

	/**
	 * Determina o horário atual.
	 * 
	 * @return a data atual do sistema.
	 */
	protected String getDataAtual() {
		// Calenário
		Date today = new Date();// instanciando o objeto Date
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss"); //
		String daytoday = df.format(today);
		return daytoday;
	}

	/**
	 * auto generated
	 * 
	 * @es_generated
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * auto generated
	 * 
	 * @es_generated
	 */
	public void setId(Integer value) {
		this.id = value;
	}
}
