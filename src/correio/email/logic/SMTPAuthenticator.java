package correio.email.logic;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * Classe que autentica o usuario no SMTP
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 *
 */
public class SMTPAuthenticator extends Authenticator {
	private String username;
	private String password;
	/**
	 * Contrutor da classe que autentica o SMTP
	 * @param username
	 * @param password
	 */
	public SMTPAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	/**
	 * Autentica o SMTP passando-lhe o username e o password
	 */
	public  PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);     }
}

