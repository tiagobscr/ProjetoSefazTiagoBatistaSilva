package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Tiago Batista
 *
 *	A classe JPAUtil tem a funcionalidade de disponibilizar as EntityManager(conex�es com o banco de dados)
 *Tamb�m � uma classe singleton, s� vai existir uam instancia dessa classe em todo o projeto 
 *
 */
public class JpaUtil {
	
	private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("Sefaz");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }

}
