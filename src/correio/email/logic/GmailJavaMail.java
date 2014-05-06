package correio.email.logic;

import java.io.File;
import java.security.Security;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Classe que faz a conexão com um SMTP para o envio de e-mail
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 * */
public class GmailJavaMail {

	private static final String SMTP_HOSTNAME = "smtp.gmail.com";

	private static final String SMTP_PORT = "465";

	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	/**
	 * Método de envio de e-mail com anexo.
	 * @param recipients e-mails dos destinatários.
	 * @param subject subject do e-mail.
	 * @param attachFiles anexos do e-mail.
	 * @param message corpo de mensagem do e-mail.
	 * @param from quem estah enviando.
	 * @throws MessagingException se ocorrer erro.
	 */
	public void sendSSLMessage(String recipients[], String subject,
			Set<File> attachFiles, String message, String from)
	throws MessagingException {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOSTNAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			String username = "proen.suporte";
			String password = "proen1885";
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		Address addressFrom = new InternetAddress(from);

		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		MimeBodyPart mbp = new MimeBodyPart();
		String text = "para que serve isso";
		if (text == null)
			text = "";

		mbp.setText(message);

		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp);

		/* Arquivos atachados */

		DataSource source;
		MimeBodyPart mbpFile;

		Iterator<File> it = attachFiles.iterator();
		System.out.println("tamanho = " + attachFiles.size());

		while (it.hasNext()) {
			File file = it.next();
			mbpFile = new MimeBodyPart();
			source = new FileDataSource(file.getAbsolutePath());
			mbpFile.setDataHandler(new DataHandler(source));
			mbpFile.setFileName(file.getName());
			mp.addBodyPart(mbpFile);

		}

		msg.setContent(mp);
		System.out.println("mensagem " + msg.toString());
		Transport.send(msg);
	}

}
