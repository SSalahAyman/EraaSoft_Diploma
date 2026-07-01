package org.example;


import org.example.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Load Hibernate configuration
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // get current session
        Session session = sessionFactory.getCurrentSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Create Teacher object
        Teacher teacher = new Teacher("Salah", 18, "Cairo");

        // Save object into database
        session.save(teacher);

        // Commit Transaction
        transaction.commit();

        // Close resources
        session.close();
        sessionFactory.close();


    }
    }
