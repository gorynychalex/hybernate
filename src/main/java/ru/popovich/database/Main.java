package ru.popovich.database;

import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.hibernate.HibernateUtil;
import net.sf.ehcache.search.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.ehcache.internal.util.HibernateEhcacheUtils;
import java.util.List;
import org.hibernate.mapping.MetadataSource;

import java.sql.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){

        Service service = new Service("ServiceForIvanov",4.340F,9.9F);
        User user = new User("Ivan", "Ivanov", "123456",service);


//        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().addClass(User.class);
        SessionFactory sessionFactory = new ru.popovich.database.HibernateUtil().getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.save(user);
//
//        session.save(service);
//        session.save(user);
//        transaction.commit();

        org.hibernate.Query qusers = session.createQuery("FROM User");
        List<User> userList = ( List<User>) qusers.list();
        for(User user1 : userList){
            System.out.println(user1.getFirstname());
            System.out.println(user1.getLastname());
        }

        org.hibernate.Query qservice = session.createQuery("FROM Service");
        List<Service> serviceList = qservice.list();
        for(Service service1 : serviceList){
            System.out.println(service1.getName());
            System.out.println(service1.getPrice());
        }
//        System.out.println(qusers.getFirstResult());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
