/**
 * 
 */
package formulario.logic;

/**
 * Horario classe que representa um horario semanal.
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 * */

public class HorarioSemanal {
	
	private String dia = "";
	private String inicio = "";
	private String fim = "";
	
	private Long codigoHorario;
	
	public HorarioSemanal() {
	}

	public HorarioSemanal(String dia, String inicio, String fim) {
		this.dia = dia;
		this.inicio = inicio;
		this.fim = fim;
	}

	/*public HorarioSemanal(String horario) {
		this.dia = horario.substring(0,3);
		this.inicio = horario.substring(8,10);
		this.fim = horario.substring(15, 17);
	}*/

	/**
	 * @return Returns o dia.
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * @param dia o dia to set.
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}

	/**
	 * @return Returns o fim.
	 */
	public String getFim() {
		return fim;
	}

	/**
	 * @param fim o fim to set.
	 */
	public void setFim(String fim) {
		this.fim = fim;
	}

	/**
	 * @return Returns o inicio.
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * @param inicio o inicio a ser modificado.
	 */
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	
	/**
	 * Determina se o horario esta preenchido.
	 * @return true se dia, inicio e fim não foram preenchido e false em caso contrário.
	 */
	public boolean isIncompleto(){
		return dia.equals("") || inicio.equals("") || fim.equals("");  
	}

	public String toString(){
		return dia + " de " + inicio + " até " + fim;
	}

	/**
	 * @return the codigoHorario
	 */
	public Long getCodigoHorario() {
		return codigoHorario;
	}

	/**
	 * @param idHorario the codigoHorario to set
	 */
	public void setCodigoHorario(Long idHorario) {
		this.codigoHorario = idHorario;
	}


}
