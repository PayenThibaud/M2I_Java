package org.example;

import org.example.entity.Customer;
import org.example.entity.Sell;
import org.example.util.SellStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Customer customer = Customer.builder().firstname("toto").lastname("tutu").email("email@email.com").build();
        Sell sell = Sell.builder().sellDate(LocalDate.now()).sellStatus(SellStatus.ONGOING).build();

        List<Sell> sells = new ArrayList<>();
        sells.add(sell);
        customer.setSellList(sells);

        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
    }
}