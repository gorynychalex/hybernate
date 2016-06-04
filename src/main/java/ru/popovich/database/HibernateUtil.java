package ru.popovich.database;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.lang.annotation.Annotation;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            SessionFactory sessionFactory = new Configuration().configure()
//                    .configure("/ru/popovich/database/User.hbm.xml")
//                    .addResource("/ru/popovich/database/User.hbm.xml")
                    .buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

//    SessionFactory sessionFactory;
//        DBPSQLConnect dbpsqlConnect = new DBPSQLConnect();
//        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        try {
//            sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//
//            session.getTransaction().commit();
//            session.close();
//
//        } catch (Exception e){
//            e.printStackTrace();
//            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//        }

}

