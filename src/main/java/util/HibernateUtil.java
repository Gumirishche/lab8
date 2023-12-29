package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    static{
        // Loads hibernate.cfg.xml by default
        try {
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData =
                    new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {

            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    /**
     * Get session
     */
    public static Session getSession(){
        // We could also use openSession()
        return sessionFactory.openSession();
    }

    /**
     * Close session
     */
    public static void closeSession(){
        if(session != null && session.isOpen()){
            session.close();
        }
    }

    public static void closeSession(Session session){
        if(session!=null&&session.isOpen()){
            session.close();
        }
    }
}