package com.szl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by zsc on 2016/5/12.
 */
public class PersonTest {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 1; i < 10; i++) {
            Person person = new Person();
            person.setAge("" + i*2);
            person.setName("" + i);
            session.save(person);
        }
        transaction.commit();
        System.out.println();

    }
}
