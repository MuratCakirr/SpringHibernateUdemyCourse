package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");

            Student student = new Student("Sadiye","Cakir","sadiye-cakir@hotmail.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete: " + myStudent);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }
}
