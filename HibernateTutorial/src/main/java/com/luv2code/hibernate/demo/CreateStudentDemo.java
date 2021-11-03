package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");

            Student student = new Student("Murat","Cakir","murat-cakir@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }
}
