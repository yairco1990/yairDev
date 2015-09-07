package dal.connectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class HibernateConnector {
    private static SessionFactory sessionFactory;
    static Logger log = Logger.getLogger(HibernateConnector.class.getName());

    //
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();


//            File file = new File("file://../../GoTimeServices/src/main/webapp/WEB-INF/classes/hibernate.cfg.xml");
//            System.out.println("file" + file.exists());


            //configuration.configure(file);
            configuration.configure("hibernate.cfg.xml");

            System.out.println("Hibernate Configuration loaded");


            //apply configuration property settings to StandardServiceRegistryBuilder
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);


            return sessionFactory;
        } catch (HibernateException ex) {
            log.error("Initial SessionFactory creation failed. May be a DB user privilage problem? :" + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            log.error("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public synchronized static Session getSession() {
        return getSessionFactory().openSession();
    }

}