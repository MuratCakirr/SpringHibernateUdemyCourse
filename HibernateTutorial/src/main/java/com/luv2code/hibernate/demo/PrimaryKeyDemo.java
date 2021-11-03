package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating 3 student object...");

            Student student1 = new Student("Koray","Kundur","koray.kundur@gmail.com");
            Student student2 = new Student("Yesim","Cakir","yesim.cakir@gmail.com");
            Student student3 = new Student("Gokhan","Akbas","akbas.gokhan@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
