package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            int studentId = 1;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            /*System.out.println("Deleting student: " + myStudent);
            session.delete(myStudent);*/

            System.out.println("Deleting student id=2");
            session.createQuery("DELETE from Student WHERE id=2").executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }
}
