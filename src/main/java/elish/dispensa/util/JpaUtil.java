package elish.dispensa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JpaUtil {

	private static EntityManagerFactory emFact;
	private static EntityManager em;
	
	static{
		emFact = Persistence.createEntityManagerFactory("pers");
		em = emFact.createEntityManager();
	}
	
	public static EntityManager openConection(){
		return em;
	}
	
}
