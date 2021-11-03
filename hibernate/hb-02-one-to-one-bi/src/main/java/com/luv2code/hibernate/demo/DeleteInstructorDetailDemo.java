package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 3;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

            System.out.println("Deleting tempInstructorDetail" + tempInstructorDetail);

            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();

            sessionFactory.close();
        }
    }
}
