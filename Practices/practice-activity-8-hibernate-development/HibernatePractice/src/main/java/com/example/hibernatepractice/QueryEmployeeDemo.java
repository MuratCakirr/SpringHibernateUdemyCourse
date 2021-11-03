package com.example.hibernatepractice;

import com.example.hibernatepractice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee where Company='Teias'").getResultList();

            for (Employee tempEmployee : employees) {
                System.out.println(tempEmployee);
            }

            session.getTransaction().commit();

        }
        finally {
            sessionFactory.close();
        }
    }
}
