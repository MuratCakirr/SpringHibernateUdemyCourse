package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                                        "JOIN FETCH i.courses " +
                                        "where i.id=:theInstructorId",
                            Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " +instructor);

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
