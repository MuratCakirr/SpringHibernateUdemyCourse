package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;

            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " +instructor);

            System.out.println("luv2code: Courses: " + instructor.getCourses());

            session.getTransaction().commit();

            session.close();

            System.out.println("\nluv2code: The session is now closed!\n");



            System.out.println("luv2code: Courses: " + instructor.getCourses());

            System.out.println("luv2code: Done!");

        }
        finally {
            session.close();

            sessionFactory.close();
        }
    }
}
