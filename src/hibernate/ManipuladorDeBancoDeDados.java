package hibernate;



import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManipuladorDeBancoDeDados {
	/**
	 * Constroi uma novo ManipuladorDeBancoDeDados.
	 *
	 */
	public ManipuladorDeBancoDeDados() { 
		
	}
	
	/**
	 * Inseri um objeto, que seja mapeado pelo hibernate, num banco de dados. 
	 * @param objeto Objeto a ser inserido.
	 * @param realPathContext Path onde se encontra o arquivo de configuração do hibernate. 
	 */
	public void insere(Object objeto, String realPathContext) {
		SessionFactory sf = new Configuration().configure(new File(realPathContext + "hibernate.cfg.xml")).buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tr = session.beginTransaction();
		session.save(objeto);
		tr.commit();
		session.flush();
		session.close();
	}
	

}
