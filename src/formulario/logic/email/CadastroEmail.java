/**
 * Classe que representa um cadastro de emails para sala de aula, laboratório, reclamação, sugestão e outros. 
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 * */
package formulario.logic.email;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CadastroEmail {

	private Map<String, String> sala;

	private Map<String, String> laboratorio;

	private Map<String, String> reclamacao;

	private Map<String, String> outro;

	private Map<String, String> servico;

	private Map<String, String> sugestao;

	public CadastroEmail() {
		sala = new TreeMap<String, String>();
		laboratorio = new TreeMap<String, String>();
		reclamacao = new TreeMap<String, String>();
		outro = new TreeMap<String, String>();
		servico = new TreeMap<String, String>();
		sugestao = new TreeMap<String, String>();
	}

	/**
	 * @return Returns the laboratorio.
	 */
	public Map<String, String> getLaboratorio() {
		return laboratorio;
	}

	/**
	 * @param laboratorio
	 *            The laboratorio to set.
	 */
	public void setLaboratorio(Map<String, String> laboratorio) {
		this.laboratorio = laboratorio;
	}

	/**
	 * @return Returns the outro.
	 */
	public Map<String, String> getOutro() {
		return outro;
	}

	/**
	 * @param outro
	 *            The outro to set.
	 */
	public void setOutro(Map<String, String> outro) {
		this.outro = outro;
	}

	/**
	 * @return Returns the reclamacao.
	 */
	public Map<String, String> getReclamacao() {
		return reclamacao;
	}

	/**
	 * @param reclamacao
	 *            The reclamacao to set.
	 */
	public void setReclamacao(Map<String, String> reclamacao) {
		this.reclamacao = reclamacao;
	}

	/**
	 * @return Returns the sala.
	 */
	public Map<String, String> getSala() {
		return sala;
	}

	/**
	 * @param sala
	 *            The sala to set.
	 */
	public void setSala(Map<String, String> sala) {
		this.sala = sala;
	}

	/**
	 * @return Returns the servico.
	 */
	public Map<String, String> getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            The servico to set.
	 */
	public void setServico(Map<String, String> servico) {
		this.servico = servico;
	}

	/**
	 * @return Returns the sugestao.
	 */
	public Map<String, String> getSugestao() {
		return sugestao;
	}

	/**
	 * @param sugestao
	 *            The sugestao to set.
	 */
	public void setSugestao(Map<String, String> sugestao) {
		this.sugestao = sugestao;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de sala.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroSala(String nome, String email) {
		sala.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de sala.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrário
	 */
	public boolean removeCadastroSala(String nome) {
		boolean bemSucedido = true;
		try {
			sala.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de sala.
	 * 
	 * @return conjunto contendo os nomes do e-mails de sala.
	 */
	public Set<String> getNomesCadastroSala() {
		return sala.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de sala.
	 * 
	 * @return conjunto contendo os e-mails de sala.
	 */
	public Set<String> getEmailsCadastroSala() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = sala.keySet().iterator();
		while (keys.hasNext()) {
			email.add(sala.get(keys.next()));
		}
		return email;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de laboratório.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroLaboratorio(String nome, String email) {
		laboratorio.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de laboratório.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrário
	 */
	public boolean removeCadastroLaboratorio(String nome) {
		boolean bemSucedido = true;
		try {
			laboratorio.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de
	 * laboratório.
	 * 
	 * @return conjunto contendo os nomes do e-mails de laboratório.
	 */
	public Set<String> getNomesCadastroLaboratorio() {
		return laboratorio.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de
	 * laboratorio.
	 * 
	 * @return conjunto contendo os e-mails de laboratório.
	 */
	public Set<String> getEmailsCadastroLaboratorio() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = laboratorio.keySet().iterator();
		while (keys.hasNext()) {
			email.add(laboratorio.get(keys.next()));
		}
		return email;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de reclamação.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroReclamacao(String nome, String email) {
		reclamacao.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de reclamação.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrátrio
	 */
	public boolean removeCadastroReclamacao(String nome) {
		boolean bemSucedido = true;
		try {
			reclamacao.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de
	 * reclamação.
	 * 
	 * @return conjunto contendo os nomes do e-mails de reclamação.
	 */
	public Set<String> getNomesCadastroReclamacao() {
		return reclamacao.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de
	 * reclamação.
	 * 
	 * @return conjunto contendo os e-mails de reclamação.
	 */
	public Set<String> getEmailsCadastroReclamacao() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = reclamacao.keySet().iterator();
		while (keys.hasNext()) {
			email.add(reclamacao.get(keys.next()));
		}
		return email;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de serviço.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroServico(String nome, String email) {
		servico.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de serviço.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrátrio
	 */
	public boolean removeCadastroServico(String nome) {
		boolean bemSucedido = true;
		try {
			servico.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de serviço.
	 * 
	 * @return conjunto contendo os nomes do e-mails de serviço.
	 */
	public Set<String> getNomesCadastroServico() {
		return servico.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de serviço.
	 * 
	 * @return conjunto contendo os e-mails de serviço.
	 */
	public Set<String> getEmailsCadastroServico() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = servico.keySet().iterator();
		while (keys.hasNext()) {
			email.add(servico.get(keys.next()));
		}
		return email;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de outro.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroOutro(String nome, String email) {
		outro.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de outro.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrátrio
	 */
	public boolean removeCadastroOutro(String nome) {
		boolean bemSucedido = true;
		try {
			outro.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de outro.
	 * 
	 * @return conjunto contendo os nomes do e-mails de outro.
	 */
	public Set<String> getNomesCadastroOutro() {
		return outro.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de outro.
	 * 
	 * @return conjunto contendo os e-mails de outro.
	 */
	public Set<String> getEmailsCadastroOutro() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = outro.keySet().iterator();
		while (keys.hasNext()) {
			email.add(outro.get(keys.next()));
		}
		return email;
	}

	/**
	 * Adiciona um nome e email para o cadastro de emails de sugestão.
	 * 
	 * @param nome
	 *            Nome a ser cadastrado.
	 * @param email
	 *            Email a ser cadastrado.
	 */
	public void addCadastroSugestao(String nome, String email) {
		sugestao.put(nome, email);
	}

	/**
	 * Remove um registro do cadastro de emails de sugestão.
	 * 
	 * @param nome
	 *            nome do registo a ser removido.
	 * @return true se for possível remover e false em caso contrátrio
	 */
	public boolean removeCadastroSugestao(String nome) {
		boolean bemSucedido = true;
		try {
			sugestao.remove(nome);
		} catch (Exception e) {
			bemSucedido = false;
		}
		return bemSucedido;
	}

	/**
	 * Determina todos os nomes dos registros do cadastro de email de sugestão.
	 * 
	 * @return conjunto contendo os nomes do e-mails de sugestão.
	 */
	public Set<String> getNomesCadastroSugestao() {
		return sugestao.keySet();
	}

	/**
	 * Determina todos os emails dos registros do cadastro de email de sugestão.
	 * 
	 * @return conjunto contendo os e-mails de sugestão.
	 */
	public Set<String> getEmailsCadastroSugestao() {
		Set<String> email = new TreeSet<String>();
		Iterator<String> keys = sugestao.keySet().iterator();
		while (keys.hasNext()) {
			email.add(sugestao.get(keys.next()));
		}
		return email;
	}
	
	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em sala. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroSala() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroSala().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(sala.get(nome));
		}
		return lista;
	}

	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em laboratório. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroLaboratorio() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroLaboratorio().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(laboratorio.get(nome));
		}
		return lista;
	}

	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em reclamação. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroReclamacao() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroReclamacao().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(reclamacao.get(nome));
		}
		return lista;
	}

	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em sugestão. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroSugestao() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroSugestao().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(sugestao.get(nome));
		}
		return lista;
	}

	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em serviço. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroServico() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroServico().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(servico.get(nome));
		}
		return lista;
	}

	/**
	 * Determina uma lista com os nomes e emails de todos os cadastrados em outro. 
	 * @return Lista contendo os nomes e e-mails um após o outro.
	 */
	public List<String> getListaCadastroOutro() {
		List<String> lista = new ArrayList<String>();
		Iterator<String> it = getNomesCadastroOutro().iterator();
		while (it.hasNext()) {
			String nome = it.next();
			lista.add(nome);
			lista.add(outro.get(nome));
		}
		return lista;
	}

}