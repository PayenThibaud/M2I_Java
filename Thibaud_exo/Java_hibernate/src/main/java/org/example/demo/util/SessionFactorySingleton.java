package org.example.demo.util;

import lombok.Synchronized;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.transaction.Synchronization;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }
}
