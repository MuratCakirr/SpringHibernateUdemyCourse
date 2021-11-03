package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s WHERE s.lastName='Cakir'").getResultList();

            System.out.println("\n\nStudents who have last name of Cakir");
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Akbas' OR s.firstName='Koray'").getResultList();

            System.out.println("\n\nStudents who have last name of Akbas OR first name Koray");
            displayStudents(students);

            students = session.createQuery("from Student s WHERE s.email LIKE '%hotmail.com'").getResultList();

            System.out.println("\n\nStudents who email ends with hotmail.com");
            displayStudents(students);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }
}
