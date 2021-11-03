package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
           /*Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");

           InstructorDetail tempInstructorDetail =
                   new InstructorDetail(
                           "http://www.luv2code.com/youtube",
                           "Luv 2 code!!!");*/

            Instructor tempInstructor = new Instructor("Madhy","Patel","madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Guitar");

           tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving Instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }
}
